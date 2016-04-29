package HW1;

public class LinkedListNode 
{
	LinkedListNode next  = null;
    int data;

    public LinkedListNode(int d) 
    {
        data = d;
    }

    public void appendToTail(LinkedListNode end) 
    {
    	LinkedListNode n = this;
        while(n.next != null) 
        {
            n = n.next;
        }
        n.next = end;
    }
    
    public void print()
    {
    	LinkedListNode n = this;
    	StringBuilder builder = new StringBuilder();
    	
    	while(n.next != null)
		{
    		builder.append(n.data);
    		builder.append(" -> ");
    		n = n.next;
		}
    	
    	builder.append(n.data);
    	System.out.println(builder.toString());
    }
}