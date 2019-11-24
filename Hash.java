package driver;

import java.io.*;

/**
 * Generates a hash table with the words to be omitted and outputs the hash table.
 * Creates an index for each word using a hash function and checks if the word is in the hash table.
 * @author Noe Cebreros
 */

public class Hash {

    private int numCollisions;
    ObjectList[] hashTable = new ObjectList[37];
    PrintWriter pw;

    /**
     * Hash constructor.
     * @param pw Takes in the PrintWriter to write to file.
     */
    public Hash(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * Returns the number of collisions.
     * @return numCollisions
     */
    public int getCollisions() {
        return (numCollisions);
    }

    /**
     * Returns a value between 0 and 36 corresponding to the location within the hash table.
     * @param s the String to hash.
     * @return integer between 0 and 36 
     */
    public static int getHash(String s) {
        String[] omitWords = {"a", "after", "all", "and", "because", "every", "for", "from", "had", "have", "in", "is", "it", "its", "now", "of", "on", "so", "that", "the", "their", "there", "to", "was", "were", "which", "with"};

        double[] omitWordsDouble = new double[27];

        for (int i = 0; i < omitWords.length; i++) {
            char[] charArray = omitWords[i].toCharArray();
            String tempString = "";

            for (int j = 0; j < charArray.length; j++) {
                tempString += (int) charArray[j];
            }

            omitWordsDouble[i] = Double.valueOf(tempString);
        }

        double stringToDouble;
        char[] charArray = s.toCharArray();
        String tempString = "";

        for (int i = 0; i < charArray.length; i++) {
            tempString += (int) charArray[i];
        }

        stringToDouble = Double.valueOf(tempString);

        int tail = 0;
        int total = 0;

        for (int i = 0; i < omitWordsDouble.length; i++) {

            int val = (int) Math.ceil((omitWordsDouble[i] % stringToDouble) / omitWordsDouble[i]);

            total += val;
            tail += ((-1 * val) + 1) * i;
        }

        int x = total - 26;
        int hashval = (int) (tail + 27 * x + ((stringToDouble * x) % 10));

        return (hashval);
    }

    /**
     * Adds the 27 unimportant words to the hash table.
     * @return the hash table
     */
    public ObjectList[] getHashTable() {
        String[] omitWords = {"a", "after", "all", "and", "because", "every", "for", "from", "had", "have", "in", "is", "it", "its", "now", "of", "on", "so", "that", "the", "their", "there", "to", "was", "were", "which", "with"};
        numCollisions = 0;

        for (String omitWord : omitWords) {
            int hashValue = getHash(omitWord);
            ObjectListNode node = new ObjectListNode();
            node.setInfo(omitWord);
            ObjectList list = new ObjectList();
            if (hashTable[hashValue] != null) {
                numCollisions++;
                list = hashTable[hashValue];
                list.addLast(node);
                hashTable[hashValue] = list;
            } else if (hashTable[hashValue] == null) {
                list.addLast(node);
                hashTable[hashValue] = list;
            }
        }
        return hashTable;
    }

    /**
     * Prints the hash table.
     */
    public void printHashTable() {
        
        System.out.println("DESCRIPTION OF MY HASH FUNCTION: ");
        System.out.println("");
        pw.println("DESCRIPTION OF MY HASH FUNCTION: ");
        pw.println("");
        System.out.println("My hash function generates a unique double for each of the words to be omitted by stringing together the integer value for each char in the word.\n"
                + "Using only mathematical operations, the hash function will assign any word on the omitted list to any of the first 27 indexes.\n"
                + "Any other words will generate a value corresponding to the remaining indexes in the hash table.\n");
        pw.println("My hash function generates a unique double for each of the words to be omitted by stringing together the integer value for each char in the word.\n"
                + "Using only mathematical operations, the hash function will assign any word on the omitted list to any of the first 27 indexes.\n"
                + "Any other words will generate a value corresponding to the remaining indexes in the hash table.\n");
        
        System.out.println("HASH TABLE CONTENTS\n");
        pw.println("HASH TABLE CONTENTS\n");
        
        System.out.printf("%-7s%s\n","Index","Value");
        pw.printf("%-7s%s\n","Index","Value");
        
        System.out.println("---------------------------");
        pw.println("---------------------------");

        for (int i = 0; i < hashTable.length; i++) {

            if (hashTable[i] == null){
                System.out.printf("%-7s%s\n",i,"NULL");
                pw.printf("%-7s%s\n",i,"NULL");

            }else{
                ObjectList tempList = hashTable[i];
                ObjectListNode tempNode = (ObjectListNode) tempList.getFirstNode();
                System.out.printf("%-7s",i);
                pw.printf("%-7s",i);

                while (tempNode != null){
                    String word = (String)tempNode.getInfo();
                    System.out.print(word + " ");
                    pw.print(word + " ");
                    tempNode = tempNode.getNext();
                }
                System.out.println();
                pw.println();
            }
        }

        Hash table = new Hash(pw);
        int colCount = table.getCollisions();

        System.out.println("\nNumber of collisions: " + colCount);
        pw.println("\nNumber of collisions: " + colCount);
        
        System.out.println("Load Factor: " + 27.0/37 + "\n");
        pw.println("Load Factor: " + 27.0/37 + "\n");
    }

    /**
     * Checks if a string is in the hash table.
     * @param s The string to check.
     * @param hash The hash table to check if the string is in.
     * @return boolean
     */
    public boolean inHashTable(String s, ObjectList hash[]) {

        ObjectList[] table = hash;
        int hashValue = getHash(s);
        ObjectList tempList = table[hashValue];

        if (tempList == null) {
            return false;
        }

        ObjectListNode node = (ObjectListNode) tempList.getFirstNode();

        while (node != null) {
            String tempString = (String)node.getInfo();
            if (tempString.equals(s)) {
                return true;
            }
            else{
                node = node.getNext();
            }
        }
        return false;
    }
}
