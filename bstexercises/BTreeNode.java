/* Binary Tree Node */

public class BTreeNode<E extends Comparable<E>> {
    public E data;
    public BTreeNode<E> left;
    public BTreeNode<E> right;

    public BTreeNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BTreeNode(E data, BTreeNode<E> l, BTreeNode<E> r) {
        this.data = data;
        left = l;
        right = r;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BTreeNode<E> bL) {
        this.left = bL;
    }

    public void setRight(BTreeNode<E> bR) {
        this.right = bR;
    }

    public E getData() {
        return data;
    }

    public BTreeNode<E> getLeft() {
        return left;
    }

    public BTreeNode<E> getRight() {
        return right;
    }

    public String toString() {
        return this.getData().toString();
    }
}
