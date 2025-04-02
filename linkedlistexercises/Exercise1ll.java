/*
 * class to test LinkedList.java methods, joins existing linkedlists
 */
public class Exercise1ll {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();
        for (int i = 1; i < 6; i++) {
            Node<Integer> node = new Node<>(i);
            ll.add(node);
        }
        for (int i = 1; i < 6; i++) {
            Node<Integer> node = new Node<>(i + 5);
            ll2.add(node);
        }
        ll.printList();
        ll2.printList();
        ll.join(ll2);
        ll.printList();
    }
}
