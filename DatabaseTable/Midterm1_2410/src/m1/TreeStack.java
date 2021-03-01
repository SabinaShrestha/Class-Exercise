package m1;

import java.util.NoSuchElementException;

public class TreeStack {
    private int n;          // number of trees in the stack
    private Node top;       // top of stack

    private class Node {
        private Tree tree;
        private Node next;
    }

    /**
     * Initializes an empty tree stack.
     */
    public TreeStack() {
        top = null;
        n = 0;
    }

    /**
     * Checks whether the tree stack is empty.
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of trees in the tree stack.
     * @return the number of elements in the tree stack.
     */
    public int size() {
        return n;
    }

    /**
     * Adds a tree to the tree stack.
     * @param newTree the item to add
     */
    public void push(Tree newTree) {
        Node oldTop = top;
        top = new Node();
        top.tree = newTree;
        top.next = oldTop;
        n++;
    }

    /**
     * Removes and returns the tree on top of the stack (That is the last tree that was 
     * pushed on the tree stack.)
     * @return the tree that was most recently pushed on the stack
     * @throws java.util.NoSuchElementException if this tree stack is empty
     */
    public Tree pop() {
        if (isEmpty()) 
        	throw new NoSuchElementException("Can't remove a tree from an empty stack.");
        
        Tree temp = top.tree;   // save the tree to return it at the end of the method.
        top = top.next;         // remove the tree on top of the stack
        n--;

        return temp;            // return the saved tree
    }


    /**
     * Checks which tree is on top of the tree stack and returns it.
     * The tree stack is not modified in the process.
     * @return the tree most recently added to the tree stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Tree peek() {
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        
        return top.tree;
    }

}