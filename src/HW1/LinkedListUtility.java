package HW1;

public class LinkedListUtility 
{
	public int length(LinkedListNode head)
    {
    	int length = 0;
        while(head != null) 
        {
            length++;
            head = head.next;
        }
    	return length;
    }
	    
    public LinkedListNode moveOffset(LinkedListNode head, int offset)
    {
    	while(offset > 0)
		{
    		head = head.next;
			offset--;
		}
    	return head;
    }
    
	public LinkedListNode getIntersectingNode(LinkedListNode headA, LinkedListNode headB)
	{
		// Get the length of both the list
		int lengthA = length(headA);
		int lengthB	= length(headB);	
		
		// Move Longer List to offset steps
		if(lengthA > lengthB)
		{
			headA = moveOffset(headA,lengthA - lengthB);
		}
		else if (lengthA < lengthB)
		{
			headB = moveOffset(headB,lengthB - lengthA);
		}
		
		// Check for Intersection
		while(headA != null)
		{
			if(headA.equals(headB))
			{
				return headA;
			}
			else
			{
				headA = headA.next;
				headB = headB.next;				
			}
		}
		
		return null;
	}
}
