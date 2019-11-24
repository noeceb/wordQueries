package driver;

/**
 * Implements the ObjectListNode of a linked list.
 * @author Noe Cebreros
 */
public class ObjectListNode implements ObjectListNodeInterface {
    private Object info;
    private ObjectListNode next;

    /**
     * Default ctor    
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * One-arg ctor
     * @param o
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    

    /**
     * Two-arg ctor
     * @param o
     * @param p
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field
     * @param o
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     * Returns object in info field
     * @return info
     */
    @Override
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * @param p
     */
    @Override
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns object in info field
     * @return next
     */
    @Override
    public ObjectListNode getNext() {
        return next;
    }
}
