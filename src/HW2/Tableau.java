package HW2;

public class Tableau 
{
	private int a[][];
	private int m;
	private int n;
	private int nonExistElem;
	
	Tableau(int m, int n, int nonExistElem)
	{
		this.m = m;
		this.n = n;
		this.nonExistElem = nonExistElem;
		
		a = new int[m][n];
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				a[i][j] = this.nonExistElem;
			}
		}
	}
	
	public int get(int i, int j)
	{
		return a[i][j];
	}
	
	public void set(int i, int j, int value)
	{
		a[i][j] = value;
	}
	
	public int getM()
	{
		return m;
	}
	
	public int getN()
	{
		return n;
	}
	
	public int getNonExistElem()
	{
		return nonExistElem;
	}
	
	public int getLeft(int i, int j)
	{
		if(j == 0)
		{
			return -1;
		}
		else
		{
			return get(i, j-1);
		}
	}
	
	public int getTop(int i, int j)
	{
		if(i == 0)
		{
			return -1;
		}
		else
		{
			return get(i-1, j);
		}
	}
	
	public int getRight(int i, int j)
	{
		if(j == n-1)
		{
			return -1;
		}
		else
		{
			return get(i, j+1);
		}
	}
	
	public int getDown(int i, int j)
	{
		if(i == m-1)
		{
			return -1;
		}
		else
		{
			return get(i+1, j);
		}
	}
	
	public void replace(int i1, int j1, int i2, int j2)
	{
		int temp = get(i1, j1);
		set(i1, j1, get(i2, j2));
		set(i2, j2, temp);
	}
	
	public void print()
	{
		System.out.println("Matrix ::");
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(get(i, j) + " ");
			}
			System.out.println("");
		}
	}
}
