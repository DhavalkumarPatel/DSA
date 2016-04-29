package HW8.PB2;

import java.io.FileReader;
import java.util.Scanner;

public class RedBlackTreeTest 
{
	public static void main(String args[])
	{
		RedBlackTree tree = new RedBlackTree();
		Node node;
		
		Scanner scanner = null;
		try
		{
			FileReader file = new FileReader("C:\\file.txt");
			scanner = new Scanner(file);
			
			while (scanner.hasNext()) 
			{
			    if (scanner.hasNextInt()) 
			    {
			    	node = new Node(tree.nil, scanner.nextInt());
			    	tree.insert(node);
			    } 
			    else 
			    {
			        scanner.next();
			    }
			}
		}
		catch(Exception e)
		{
			System.err.println("Error while reading file." + e);
		}
		finally
		{
			scanner.close();
		}
		
		System.out.println("Generated Tree from File Input ::");
		tree.printTree();

		System.out.println("You can enter following commands :: sort, search x, min, max, successor x, predecessor x, insert x, delete x and exit.");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter the command :: ");
		String input = scan.nextLine();

		while(!input.equalsIgnoreCase("exit"))
		{
			Boolean isPrintNeeded = true;
			try
			{
				if(input.equalsIgnoreCase("sort"))
				{
					System.out.println("Sorted Order :: ");
					tree.sort(tree.root);
					System.out.println();
					isPrintNeeded = false;
				}
				else if(input.contains("search"))
				{
					String[] sa = input.split(" ");
					Node t = tree.search(tree.root, Integer.parseInt(sa[1]));
					if(tree.nil == t || null == t)
					{
						System.out.println("Key Not Found.");
					}
					else
					{
						System.out.println("Key Found.");
					}
					isPrintNeeded = false;
				}
				else if(input.equalsIgnoreCase("min"))
				{
					if(tree.nil == tree.root || null == tree.root)
					{
						System.out.println("No Node Exists");
					}
					else
					{
						System.out.println("Minimum Key is :: " + tree.min(tree.root).key);
					}
					isPrintNeeded = false;
				}
				else if(input.equalsIgnoreCase("max"))
				{
					if(tree.nil == tree.root || null == tree.root)
					{
						System.out.println("No Node Exists");
					}
					else
					{
						System.out.println("Maximum Key is :: " + tree.max(tree.root).key);
					}
					isPrintNeeded = false;
				}
				else if(input.contains("successor"))
				{
					String[] sa = input.split(" ");
					Node t = tree.search(tree.root, Integer.parseInt(sa[1]));
					if(tree.nil == t || null == t)
					{
						System.out.println("Key Not Found.");
					}
					else
					{
						t = tree.successor(t);
						if(tree.nil == t || null == t)
						{
							System.out.println("Successor Not Found.");
						}
						else
						{
							System.out.println("Successor is :: " + t.key);
						}
					}
					isPrintNeeded = false;
				}
				else if(input.contains("predecessor"))
				{
					String[] sa = input.split(" ");
					Node t = tree.search(tree.root, Integer.parseInt(sa[1]));
					if(tree.nil == t || null == t)
					{
						System.out.println("Key Not Found.");
					}
					else
					{
						t = tree.predecessor(t);
						if(tree.nil == t || null == t)
						{
							System.out.println("Predecessor Not Found.");
						}
						else
						{
							System.out.println("Predecessor is :: " + t.key);
						}
					}
					isPrintNeeded = false;
				}
				else if(input.contains("insert"))
				{
					String[] sa = input.split(" ");
					Node t = new Node(tree.nil, Integer.parseInt(sa[1]));
					tree.insert(t);
					System.out.println("Node Inserted Successfully.");
					isPrintNeeded = true;
				}
				else if(input.contains("delete"))
				{
					String[] sa = input.split(" ");
					Node t = tree.search(tree.root, Integer.parseInt(sa[1]));
					if(tree.nil == t || null == t)
					{
						System.out.println("Key Not Found.");
					}
					else
					{
						tree.delete(t);
						System.out.println("Node Deleted Successfully.");
					}
					isPrintNeeded = true;
				}
			}
			catch(Exception e)
			{
				System.err.println("Improper command :: " + e);
			}
			
			if(isPrintNeeded)
			{
				System.out.println("Tree After the " + input + " operation :: ");
				tree.printTree();
				
				int height  = tree.maxLevel(tree.root) - 2;
				if(height < 0) 
				{
					height = 0;
				}
				System.out.println("Height of the tree After the " + input + " operation :: " + height);
			}
			
			System.out.print("Please enter the command :: ");
			input = scan.nextLine();
		}
		
		scan.close();
		System.out.println("You exited successfully.");
	}
	
	
	
	
	
	
}
