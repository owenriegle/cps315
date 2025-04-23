package graphexercises;

import java.util.LinkedList;
import java.util.Queue;

/** BSTree.java */

/**
 * Binary Search Tree using generics. Type-safe and not using deprecated
 * Integer(int i) constructor
 **/
public class BSTree<E extends Comparable<E>> {

    /** BTNode<E> is an inner class (defined below) to hold tree nodes */
    BTNode<E> root;

    /**
     * constructor takes a comparable object and makes a node with this
     * object as root
     */
    public BSTree(E r) {
        root = new BTNode<E>(r);
    }

    /** Empty tree **/
    public BSTree() {
        root = null;
    }

    public void insert(E e) { // insert node with data e
        if (root == null)
            root = new BTNode<E>(e);
        else {
            insertNode(e, root);
        }
    }

    public void insertNode(E e, BTNode<E> b) {
        if (b.getData().compareTo(e) > 0) {
            if (b.left == null) {
                b.setLeft(new BTNode<E>(e));
            } else {
                insertNode(e, b.left);
            }
        } else {
            if (b.right == null) {
                b.setRight(new BTNode<E>(e));
            } else {
                insertNode(e, b.right);
            }
        }
    }

    protected int height(BTNode<E> b) { // height of the tree
        if (b == null) {
            return 0;
        }
        if (b.left == null && b.right == null) {
            return 1;
        }
        int lheight = height(b.left);
        int rheight = height(b.right);
        return 1 + Math.max(lheight, rheight);
    }

    public int height() {
        return height(this.root);
    }

    protected boolean search(E e, BTNode<E> b) {
        if (b == null) {
            return false;
        } else if (b.getData().equals(e)) {
            return true;
        } else if (b.getData().compareTo(e) > 0) {
            return search(e, b.left);
        } else
            return search(e, b.right);
    }

    public boolean search(E e) {
        return this.search(e, this.root);
    }

    /*********** In-Order Scan **********/
    protected void inorderscan(BTNode<E> b) { // in-order scan of the tree rooted at b
        if (b != null) {
            if ((b.getLeft() == null) && (b.getRight() == null)) {
                System.out.print(b.getData() + " ");
            } else {
                inorderscan(b.left);
                System.out.print(b.getData() + " ");
                inorderscan(b.right);
            }
        }
    }

    public void inorderscan() {
        this.inorderscan(this.root);
    }

    /*********** End of In-Order Scan **********/

    /*********** Pre-Order Scan **********/
    protected void preorderscan(BTNode<E> b) { // pre-order scan of the tree
        if (b != null) {
            if ((b.getLeft() == null) && (b.getRight() == null)) {
                System.out.print(b.getData() + " ");
            } else {
                System.out.print(b.getData() + " ");
                preorderscan(b.left);
                preorderscan(b.right);
            }
        }
    }

    public void preorderscan() {
        this.preorderscan(this.root);
    }

    /*********** End of Pre-Order Scan **********/

    /*********** Post-Order Scan **********/
    protected void postorderscan(BTNode<E> b) { // post-order scan of the tree
        if (b != null) {
            if ((b.getLeft() == null) && (b.getRight() == null)) {
                System.out.print(b.getData() + " ");
            } else {
                postorderscan(b.left);
                postorderscan(b.right);
                System.out.print(b.getData() + " ");
            }
        }
    }

    public void postorderscan() {
        this.postorderscan(this.root);
    }
    /*********** End of Post-Order Scan **********/
    public void levelorderscan(BTNode<E> b) { // level-order scan of the tree
        if (b != null) {
            Queue<BTNode<E>> q = new LinkedList<>();
            if ((b.getLeft() == null) && (b.getRight() == null)) {
                System.out.print(b.getData() + " ");
            } else {
            }
        }
    }

    public void levelorderscan() {
        this.levelorderscan(this.root);
    }
    /*********** Level-Order Scan **********/
    
    /*********** End Level-Order Scan **********/

    protected void findLeaves(BTNode<E> r) {
        if (r == null) {
            // System.out.println("");
            return;
        }
        if (r.left == null && r.right == null) {
            System.out.println(r);
            return;
        }
        findLeaves(r.left);
        findLeaves(r.right);
    }

    public void findLeaves() {
        this.findLeaves(root);
    }

    /** Inner class - BTNode **/
    class BTNode<E extends Comparable<E>> {
        public E data;
        public BTNode<E> left;
        public BTNode<E> right;

        public BTNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public BTNode(E data, BTNode<E> l, BTNode<E> r) {
            this.data = data;
            left = l;
            right = r;
        }

        public void setData(E data) {
            this.data = data;
        }

        public void setLeft(BTNode<E> bL) {
            this.left = bL;
        }

        public void setRight(BTNode<E> bR) {
            this.right = bR;
        }

        public E getData() {
            return data;
        }

        public BTNode<E> getLeft() {
            return left;
        }

        public BTNode<E> getRight() {
            return right;
        }

        public String toString() {
            return this.getData().toString();
        }
    }
}