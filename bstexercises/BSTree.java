import java.util.ArrayList;

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
            if (root.getData().compareTo(e) > 0) {
                /*
                 * root.data is bigger, insert e into left
                 * subtree
                 */
                insertNode(e, root.left);
            } else {
                /*
                 * root.data is smaller, insert e into right
                 * subtree
                 */
                insertNode(e, root.right);
            }
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
                b.setRight(new BTreeNode<E>(e));
            } else {
                insertNode(e, b.right);
            }
        }
    }

    public boolean search(E e) { // searches for key e
        if (root == null) return false;
        else if (e.equals(root.getData())) return true;
        else {
            if (root.getData().compareTo(e) > 0) {
                return searchNode(e, root.left);
            }
            else {
                return searchNode(e, root.right);
            }
        }
    }

    public boolean searchNode(E e, BTreeNode<E> b) { // searches for key e by comparing with node b
        if (b.getData() == null) return false;
        else if (e.equals(b.getData())) return true;
        else if (b.getData().compareTo(e) > 0) {
            return searchNode(e, b.left);
        }
        else {
            return searchNode(e, b.right);
        }
    }

    public void inOrderScan() {
        ArrayList<E> al = new ArrayList<>();
        if (root.getData() != null) {
            
        }
    }

    public void inOrderScanNode(E e, BTreeNode<E> b) {
        
    }

    public void preOrderScan() {
        
    }

    public void postOrderScan() {
        
    }

}