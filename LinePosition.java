package driver;

/**
 * LinePosition storing the line number and the word position
 * @author Noe Cebreros
 */

public class LinePosition{
    private final int count;
    private final int position;
    
    /**
     * LinePosition constructor.
     * @param count The line number.
     * @param position The word position.
     */
    public LinePosition(int count, int position){
        this.count = count;
        this.position = position;
    }
    
    /**
     * Gets the line number.
     * @return count
     */
    public int getLineCount(){
        return(count);
    }
    
    /**
     * Gets the word position.
     * @return position
     */
    public int getLinePosition(){
        return position;
    }
}
