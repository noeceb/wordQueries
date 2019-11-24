package driver;

/**
 * ObjectBinaryTreeInterface which holds the data of the ObjectBinaryTree class.
 * @author Noe Cebreros
 */
public interface ObjectBinaryTreeInterface {
    
    /**
     *
     * @param o
     */
    void delete(Object o);

    /**
     *
     * @return
     */
    ObjectTreeNode getRoot();

    /**
     *
     * @param tree
     */
    void inTrav(ObjectTreeNode tree);

    /**
     *
     * @param o
     */
    void insertBST(Object o);

    /**
     *
     * @param o
     */
    void insertBSTDup(Object o);

    /**
     *
     * @param tree
     */
    void postTrav(ObjectTreeNode tree);

    /**
     *
     * @param tree
     */
    void preTrav(ObjectTreeNode tree);

    /**
     *
     * @param o
     * @return
     */
    ObjectTreeNode searchBST(Object o);

    /**
     *
     * @param parent
     * @param r
     */
    void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);

    /**
     *
     * @param parent
     * @param r
     */
    void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
}
