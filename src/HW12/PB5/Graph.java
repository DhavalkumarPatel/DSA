package HW12.PB5;

import java.io.FileReader;
import java.util.Scanner;

public class Graph 
{
	public Vertex[] vertices;
	public Edge[][] edges;
	Integer source;
	Integer sink;
	
	Graph(String filePath)
	{
		Scanner scanner = null;
		try
		{
			FileReader file = new FileReader(filePath);
			scanner = new Scanner(file);
			
			Boolean isEdgesStarted = false;
			while (scanner.hasNext()) 
			{
				if(scanner.hasNext("NoOfVertices:")) 
			    {
			    	scanner.next();
			    	vertices = new Vertex[scanner.nextInt()];
			    	
			    	for(int i = 0; i < vertices.length; i++)
			    	{
			    		vertices[i] = new Vertex(0, 0);
			    	}
			    	
			    	edges = new Edge[vertices.length][vertices.length];
			    } 
			    else if(scanner.hasNext("Source:"))
			    {
			    	scanner.next();
			    	this.source = scanner.nextInt();
			    }
			    else if(scanner.hasNext("Sink:"))
			    {
			    	scanner.next();
			    	this.sink = scanner.nextInt();
			    }
			    else if(scanner.hasNext("Edges:"))
			    {
			    	isEdgesStarted = true;
			    	scanner.next();
			    }
			    else if(isEdgesStarted)
			    {
			    	edges[scanner.nextInt()][scanner.nextInt()] = new Edge(0, scanner.nextInt());
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
	}
	
	public Integer getResidualCapacity(Integer u, Integer v)
	{
		if(isEdgeBelongsToE(u, v))
		{
			return edges[u][v].capacity - edges[u][v].flow;
		}
		else if(isEdgeBelongsToE(v, u))
		{
			return edges[v][u].flow;
		}
		else
		{
			return 0;
		}
	}
	
	public Boolean isVertexOverflowing(Integer u)
	{
		if(source != u && sink != u && vertices[u].excessFlow > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isEdgeBelongsToE(Integer u, Integer v)
	{
		if(null != edges[u][v])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isEdgeBelongsToEf(Integer u, Integer v)
	{
		if((null != edges[u][v] && getResidualCapacity(u, v)>0) || (null != edges[v][u] && edges[v][u].flow > 0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Boolean isPushExists(Integer u, Integer v)
	{
		if(isVertexOverflowing(u) && getResidualCapacity(u, v) > 0 && vertices[u].height == vertices[v].height +1)
		{
			return true;
		}
		{
			return false;
		}
	}
	
	public void push(Integer u, Integer v)
	{
		if(isPushExists(u,v))
		{
			Integer deltaFlow = Math.min(vertices[u].excessFlow, getResidualCapacity(u, v));
			
			if(isEdgeBelongsToE(u, v))
			{
				edges[u][v].flow = edges[u][v].flow + deltaFlow;
			}
			else
			{
				edges[v][u].flow = edges[v][u].flow - deltaFlow;
			}
			
			vertices[u].excessFlow = vertices[u].excessFlow - deltaFlow;
			vertices[v].excessFlow = vertices[v].excessFlow + deltaFlow;
			
			System.out.println("Push :: From Vertex " + u + " to " + v + "[flow = " + deltaFlow + "]");
		}
	}
	
	public Boolean isRelabelExists(Integer u)
	{
		if(isVertexOverflowing(u))
		{
			for(int v = 0; v < vertices.length; v++)
			{
				if(isEdgeBelongsToEf(u,v))
				{
					if(vertices[u].height > vertices[v].height)
					{
						return false;
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void relabel(Integer u)
	{
		if(isRelabelExists(u))
		{
			Integer minHeight = vertices[u].height;
			
			for(int v = 0; v < vertices.length; v++)
			{
				if(isEdgeBelongsToEf(u,v))
				{
					minHeight = Math.min(vertices[v].height, minHeight);
				}
			}
			
			vertices[u].height = minHeight + 1;
			System.out.println("Relabel :: Height of Vertex " + u +" increased to " + vertices[u].height);
		}
	}
	
	public void initializePreflow()
	{
		for(int u = 0; u < vertices.length; u++)
		{
			vertices[u].height = 0;
			vertices[u].excessFlow = 0;

			for(int v = 0; v < vertices.length; v++)
			{
				if(isEdgeBelongsToE(u, v))
				{
					edges[u][v].flow = 0;
				}
			}
		}
		
		vertices[source].height = vertices.length;
		
		for(int v = 0; v < vertices.length; v++)
		{
			if(isEdgeBelongsToE(source, v))
			{
				edges[source][v].flow = edges[source][v].capacity;
				vertices[v].excessFlow = edges[source][v].capacity;
				vertices[source].excessFlow = vertices[source].excessFlow - edges[source][v].capacity;
			}
		}
	}
	
	public Push nextPushInGraph()
	{
		Push push = null;
		
		outerloop:
		for(int i = 0; i < vertices.length; i++)
		{
			for(int j = 0; j < vertices.length; j++)
			{
				if(isPushExists(i, j))
				{
					push = new Push(i,j);
					break outerloop;
				}
			}
		}
		
		return push;
	}
	
	public Relabel nextRelabelInGraph()
	{
		Relabel relabel = null;
		
		for(int i = 0; i < vertices.length; i++)
		{
			if(isRelabelExists(i))
			{
				relabel = new Relabel(i);
				break;
			}
		}
		
		return relabel;
	}
	
	public void genericPushRelabel()
	{
		initializePreflow();
		
		System.out.println("\n\nGraph After Initialization :: \n");
		printEdges();
		
		System.out.println("\n\nAlgorithm Operations :: \n");
		
		Push p = nextPushInGraph();
		
		Relabel r = null;
		if(null == p)
		{
			r = nextRelabelInGraph();
		}
		
		while(null != p || null != r)
		{
			if(null != p)
			{
				push(p.u, p.v);
			}
			else if(null != r)
			{
				relabel(r.u);
			}
			
			p = nextPushInGraph();
			
			r = null;
			if(null == r)
			{
				r = nextRelabelInGraph();
			}
		}
	}
	
	public void printAdjacencyList()
	{
		System.out.println("\nAdjacency List is::");
		for(int i = 0; i < vertices.length; i++)
		{
			System.out.print(i + "["+ vertices[i].height + ", " + vertices[i].excessFlow + "] -> ");
			for(int j=0; j < vertices.length; j++)
			{
				if(isEdgeBelongsToE(i, j))
				{
					System.out.print(j + " ");
				}
			}
			
			System.out.println();
		}
	}
	
	public void printEdge(Integer i, Integer j)
	{
		System.out.println(i + "["+ vertices[i].height + "," + vertices[i].excessFlow + "]" + " ------" + edges[i][j].flow + "/" + edges[i][j].capacity + "-----> " + j + "["+ vertices[j].height + "," + vertices[j].excessFlow + "]");
	}
	
	public void printEdges()
	{
		for(int i = 0; i < vertices.length; i++)
		{
			for(int j=0; j < vertices.length; j++)
			{
				if(null != edges[i][j])
				{
					printEdge(i,j);
				}
			}
		}
	}
}
