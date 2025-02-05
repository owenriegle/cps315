package stackandqueueexercises;

public class CircularQueue {
    private Object[] data;
    private int head;
    private int tail;
    private int currentCount;

    public CircularQueue(int n) {
        data = new Object[n];
        head = 0;
        tail = 0;
        currentCount = 0;
    }

    public Object dequeue() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Queue is empty, cannot remove an item.");
        } else {
            int n = data.length;
            currentCount--;
            Object item = data[head];
            head = (head + 1) % n;
            return item;
        }
    }

    public boolean enqueue(Object o) throws Exception {
        if (this.isFull()) {
            throw new Exception("Queue is full, cannot add item.");
        } else {
            int n = data.length;
            currentCount++;
            data[tail] = o;
            tail = (tail + 1) % n;
            return true;
        }
    }

    private boolean isFull() {
        return this.data.length == currentCount;
    }

    private boolean isEmpty() {
        return currentCount == 0;
    }
}
