package driver;

/**
 * Interface for ObjectTreeNode class
 * @author Noe Cebreros
 */
public interface ObjectTreeNodeInterface {

    /**
     *
     * @return
     */
    Object getInfo();

    /**
     *
     * @return
     */
    ObjectTreeNode getLeft();

    /**
     *
     * @return
     */
    ObjectTreeNode getRight();

    /**
     *
     * @param o
     */
    void setInfo(Object o);

    /**
     *
     * @param p
     */
    void setLeft(ObjectTreeNode p);

    /**
     *
     * @param p
     */
    void setRight(ObjectTreeNode p);
}
