// HeapTest.java
public class HeapTest {

	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.add(10);
		heap.add(17);
		heap.add(14);
		heap.add(21);
		heap.add(20);
		heap.add(13);
		heap.add(18);
		heap.add(19);
		// heap.add(18);
		heap.add(11);
		heap.add(8);
		heap.add(15);
		heap.add(9);
		// heap.add(5);

		System.out.println("current heap is-> " + heap);
		System.out.println("heap should be -> 8 10 9 17 11 13 18 21 19 20 15 14");
		System.out.println("Removing least element from heap:" + heap.remove());
		System.out.println(
				"After removing least element, the new heap should be \n 9 10 13 17 11 14 19 21 18 20 15 ");
		System.out.print("Actual: ");
		System.out.println(heap);
		System.out.println("Removing next element from heap:" + heap.remove());
		System.out.println(
				"The  heap now  should be \n 10 11 13 17 15 14 19 21 18 20");
		System.out.print("Actual: ");
		System.out.println(heap);
		System.out.println("Adding 7 and then 8");
		heap.add(7);
		heap.add(8);
		System.out.println(heap);
		heap.remove();
		System.out.println(
				"After another removal, the new heap should be \n 8 10 13 17 11 14 19 21 18 20 15");
		System.out.print("Actual: ");
		System.out.println(heap);
		System.out.println("Removing 3 more: ");
		heap.remove();
		heap.remove();
		heap.remove();
		System.out.println("Should be:  13 15 14 17 20 18 19 21");
		System.out.println("Actual :    " + heap);
		System.out.println("After calling heap.remove() 4 more times: ");
		heap.remove();
		// System.out.println(heap);
		heap.remove();
		// System.out.println(heap);
		heap.remove();
		// System.out.println(heap);
		heap.remove();
		System.out.println("The heap now should be:  18 19 20 21");
		System.out.println("Actual :    " + heap);
	}
}
