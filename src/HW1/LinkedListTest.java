package HW1;

public class LinkedListTest {

	public static void main(String[] args) 
	{
		LinkedListNode n11 = new LinkedListNode(11);
		
		n11.print();
		
		LinkedListUtility utility = new LinkedListUtility();
		LinkedListNode intersectingNode = utility.getIntersectingNode(n11, n11);
		
		if(intersectingNode != null)
		{
			System.out.println("Intersecting Node :: " + intersectingNode.data);
		}
		else
		{
			System.out.println("No Intersection");
		}
	}
}
