package driver;

/**
 * Implements the ObjectTreeNodeInterface for the ObjectTreeNode
 * @author Noe Cebreros
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * Default constructor.
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * Creates a tree node of object o.
     * @param o
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * Sets the info for the node o.
     * @param o
     */
    @Override
    public void setInfo(Object o) {
        info = o;
    }
    
    /**
     * Gets the info of the node.
     * @return info
     */
    @Override
    public Object getInfo() {
        return info;
    }
    
    /**
     * Sets the left node to p.
     * @param p
     */
    @Override
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * Gets the left node.
     * @return left
     */
    @Override
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * Sets the right node to p.
     * @param p
     */
    @Override
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * Gets the right node.
     * @return right
     */
    @Override
    public ObjectTreeNode getRight() {
        return right;
    }
}
