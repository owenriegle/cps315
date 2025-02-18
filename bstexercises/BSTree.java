/** Binary Tree with a single field, root of the tree */

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

    public boolean search(E e) { // searches for key e
        if (root == null)
            return false;
        else if (e.equals(root.getData()))
            return true;
        else {
            if (root.getData().compareTo(e) > 0) {
                return searchNode(e, root.left);
            } else {
                return searchNode(e, root.right);
            }
        }
    }

    public boolean searchNode(E e, BTreeNode<E> b) { // searches for key e by comparing with node b
        if (b == null)
            return false;
        else if (b.getData().equals(e))
            return true;
        else if (b.getData().compareTo(e) > 0) {
            return searchNode(e, b.left);
        } else {
            return searchNode(e, b.right);
        }
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

    public void findLeaves(BTreeNode<E> b) {
        if (root == null) {
            System.out.println("Cannot find leaves because binary tree is empty.");            
        } else if ((root.getLeft() == null) && (root.getRight() == null)) {
            System.out.println("Binary tree has no children.");
        } else if (b == null) {
            System.out.print("");            
        }else if ((b.getLeft() != null) || (b.getRight() != null)) {
            findLeaves(b.getLeft());
            findLeaves(b.getRight());
        } else if ((b.getLeft() == null) && (b.getRight() == null)) {
            System.out.println(b.getData());            
        }
    }

    public int height(BTreeNode<E> b) {
        int leftHeight = 1;
        int rightHeight = 1;
        if (root == null)
            return 0;
        else if ((root.left == null) && (root.right == null))
            return 1;
        else if (b.left != null) {
            leftHeight = height(b.left);
        } else if (b.right != null) {
            rightHeight = height(b.right);
        }
        if (leftHeight >= rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }
}
