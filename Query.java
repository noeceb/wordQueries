package driver;

import java.io.*;

/**
 * Allows the user to query the words in the document.
 * @author Noe Cebreros
 */

public class Query {

    private final PrintWriter pw;

    /**
     * The Query constructor.
     * @param pw  Takes in the PrintWriter to write to file.
     */
    public Query(PrintWriter pw) {
        this.pw = pw;
    }

    /**
     * Allows the user to search any of the allowed words and returns the count, line number and position of the word.
     * @param tree The tree with the words and relevant information.
     * @param word The word to search,
     */
    public void search(ObjectBinaryTree tree, Word word) {
        
        ObjectTreeNode treeNode;
        ObjectListNode listNode;
        
        String[] allowedWords = {"dedicate","devotion","gave","men","not","people","resolve","soldier","us","vain","war"};
        
        treeNode = tree.searchBST(word);
        
        boolean validWord = false;
        
        for(String s: allowedWords){
            if(s.equals(word.getWord())){
                validWord = true;
                break;
            }
        }
        if (!validWord) {
            System.out.println("Invalid word. The following words are valid searches: dedicate, devotion, gave, men, not, people, resolve, soldier, us, vain, war");
            pw.println("Invalid word. The following words are valid searches: dedicate, devotion, gave, men, not, people, resolve, soldier, us, vain, war");
        }
        else if(treeNode == null){
            System.out.println("The word " + word.getWord() + " does not appear in the document.");
            pw.println("The word " + word.getWord() + " does not appear in the document.");
        }
        else {
            Word found = (Word) treeNode.getInfo();

            String tempWord = found.getWord();
            int wordCount = found.getCount();

            ObjectList lineRef = found.getLine();
            listNode = (ObjectListNode) lineRef.getFirstNode();
            
            System.out.println();
            pw.println();
            
            System.out.printf("%-13s%-7s%s\n","Word","Count","Line Number - Position");
            pw.printf("%-13s%-7s%s\n","Word","Count","Line Number - Position");
            System.out.println("-------------------------------------------------");
            pw.println("-------------------------------------------------");
            
            System.out.printf("%-13s%-7s",tempWord,wordCount);
            pw.printf("%-13s%-7s",tempWord,wordCount);
            
            while (listNode != null) {

                LinePosition temp = (LinePosition) listNode.getInfo();
                int tempLineCount = temp.getLineCount();
                int tempLinePos = temp.getLinePosition();
                
                System.out.printf("%-8s",tempLineCount + "-" + tempLinePos);
                pw.printf("%-8s",tempLineCount + "-" + tempLinePos);
                
                listNode = listNode.getNext();

            }
            
            System.out.println();
            pw.println();
        }
    }
}
