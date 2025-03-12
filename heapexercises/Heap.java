public class Heap {
    public static final int INITIAL_CAPACITY = 5;
    int size; // current # of elements
    int[] a; // array to hold heap elements

    public Heap() {
        size = 0;
        a = new int[INITIAL_CAPACITY + 1];
    }

    public void doubleSize() {
        int current = a.length;
        System.out.println("Current array length = " + current);
        int[] b = new int[2 * current];
        System.arraycopy(a, 0, b, 0, current);
        a = b;
        System.out.println("Array length increased to " + a.length);
    }

    public void add(int x) {
        /*
         * where should next element go?
         * At size+1 position
         */
        int pos = ++size;
        if (a.length == pos) {
            doubleSize();
        }
        /** percolate up */
        for (; pos > 1 && (a[pos / 2] > x); pos = pos / 2) {
            a[pos] = a[pos / 2];
        }
        a[pos] = x;
    }

    /** Remove from the heap and reheapify. Removed element is returned */
    public int remove() {
        int ret = a[1]; // element to return
        int pos = 1;
        a[1] = a[size]; // put the last element at the root.
        size--;

        /** percolate down */
        while (pos * 2 <= size) {
            int leftChildPos = pos * 2;
            int rightChildPos = (pos * 2) + 1;
            /* swap with leftChild */
            if (a[leftChildPos] < a[rightChildPos]) {
                swap(a, pos, leftChildPos);
                pos = leftChildPos;
            }
            /* swap with rightChild */
            else {
                swap(a, pos, rightChildPos);
                pos = rightChildPos;
            }
        }
        return ret;
    }

    // helper method for remove() that swaps nodes
    public void swap(int[] a, int currentPos, int childPos) {
        int temp = a[currentPos];
        a[currentPos] = a[childPos];
        a[childPos] = temp;
    }

    public String toString() {
        String s = "";
        for (int i = 1; i <= size; i++) {
            s = (s + a[i] + " ");
        }
        return s;
    }
}