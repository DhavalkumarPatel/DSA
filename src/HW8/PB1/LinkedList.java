package HW8.PB1;

import java.util.ArrayList;

public class LinkedList
{
	private LinkedListNode head;

	public LinkedListNode getHead() 
	{
		return head;
	}

	public void setHead(LinkedListNode head) 
	{
		this.head = head;
	}
	
	public LinkedListNode insert(String key, int value)
	{
		LinkedListNode f = find(key);
		
		if(f != null)
		{
			f.setValue(value);
		}
		else
		{
			LinkedListNode p = new LinkedListNode();
			p.setKey(key);
			p.setValue(value);
			if(getHead() == null)
			{
				setHead(p);
			}
			else
			{
				getLast().setNext(p);
			}
		}
		return head;
	}
	
	public LinkedListNode increase(String key, int incBy)
	{
		LinkedListNode f = find(key);
		
		if(f != null)
		{
			f.setValue(f.getValue() + incBy);
		}
		else
		{
			LinkedListNode p = new LinkedListNode();
			p.setKey(key);
			p.setValue(incBy);
			if(getHead() == null)
			{
				setHead(p);
			}
			else
			{
				getLast().setNext(p);
			}
		}
		return head;
	}
	
	public LinkedListNode find(String key)
	{
		LinkedListNode t = getHead();
		while(t!=null)
		{
			if(t.getKey().equals(key))
			{
				return t;
			}
			t=t.getNext();
		}
		return null;
	}
	
	public LinkedListNode getLast()
	{
		LinkedListNode t = getHead();
		while(t!= null)
		{
			if(t.getNext() == null)
			{
				return t;
			}
			t = t.getNext();
		}
		return null;
	}
	
	
	public int size()
	{
		int n = 0;
		LinkedListNode t = getHead();
		while(t!=null)
		{
			t = t.getNext();
			n++;
		}
		return n;
	}
	
	public void printKeyVal()
	{
		LinkedListNode t = getHead();
		while(t!=null)
		{
			System.out.print("[" + t.getKey() + ", " + t.getValue()+"] ");
			t = t.getNext();
		}
		System.out.println();
	}
	
	public ArrayList<String> getKeys()
	{
		ArrayList<String> keys = new ArrayList<String>();
		LinkedListNode t = getHead();
		while(t!=null)
		{
			keys.add(t.getKey());
			t = t.getNext();
		}
		return keys;
	}
	
	public void delete(String key)
	{
		LinkedListNode t = getHead();
		LinkedListNode prev = null;
		while(t!= null)
		{
			if(t.getKey().equals(key))
			{
				break;
			}
			prev = t;
			t = t.getNext();
		}
		if(t != null)
		{
			if(prev == null)
			{
				setHead(t.getNext());
			}
			else
			{
				prev.setNext(t.getNext());
			}
		}
	}
}