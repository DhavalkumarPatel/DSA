package HW8.PB1;

import java.util.ArrayList;

public class Hashing {
	
	public static final int SIZE = 800;
	public final static int PRIME = 31;
	private LinkedList[] hashTable = new LinkedList[SIZE];
	
	public int hashValue(String s)
	{
		int hash = 0;
		for(int i=0; i< s.length(); i++)
		{
			hash += Math.pow(PRIME, i) * s.charAt(i);
		}
		return hash;
	}
	
	public void insert(String key, int value)
	{
		int hIndex = hashValue(key) % SIZE;
		if(hashTable[hIndex] == null)
		{
			hashTable[hIndex] = new LinkedList();
		}
		hashTable[hIndex].insert(key, value);
	}
	
	public int find(String key)
	{
		int hIndex = hashValue(key) % SIZE;
		if(hashTable[hIndex] != null && hashTable[hIndex].find(key) != null)
		{
			return hashTable[hIndex].find(key).getValue();
		}
		else
		{
			return 0;
		}
	}
	
	public void increase(String key, int value)
	{
		int hIndex = hashValue(key) % SIZE;
		if(hashTable[hIndex] == null)
		{
			insert(key, 1);
		}
		else
		{
			hashTable[hIndex].increase(key, 1);
		}
	}
	
	public void increase(String key)
	{
		increase(key, 1);
	}
	
	public void delete(String key)
	{
		int hIndex = hashValue(key) % SIZE;
		if(hashTable[hIndex] == null || hashTable[hIndex].find(key) == null)
		{
			System.out.println("Key doesn't exist to delete");
		}
		else
		{
			hashTable[hIndex].delete(key);
		}
	}
	
	public ArrayList<String> listAllKeys()
	{	
		ArrayList<String> keys = new ArrayList<String>();
		for(int i =0; i< hashTable.length; i++)
		{
			if(hashTable[i] != null)
			{
				keys.addAll(hashTable[i].getKeys());
			}
		}
		return keys;
	}
	
	public void printKeyVal()
	{		
		for(int i =0; i< hashTable.length; i++)
		{
			if(hashTable[i] != null)
			{
				hashTable[i].printKeyVal();
			}
		}
	}
}
