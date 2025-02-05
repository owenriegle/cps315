package stackandqueueexercises;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayListQueue<E> {
    ArrayList<E> q;

    public ArrayListQueue() {
        q = new ArrayList<>();
    }

    public E dequeue() throws Exception {
        if (q.isEmpty()) {
            throw new Exception("This queue is empty, cannot remove an item");
        } else {
            return q.removeFirst();
        }
    }

    public void queueReverse(ArrayListQueue<E> Q) throws Exception {
        Stack<E> stack = new Stack<>();

        while (!(Q.isEmpty())) {
            E item = Q.dequeue();
            stack.push(item);
        }

        while (!stack.isEmpty()) {
            Q.enqueue(stack.pop());
        }
    }

    private boolean isEmpty() {
        return q.isEmpty();
    }

    public void enqueue(E o) {
        q.add(o);
    }
}
