package HW9.PB4;

import java.util.Scanner;

public class BinomialHeapTest 
{
	public static void main(String arg[])
	{
		int in[] = {2, 9, 11, 15};
		
		BinomialHeap myheap = new BinomialHeap();
		myheap.buildHeap(in);

		System.out.println("HEAP :: ");
		System.out.println(myheap.printList(myheap.head));
		
		System.out.println("\nYou can enter following commands :: insert x, delete x, min, extract-min, dec-key x y, union x[] and exit.");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the command :: ");
		String input = scan.nextLine();

		while(!input.equalsIgnoreCase("exit"))
		{
			try
			{
				if(input.contains("insert"))
				{
					String[] sa = input.split(" ");
					myheap.insert(Integer.parseInt(sa[1]));
					System.out.println("Key inserted successfully.");
				}
				else if(input.contains("delete"))
				{
					String[] sa = input.split(" ");
					myheap.delete(myheap.find(myheap.head,Integer.parseInt(sa[1])));
					System.out.println("Key deleted successfully.");
				}
				else if(input.equalsIgnoreCase("min"))
				{
					System.out.println("Minimum is :: " + myheap.minumum(myheap));
				}
				else if(input.equalsIgnoreCase("extract-min"))
				{
					myheap.extractMin(myheap);
					System.out.println("Minimum no extracted successfully.");
				}
				else if(input.contains("dec-key"))
				{
					String[] sa = input.split(" ");
					myheap.decrease_key(myheap,myheap.find(myheap.head,Integer.parseInt(sa[1])),Integer.parseInt(sa[2]));
					System.out.println("Key descreased successfully.");
				}
				else if(input.contains("union"))
				{
					BinomialHeap newHeap = new BinomialHeap();
					
					String[] sa = input.split(" ");
					int[] ip = new int[sa.length-1];
					
					for(int i=1; i<sa.length; i++)
					{
						ip[i-1] = Integer.parseInt(sa[i]);
					}
					
					newHeap.buildHeap(ip);
					
					myheap.binomial_heap_union(newHeap);
					System.out.println("Two heaps merged successfully.");
				}
					
				
				System.out.println("HEAP :: ");
				System.out.println(myheap.printList(myheap.head));
			}
			catch(Exception e)
			{
				System.err.println("Improper command :: " + e);
			}
			
			System.out.println("\nYou can enter following commands :: insert x, delete x, min, extract-min, dec-key x y and exit.");
			System.out.print("Please enter the command :: ");
			input = scan.nextLine();
		}
		
		scan.close();
		System.out.println("You exited successfully.");
	}
}
