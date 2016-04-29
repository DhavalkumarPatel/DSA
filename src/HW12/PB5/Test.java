package HW12.PB5;

public class Test 
{
	public static void main(String args[])
	{
		Graph g = new Graph("C:\\graph.txt");
		
		System.out.println("Initial Graph :: \n");
		g.printEdges();
		
		g.genericPushRelabel();
		
		System.out.println("\n\nGraph After Running Algorithm :: \n");
		g.printEdges();
	}
}
