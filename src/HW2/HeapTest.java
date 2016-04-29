package HW2;

import java.util.ArrayList;

public class HeapTest 
{
	public static void main(String args[])
	{
		ArrayList<Integer> a = new ArrayList<>();
		a.add(16);
		a.add(4);
		a.add(10);
		a.add(14);
		a.add(7);
		a.add(9);
		a.add(3);
		a.add(2);
		a.add(8);
		a.add(1);
		Heap heap = new Heap(a, 3, a.size());
		
		HeapUtility h = new HeapUtility();
		
		System.out.println("Initial Heap :: ");
		heap.print();
		
		h.buildMaxHeap(heap);
		
		System.out.println("Max Heap :: ");
		heap.print();
		
		System.out.println("Extract Max :: " + h.heapExtractMax(heap));
		
		System.out.println("Heap After Extracting Max :: ");
		heap.print();
		
		h.maxHeapInsert(heap, 5);
		System.out.println("Heap After Inserting 5 :: ");
		heap.print();
		
		h.heapIncreaseKey(heap, 5, 11);
		System.out.println("Heap After Increasing 4 to 11 :: ");
		heap.print();
	}
}
