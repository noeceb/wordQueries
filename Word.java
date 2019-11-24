package driver;

import java.io.*;

/**
 * Stores and outputs word information.
 * @author Noe Cebreros
 */
public class Word implements Comparable, TreeComparable {
    
    private String word;
    private int count = 1;
    private ObjectList line = new ObjectList();
    PrintWriter pw;
    
    /**
     * Word constructor.
     * @param pw Takes in the PrintWriter to write to file.
     * @param word The word string.
     * @param line The ObjectList.
     */
    public Word(PrintWriter pw, String word, ObjectList line){
        this.pw = pw;
        this.word = word;
        this.line = line;
    }
    
    /**
     * Set the word string.
     * @param word the word string.
     */
    public void setWord(String word){
        this.word = word;
    }
    
    /**
     * Get the string stored on in the word.
     * @return word
     */
    public String getWord(){
        return(word);
    }
    
    /**
     * Get the count of the word.
     * @return count
     */
    public int getCount(){
        return count;
    }
    
    /**
     * Get the object list for the word.
     * @return line
     */
    public ObjectList getLine(){
        return line;
    }
    
    /**
     * Set the ObjectList for the word/
     * @param line The ObjectListo
     */
    public void setLine(ObjectList line){
        this.line = line;
    }
    
    /**
     * Compare this word to another word using the comparable interface.
     * @param o The object (word) to compare to.
     * @return -1, 0 or 1
     */
    @Override
    public int compareTo(Object o){
        Word compare = (Word)o;
        return word.compareTo(compare.getWord());
    }
    
    /**
     * Increments the word count and adds the positioning information to the end of the list.
     * @param o The object (word) to add.
     */
    @Override
    public void operate(Object o){
        Word node = (Word)o;
        this.count++;
        
        line.addLast(node.getLine().getFirstNode());
    }
    
    /**
     * Prints the word, count, and positioning information.
     */
    @Override
    public void visit(){
        ObjectList wordList = this.getLine();
        ObjectListNode node = (ObjectListNode) wordList.getFirstNode();        
        
        System.out.printf("%-13s%-7s",this.getWord(),this.getCount());
        pw.printf("%-13s%-7s",this.getWord(),this.getCount());
        
        while(node != null){
            
            LinePosition tempPosition = (LinePosition)node.getInfo();
            
            System.out.printf("%-8s",tempPosition.getLineCount() + "-" + tempPosition.getLinePosition());
            pw.printf("%-8s",tempPosition.getLineCount() + "-" + tempPosition.getLinePosition());
            
            node = node.getNext();
        }
        
        System.out.println();
        pw.println();
    }
}
