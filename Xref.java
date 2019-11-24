package driver;

import java.io.*;
import java.util.Scanner;

/**
 * Reads in the file and adds words to the tree.
 * Prints cross reference table and allows the user to query.
 * @author Noe Cebreros
 */

public class Xref {
    private ObjectBinaryTree tree = new ObjectBinaryTree();
    private PrintWriter pw;
    private final String READFILE = "getty.txt";
    private Scanner gettyRead;
    
    /**
     * Xref constructor.
     * @param pw  Takes in the PrintWriter to write to file.
     * @param gettyRead Takes in the getty file to print it.
     */
    public Xref(PrintWriter pw, Scanner gettyRead){
        this.pw = pw;
        this.gettyRead = gettyRead;
    }
    
    /**
     * Reads in the file.
     * @throws FileNotFoundException 
     */
    public void readFile() throws FileNotFoundException{
        Scanner file = new Scanner(new File(READFILE));
        Hash hash = new Hash(pw);
        
        int numLines = 0;
        
        while(file.hasNextLine()){
            numLines++;
            
            String buf = file.nextLine();
            String delim = "[ .,;:-]+";
            String[] temp = buf.split(delim);
            ObjectList[] hashTable = hash.getHashTable();
            
            for(int i = 0; i < temp.length; i++){
                int numWords = i + 1;
                if(!hash.inHashTable(temp[i],hashTable)){
                    ObjectList lineList = new ObjectList();
                    LinePosition line = new LinePosition(numLines, numWords);
                    ObjectList linePosition = new ObjectList();
                    ObjectListNode listNode = new ObjectListNode();
                    
                    listNode.setInfo(line);
                    lineList.addLast(listNode);
                    linePosition.addLast(listNode);
                    
                    tree.insertBSTDup(new Word(pw,temp[i].toLowerCase(),lineList));
                }
            }
        }
        
    }
    
    /**
     * Prints in the getty.txt file.
     * @throws FileNotFoundException 
     */
    public void printGetty() throws FileNotFoundException {
        
		int line = 1;
                System.out.println("GETTY.TXT FILE");
                pw.println("GETTY.TXT FILE");
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		
		while (gettyRead.hasNext()) {
			String word = gettyRead.nextLine();
			System.out.printf("%-3d %-2s", line, word);
			System.out.println();
			
			pw.printf("%-3d %-2s", line, word);
			pw.println();
			
			line++;
		}
		System.out.println("----------------------------------------------------------------------");
		pw.println("----------------------------------------------------------------------");
		
		gettyRead.close();
	}
    
    
    /**
     * Prints the cross reference table.
     */
    public void traverse(){
        
        System.out.println("CROSS REFERENCE TABLE\n");
        pw.println("CROSS REFERENCE TABLE\n");
        
        System.out.printf("%-13s%-7s%s\n","Word","Count","Line Number - Position");
        pw.printf("%-13s%-7s%s\n","Word","Count","Line Number - Position");
        System.out.println("-------------------------------------------------");
        pw.println("-------------------------------------------------");
        
        ObjectTreeNode node = (ObjectTreeNode)tree.getRoot();
        tree.inTrav(node);
    }
    
    /**
     * Allows the user to query until the user quits.
     */
    public void query(){
        Query query = new Query(pw);
        Scanner scanner = new Scanner(System.in);
        Scanner loop = new Scanner(System.in);
        
        String proceed;
        
        do{
            String input = "";
            System.out.println("\nPlease input the word you would like to search.");
            pw.println("\nPlease input the word you would like to search.");
            
            input = scanner.nextLine();
            pw.println(input);
            ObjectList temp = new ObjectList();
            query.search(tree, new Word(pw,input,temp));
            
            System.out.println("Enter y to search again, or any other key to exit.");
            pw.println("Enter y to search again, or any other key to exit.");
            proceed = loop.next();
            pw.println(proceed);
            
        }while(proceed.equals("y"));
    }
}
