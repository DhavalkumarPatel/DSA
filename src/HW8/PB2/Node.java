package HW8.PB2;

public class Node 
{
	Node left;
	Node right;
	Node p;
	int key;
	boolean isRed;
	
	Node(Node nil, int key)
	{
		this.left = nil;
		this.right = nil;
		this.p = nil;
		this.key = key;
		this.isRed = false;
	}
}


