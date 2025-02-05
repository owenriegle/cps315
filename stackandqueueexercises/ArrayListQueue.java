package stackandqueueexercises;

import java.util.ArrayList;
import java.util.Stack;

public class ArrayListQueue<E> {
    ArrayList<E> Q;

    public ArrayListQueue() {
        Q = new ArrayList<>();
    }

    public E dequeue() throws Exception {
        if (Q.isEmpty()) {
            throw new Exception("This queue is empty, cannot remove an item");
        } else {
            return Q.removeFirst();
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
        return Q.isEmpty();
    }

    public void enqueue(E o) {
        Q.add(o);
    }
}
