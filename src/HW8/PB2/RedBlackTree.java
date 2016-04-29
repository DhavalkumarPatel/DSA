package HW8.PB2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RedBlackTree 
{
	Node root;
	Node nil;
	
	RedBlackTree()
	{
		nil = new Node(null,0);
		root = nil;
	}
	
	public void sort(Node node)
	{
		if(nil != node)
		{
			sort(node.left);
			System.out.print(node.key + "  ");
			sort(node.right);
		}
	}
	
	public Node search(Node node, int key)
	{
		while(nil != node && key != node.key)
		{
			if(key < node.key)
			{
				node = node.left;
			}
			else
			{
				node = node.right;
			}
		}
		return node;
	}
	
	public Node min(Node node)
	{
		while(nil != node.left)
		{
			node = node.left;
		}
		return node;
	}
	
	public Node max(Node node)
	{
		while(nil != node.right)
		{
			node = node.right;
		}
		return node;
	}
	
	public Node successor(Node node)
	{
		Node successor = null;
		
		if(nil != node.right)
		{
			successor = min(node.right);
		}
		else
		{
			successor = node.p;
			
			while(nil != successor && node.equals(successor.right))
			{
				node = successor;
				successor = successor.p;
			}
		}
		
		return successor;
	}
	
	public Node predecessor(Node node)
	{
		Node predecessor = null;
		
		if(nil != node.left)
		{
			predecessor = max(node.left);
		}
		else
		{
			predecessor = node.p;
			
			while(nil != predecessor && node.equals(predecessor.left))
			{
				node = predecessor;
				predecessor = predecessor.p;
			}
		}
		
		return predecessor;
	}
	
	public void leftRotate(Node x)
	{
		Node y = x.right;
		x.right = y.left;
		
		if(!nil.equals(y.left))
		{
			y.left.p = x;
		}
		
		y.p = x.p;
		
		if(x.p.equals(nil))
		{
			root = y;
		}
		else if(x.equals(x.p.left))
		{
			x.p.left = y;
		}
		else
		{
			x.p.right = y;
		}
		y.left = x;
		x.p = y;
	}
	
	public void rightRotate(Node x)
	{
		Node y = x.left;
		x.left = y.right;
		
		if(!nil.equals(y.right))
		{
			y.right.p = x;
		}
		
		y.p = x.p;
		
		if(x.p.equals(nil))
		{
			root = y;
		}
		else if(x.equals(x.p.right))
		{
			x.p.right = y;
		}
		else
		{
			x.p.left = y;
		}
		y.right = x;
		x.p = y;
	}
	
	public void insert(Node z)
	{
		Node y = nil;
		Node x = root;
		
		while(!nil.equals(x))
		{
			y = x;
			if(z.key < x.key)
			{
				x = x.left;
			}
			else
			{
				x = x.right;
			}
		}
		
		z.p = y;
		
		if(nil.equals(y))
		{
			root = z;
		}
		else if(z.key < y.key)
		{
			y.left = z;
		}
		else
		{
			y.right = z;
		}
		
		z.left = nil;
		z.right = nil;
		z.isRed = true;
		insertRBFixup(z);
	}
	
	public void insertRBFixup(Node z)
	{
		while(z.p.isRed)
		{
			if(z.p.equals(z.p.p.left))
			{
				Node y = z.p.p.right;
				if(y.isRed)
				{
					z.p.isRed = false;
					y.isRed = false;
					z.p.p.isRed = true;
					z = z.p.p;
				}
				else 
				{
					if(z.equals(z.p.right))
					{
						z = z.p;
						leftRotate(z);
					}
					z.p.isRed = false;
					z.p.p.isRed = true;
					rightRotate(z.p.p);
				}
			}
			else
			{
				Node y = z.p.p.left;
				if(y.isRed)
				{
					z.p.isRed = false;
					y.isRed = false;
					z.p.p.isRed = true;
					z = z.p.p;
				}
				else 
				{
					if(z.equals(z.p.left))
					{
						z = z.p;
						rightRotate(z);
					}
					z.p.isRed = false;
					z.p.p.isRed = true;
					leftRotate(z.p.p);
				}
			}
		}
		root.isRed = false;
	}
	
    public void transplant(Node u, Node v) 
    {
    	if(u.p.equals(nil))
    	{
    		root = v;
    	}
    	else if(u.equals(u.p.left))
    	{
    		u.p.left = v;
    	}
    	else
    	{
    		u.p.right = v;
    	}
    	v.p = u.p;
    }
    
    public void delete(Node z) 
    {
    	Node y = z;   	
    	boolean isYOriginalRed = y.isRed;  	
    	Node x;   
    	
    	if (z.left.equals(nil)) 
    	{    	
    		x = z.right;
    		transplant(z, z.right);             	
    	}
    	else if (z.right.equals(nil)) 
    	{ 	
    		x = z.left;
    		transplant(z, z.left);              	
    	}
    	else 
    	{
    		y = min(z.right);
    		isYOriginalRed = y.isRed;
    		x = y.right;
			  
    		if (y.p.equals(z))
    		{
    			x.p = y;
    		}
    		else 
    		{
    			transplant(y, y.right);
    			y.right = z.right;
    			y.right.p = y;
    		}
			
    		transplant(z, y);
    		y.left = z.left;
    		y.left.p = y;
    		y.isRed = z.isRed;
    	}
			
    	if (!isYOriginalRed)	
    	{
    		deleteRBFixup(x);
    	}
    }

    protected void deleteRBFixup(Node x) 
    {
    	Node w = null;

    	while(!x.equals(root) && !x.isRed) 
    	{
    		if(x.equals(x.p.left)) 
    		{
    			w = x.p.right;
    			if(w.isRed) 
    			{
    				w.isRed = false;
    				x.p.isRed = true;
    				leftRotate(x.p);
    				w = x.p.right;
    			}
    			if (!w.left.isRed &&  !w.right.isRed) 
    			{
    				w.isRed = true;
    				x = x.p;
    			}
    			else 
    			{
    				if(!w.right.isRed) 
    				{
    					w.left.isRed = false;
    					w.isRed = true;
    					rightRotate(w);
    					w = x.p.right;
    				}
    				
    				w.isRed = x.p.isRed;
    				x.p.isRed = false;
    				w.right.isRed = false;
    				leftRotate(x.p);
    				x = root;
    			}
    		}
    		else 
    		{
    			w = x.p.left;
    			if (w.isRed) 
    			{
    				w.isRed = false;
    				x.p.isRed = true;
    				rightRotate(x.p);
    				w = x.p.left;
    			}
    			if (!w.right.isRed &&  !w.left.isRed) 
    			{
    				w.isRed = true;
    				x = x.p;
    			}
    			else 
    			{
    				if(!w.left.isRed) 
    				{
    					w.right.isRed = false;
    					w.isRed = true;
    					leftRotate(w);
    					w = x.p.left;
    				}
    				
    				w.isRed = x.p.isRed;
    				x.p.isRed = false;
    				w.left.isRed = false;
    				rightRotate(x.p);
    				x = root;
    			}
    		}
    	}

    	x.isRed = false;
    }

    public void printTree() 
    {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node> nodes, int level, int maxLevel) 
    {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
        {
        	return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes)
        {
            if (node != null) 
            {
            	/*if(node.isRed)
            	{
            		System.out.print("r"+node.key);
            	}
            	else
            	{
            		System.out.print(node.key);
            	}*/
            	System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } 
            else 
            {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) 
        {
            for (int j = 0; j < nodes.size(); j++) 
            {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) 
                {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                {
                	System.out.print("/");
                }
                else
                {
                	printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                {
                	System.out.print("\\");
                }
                else
                {
                	printWhitespaces(1);
                }

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) 
    {
        for (int i = 0; i < count; i++)
        {
        	System.out.print(" ");
        }
    }

    public int maxLevel(Node node) 
    {
        if (node == null)
        {
        	return 0;
        }

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
    
    private boolean isAllElementsNull(List<Node> list) 
    {
        for (Object object : list) 
        {
            if (object != null)
            {
            	return false;
            }
        }
        return true;
    }
    
    /*public void printTree(Node root, int indent)
	{
		for(int i = 0; i < indent; i++) 
		{
			System.out.print("   ");
	    }
	    
		if (root == null) 
		{
			System.out.println("null");
			return;
	    }
		
		System.out.println(root.key);
	   
		if(null != root.left)
			printTree1(root.left, indent + 1);
	    
		if(null != root.right)    
			printTree1(root.right, indent + 1);
	}*/

}
