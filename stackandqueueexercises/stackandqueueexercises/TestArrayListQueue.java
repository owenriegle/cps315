package stackandqueueexercises;

public class TestArrayListQueue {
    public static void main(String... args) throws Exception {
        ArrayListQueue<Integer> iq = new ArrayListQueue<>();
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