package driver;

/**
 * Interface for TreeComparable.
 * @author Noe Cebreros 
 */
public interface TreeComparable {

    /**
     *
     * @param o
     * @return
     */
    int compareTo(Object o);

    /**
     *
     * @param o
     */
    void operate(Object o);

    /**
     *
     */
    void visit();
}

