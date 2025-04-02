/*
 * binary search tree provided by professor
 * I developed the following methods:
 * 1. search()
 * 2. inOrderScan()
 * 3. preOrderScan()
 * 4. postORderScan()
 * 5. height()
 */
public class BSTree<E extends Comparable<E>> {
    BTreeNode<E> root;

    public BSTree(BTreeNode<E> r) {
        root = r;
    }

    public BSTree() {
        root = null;
    }

    public void insert(E e) { // insert node with data e
        if (root == null)
            root = new BTreeNode<>(e);
        else {
            insertNode(e, root);
        }
    }

    public void insertNode(E e, BTreeNode<E> b) { // insert node with date e with reference to root node b
        if (b.getData().compareTo(e) > 0) {
            if (b.left == null) {
                b.setLeft(new BTreeNode<>(e));
            } else {
                insertNode(e, b.left);
            }
        } else {
            if (b.right == null) {
                b.setRight(new BTreeNode<>(e));
            } else {
                insertNode(e, b.right);
            }
        }
    }

    public boolean search(E e, BTreeNode<E> b) { // searches for key e by comparing with node b
        if (b == null)
            return false;
        else if (b.getData().equals(e))
            return true;
        else if (b.getData().compareTo(e) > 0) {
            return search(e, b.left);
        } else {
            return search(e, b.right);
        }
    }

    public boolean search(E e) { // searches for key e
        return search(e, root);
    }

    public void inOrderScan(BTreeNode<E> b) {
        if (root == null) {
            System.out.println("Cannot in-order scan because binary tree is empty");
        } else if (b == null) {
            System.out.print(" ");
        } else {
            inOrderScan(b.left);
            System.out.print(b.getData() + ",");
            inOrderScan(b.right);
        }
    }

    public void preOrderScan(BTreeNode<E> b) {
        if (root == null) {
            System.out.println("Cannot pre-order scan because binary tree is empty");
        } else if (b == null) {
            System.out.print("");
        } else {
            System.out.print(b.getData() + ", ");
            preOrderScan(b.left);
            preOrderScan(b.right);
        }
    }

    public void postOrderScan(BTreeNode<E> b) {
        if (root == null) {
            System.out.println("Cannot post-order scan because binary tree is empty");
        } else if (b == null) {
            System.out.print("");
        } else {
            postOrderScan(b.left);
            postOrderScan(b.right);
            System.out.print(b.getData() + ", ");
        }
    }

    public void findLeaves() {
        this.findLeaves(root);
    }

    public void findLeaves(BTreeNode<E> r) {
        if (r == null) {
            return;
        }
        if (r.left == null && r.right == null) {
            System.out.println(r);
            return;
        }
        findLeaves(r.left);
        findLeaves(r.right);
    }

    public int height() {
        return height(this.root);
    }

    public int height(BTreeNode<E> b) { // height of the tree
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

    public void range() {
        BTreeNode<E> leftMost;
        BTreeNode<E> rightMost;
        if (root.left == null) {
            leftMost = root;
        } else {
            BTreeNode<E> tmp = root;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            leftMost = tmp;
        }
        if (root.right == null) {
            rightMost = root;
        } else {
            BTreeNode<E> tmp = root;
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            rightMost = tmp;
        }
        System.out.println("_______________ranges__________________");

        System.out.println("Smallest-->" + leftMost.data);
        System.out.println("Largest--->" + rightMost.data);

    }
}
