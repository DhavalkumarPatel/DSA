package HW2;

public class HeapUtility 
{
	public int parent(int i, int d)
	{
		return (i-1)/d;
	}
	
	public int child(int i, int d, int k)
	{
		return i*d + k;
	}
	
	public void maxHeapify(Heap heap, int i)
	{
		int maxChildInd = maxChildInd(heap, i);
		
		if(maxChildInd != -1 && heap.get(maxChildInd) > heap.get(i))
		{
			int temp = heap.get(maxChildInd);
			heap.set(maxChildInd, heap.get(i));
			heap.set(i, temp);
			maxHeapify(heap, maxChildInd);
		}
	}
	
	public int maxChildInd(Heap heap, int i)
	{
		int maxChildInd = -1;
		
		for(int k=1; k <= heap.getD(); k++)
		{
			int childK = child(i,heap.getD(),k);
			
			if(childK < heap.getHeapSize())
			{
				if(maxChildInd == -1)
				{
					maxChildInd = childK;
				}
				else if(heap.get(childK) > heap.get(maxChildInd))
				{
					maxChildInd = childK;
				}
			}
		}
		
		return maxChildInd;
	}
	
	public void buildMaxHeap(Heap heap)
	{
		for(int i = heap.getHeapSize()/2; i >=0; i--)
		{
			maxHeapify(heap, i);
		}
	}
	
	public void heapSort(Heap heap)
	{
		buildMaxHeap(heap);
		for(int i = heap.getHeapSize()-1; i >= 1; i--)
		{
			int temp = heap.get(0);
			heap.set(0, heap.get(i));
			heap.set(i, temp);
			
			heap.decreaseHeapSize();
			 
			maxHeapify(heap, 0);
		}
	}
	
	public int heapExtractMax(Heap heap)
	{
		if(heap.getHeapSize() < 1)
		{
			return -1;
		}
	
		int max = heap.get(0);
		heap.set(0, heap.get(heap.getHeapSize()-1));
		heap.decreaseHeapSize();
		
		maxHeapify(heap, 0);
		
		return max;
	}
	
	public void heapIncreaseKey(Heap heap, int i, int k)
	{
		if(k >= heap.get(i))
		{
			heap.set(i, k);
			
			while(i > 0 && heap.get(parent(i, heap.getD())) < heap.get(i))
			{
				heap.replace(i, parent(i,heap.getD()));
				i = parent(i,heap.getD());
			}
		}
	}
	
	public void maxHeapInsert(Heap heap, int value)
	{
		heap.increaseHeapSize();
		heap.set(heap.getHeapSize()-1, value);
		heapIncreaseKey(heap, heap.getHeapSize()-1, value);
	}
	
}
