/*
 * node class provided by professor for LinkedList.java
 */
public class Node<E> {
    /** this is the data Object this Node encapsulates */
    private E data;
    /** this is the reference to the next Node */
    Node<E> next;
    /** this is the reference to the previous Node */
    Node<E> previous;

    /**
     * Constructor
     */
    public Node(E s, Node<E> next, Node<E> previous) {
        this.data = s;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Constructor
     */
    public Node(E e) {
        this(e, null, null);
    }

    /**
     * return data in this node
     */
    public E getData() {
        return data;
    }

    /**
     * set data in this node
     */
    public void setData(E e) {
        this.data = e;
    }

    /**
     * String repersentation of this node
     */
    public String toString() {
        return data.toString();
    }
}
