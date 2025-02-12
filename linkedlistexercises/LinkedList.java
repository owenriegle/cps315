

import java.util.NoSuchElementException;

/**
 * Our custom LinkedList
 */

public class LinkedList<E> {
    /** head node – only field **/
    private Node<E> head;

    /** Constructors **/
    public LinkedList(Node<E> n) {
        this.head = n;
    }

    public LinkedList() {
        this.head = null;
    }

    /** Check if this LinkedList is empty **/
    public boolean isEmpty() {
        return head == null;
    }

    /** Return the last node or tail **/
    /**
     * Start at head node, follow next references till it refers to null. The
     * node whose next reference is null is the last node
     */

    public Node<E> last() {
        Node<E> l = head;
        /** Duplicated with .size because no getter */
        if (l == null)
            return null;
        while (l.next != null) {
            l = l.next;
        }
        return l;
    }

    /** Add Node "n" means add at the end of the list **/
    public void add(Node<E> n) {
        if (head == null) {
            head = n;
        } else {
            Node<E> l = this.last();
            l.next = n;
            n.previous = l;
        }
    }

    /**
     * Adds parsed Node after Node in this LinkedList whose data matches that of key
     */
    public void addAfter(Node<E> n, E key) throws NoSuchElementException {
        Node<E> f = head;
        for (int i = 0; i < this.size() - 1; i++) {
            if (f.getData().equals(key)) {
                n.next = f.next;
                n.previous = f.previous;
                f.next.previous = n;
                f.next = n;
                break;
            }
            f = f.next;
        }
        if (f.next == null) {
            throw new NoSuchElementException("Given key does not exist in this LinkedList");
        }
    }

    /**
     * Adds parsed LinkedList to end of this LinkedList
     * still have to test and fix
     */
    public void join(LinkedList<E> ll) {
        Node<E> node = ll.head;
        this.add(node);
    }

    /** Delete Node "n" from this LinkedList **/
    public void delete(Node<E> n) {
        n.previous.next = n.next;
        n.next.previous = n.previous;
    }

    /** Delete's the last node from this LinkedList */
    public void delete() {
        this.deleteLast();
    }

    /** Delete's the first node from this LinkedList */
    public void deleteFirst() {
        head.next.previous = null;
        this.head = head.next;
    }

    /** Delete's the middle node(s) from this LinkedList */
    /**
     * Delete's the middle node if LinkedList sive is odd
     * Delete's the middle two nodes if LinkedList size is even
     */
    public void deleteMiddle() {
        Node<E> m = head;
        int size = this.size();
        double midPoint = (size / 2);
        for (int i = 0; i < midPoint; i++) {
            m = head.next;
        }
        if ((size % 2) == 0) {
            this.delete(m.next);
            this.delete(m);
        } else {
            this.delete(m.next);
        }
    }

    /** Delete's the last node from this LinkedList */
    public void deleteLast() {
        Node<E> l = this.last();
        l.previous.next = null;
    }

    /** Gets the size of this LinkedList */
    public int size() {
        Node<E> l = head;
        int size = 1;
        if (l == null)
            return size - 1;
        while (l.next != null) {
            l = l.next;
            size++;
        }
        return size;
    }

    /** Print this LinkedList **/
    public void printList() {
        Node<E> n = this.head;
        if (n == null) {
            System.out.println("Empty List\n");
        } else {
            System.out.print("[");
            while (n.next != null) {
                System.out.print(n.getData() + "  ");
                n = n.next;
            }
            /* Take care of the last node */
            System.out.println(n.getData() + "]");
        }
    }
}
