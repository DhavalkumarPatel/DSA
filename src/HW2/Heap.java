package HW2;

import java.util.ArrayList;

public class Heap 
{
	private ArrayList<Integer> a = null;
	private int d;
	private int heapSize;
	
	Heap(ArrayList<Integer> a, int d, int heapSize)
	{
		this.a = a;
		this.d = d;
		this.heapSize = heapSize;
	}
	
	public int get(int index)
	{
		return a.get(index);
	}
	
	public void set(int index, int value)
	{
		a.set(index, value);
	}
	
	public int getHeapSize()
	{
		return heapSize;
	}
	
	public void increaseHeapSize()
	{
		if(heapSize == a.size())
		{
			a.add(0);
		}
		heapSize++;
	}
	
	public void decreaseHeapSize()
	{
		heapSize--;
	}
	
	public int getD()
	{
		return d;
	}
	
	public void replace(int index1, int index2)
	{
		int temp = get(index1);
		set(index1, get(index2));
		set(index2, temp);
	}
	
	public void print()
	{
		System.out.print("Heap [");
		for(int i = 0; i < heapSize; i++)
		{
			System.out.print(" " + a.get(i));
		}
		System.out.println(" ]");
	}
	
}
