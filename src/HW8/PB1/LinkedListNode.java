package HW8.PB1;

public class LinkedListNode 
{
	private LinkedListNode next;
	private String key;
	private int value;
	
	public String getKey() 
	{
		return key;
	}
	public void setKey(String key) 
	{
		this.key = key;
	}
	public LinkedListNode getNext() 
	{
		return next;
	}
	public void setNext(LinkedListNode next) 
	{
		this.next = next;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}	
}
