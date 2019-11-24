package driver;

/**
 * Interface for ObjectList class
 * @author Noe Cebreros
 */
public interface ObjectListInterface {

    /**
     *
     * @param o
     */
    void addFirst(Object o);

    /**
     *
     * @param p
     */
    void addFirst(ObjectListNode p);

    /**
     *
     * @param o
     */
    void addLast(Object o);

    /**
     *
     * @param p
     */
    void addLast(ObjectListNode p);

    /**
     *
     */
    void clear();

    /**
     *
     * @param o
     * @return
     */
    boolean contains(Object o);

    /**
     *
     * @return
     */
    ObjectList copyList();

    /**
     *
     * @param p
     * @return
     */
    Object deleteAfter(ObjectListNode p);

    /**
     *
     * @return
     */
    Object getFirst();

    /**
     *
     * @return
     */
    ObjectListNode getFirstNode();

    /**
     *
     * @return
     */
    Object getLast();

    /**
     *
     * @return
     */
    ObjectListNode getLastNode();

    /**
     *
     * @param o
     */
    void insert(Object o);

    /**
     *
     * @param r
     */
    void insert(ObjectListNode r);

    /**
     *
     * @param p
     * @param o
     */
    void insertAfter(ObjectListNode p, Object o);

    /**
     *
     * @param p
     * @param q
     */
    void insertAfter(ObjectListNode p, ObjectListNode q);

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     *
     * @param o
     * @return
     */
    Object remove(Object o);

    /**
     *
     * @return
     */
    Object removeFirst();

    /**
     *
     * @return
     */
    Object removeLast();

    /**
     *
     */
    void reverse();

    /**
     *
     * @param o
     * @return
     */
    ObjectListNode select(Object o);

    /**
     *
     * @return
     */
    int size();
}
