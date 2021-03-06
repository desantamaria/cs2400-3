package src;

import java.util.Arrays;
/**
@author Daniel Santamaria
@author Renwell Queyquep
CS2400
3/22/21 
 */

/**
 * A class of nodes whose entries has at most two children.
 * One Left Child and One Right Child. 
 */

class BinaryNode<T> {
    private T data;
    private BinaryNode<T> leftChild;  // Reference to left child
    private BinaryNode<T> rightChild; // Reference to right child

    private T[] traversalArray;
    private int topIndex = 0;
    
    public BinaryNode() {
        this(null); // Call next constructor
    } // end default constructor
    
    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null); // Call next constructor
    } // end constructor
    
    public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild,
                      BinaryNode<T> newRightChild) {
        data = dataPortion;
        leftChild = newLeftChild;
        rightChild = newRightChild;
    } // end constructor
    
    /**
     * Retrieves the data portion of this node.
     *
     * @return The object in the data portion of the node.
     */
    public T getData() {
        return data;
    } // end getData
    
    /**
     * Sets the data portion of this node.
     *
     * @param newData The data object.
     */
    public void setData(T newData) {
        data = newData;
    } // end setData
    
    /**
     * Retrieves the left child of this node.
     *
     * @return A reference to this node's left child.
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    } // end getLeftChild
    
    /**
     * Sets this node’s left child to a given node.
     *
     * @param newLeftChild A node that will be the left child.
     */
    public void setLeftChild(BinaryNode<T> newLeftChild) {
        leftChild = newLeftChild;
    } // end setLeftChild
    
    /**
     * Detects whether this node has a left child.
     *
     * @return True if the node has a left child.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    } // end hasLeftChild
    
    /**
     * Retrieves the right child of this node.
     *
     * @return A reference to this node's right child.
     */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    } // end getRightChild
    
    /**
     * Sets this node’s right child to a given node.
     *
     * @param newRightChild A node that will be the right child.
     */
    public void setRightChild(BinaryNode<T> newRightChild) {
        rightChild = newRightChild;
    } // end setRightChild
    
    /**
     * Detects whether this node has a right child.
     *
     * @return True if the node has a right child.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    } // end hasRightChild
    
    /**
     * Detects whether this node is a leaf.
     *
     * @return True if the node is a leaf.
     */
    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    } // end isLeaf
    
    /**
     * A Recursion Example in the BinaryNode Class Copies the subtree rooted at
     * this node.
     *
     * @return The root of a copy of the subtree rooted at this node.
     */
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (leftChild != null)
            newRoot.setLeftChild(leftChild.copy());
        
        if (rightChild != null)
            newRoot.setRightChild(rightChild.copy());
        
        return newRoot;
    } // end copy
    
    /**
     * A Recursive Method in the BinaryNode Class prints (using post-order
     * traversal) all nodes of the subtree rooted at "this" node
     * 
     * @param node The root node from the BinaryTree to be passed through
     */
    public void postorderTraverse_binaryNodeMethod(BinaryNode<T> node) {
        if(node != null) {
            postorderTraverse_binaryNodeMethod(node.getLeftChild());
            postorderTraverse_binaryNodeMethod(node.getRightChild());
            traversalArray[topIndex] = node.getData(); // adds value to the traversalArray so it can be returned for testing.
            topIndex++; 
            System.out.println(node.getData());
        } // end if
    } // end postorderTraverse_binaryNodeMethod
    
    /**
     * Sets the index length of traversalArray using the number of nodes given by the BinaryTree.
     * @param numOfNodes numberofnodes() from binaryTree to be passed through(as an int).
     */
    public void createTraversalArray(int numOfNodes) {
        @SuppressWarnings("unchecked")
        T[] tempTraversalArray = (T[])new Object[numOfNodes];
        traversalArray = tempTraversalArray;
    }

    /**
     * returns the values of the Postorder Traversal.
     * @return a copy of traversalArray.
     */
    public T[] getTraversalArrayBinaryMethod() {
        return Arrays.copyOf(traversalArray, traversalArray.length);
    } // endTraversalArrayBinaryMethod
    
    /**
     * A Recursive Method in the BinaryNode Class Computes the height of the
     * subtree rooted at "this" node.
     *
     * @return The height of the subtree rooted at "this" node.
     */
    public int getHeight_binaryNodeMethod() {
        int height = 0; 
        int leftHeight = 0;
        int rightHeight = 0;
        
        if (data == null) {
            return 0;
        } // end if  

        if(leftChild !=null)
            leftHeight = leftChild.getHeight_binaryNodeMethod();
        if(rightChild !=null)
            rightHeight = rightChild.getHeight_binaryNodeMethod();
        
        height = 1 + Math.max(leftHeight,rightHeight);
        return height;
    } // end getHeight
    
    /**
     * A Recursive Method in the BinaryNode Class Counts the nodes in the
     * subtree rooted at "this" node.
     *
     * @return The number of nodes in the subtree rooted at "this" node.
     */
    public int getNumberOfNodes_binaryNodeMethod() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (leftChild != null)
            leftNumber = leftChild.getNumberOfNodes_binaryNodeMethod();
        if (rightChild != null)
            rightNumber = rightChild.getNumberOfNodes_binaryNodeMethod();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes
    
} // end BinaryNode
