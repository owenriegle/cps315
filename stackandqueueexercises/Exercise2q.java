/*
 * class to test enqueue and dequeue CircularQueue methods
 */
public class Exercise2q {
    public static void main(String... args) throws Exception {
        CircularQueue iq = new CircularQueue(5);
        iq.enqueue(12);
        iq.enqueue(19);
        iq.enqueue(10);
        iq.enqueue(22);
        iq.enqueue(14);
        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());
        System.out.println(iq.dequeue());
    }
}
