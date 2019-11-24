package driver;

/**
 * Interface for ObjectListNode class
 * @author Noe Cebreros
 */
public interface ObjectListNodeInterface {

    /**
     *
     * @return
     */
    Object getInfo();

    /**
     *
     * @return
     */
    ObjectListNode getNext();

    /**
     *
     * @param o
     */
    void setInfo(Object o);

    /**
     *
     * @param p
     */
    void setNext(ObjectListNode p);
    
}
