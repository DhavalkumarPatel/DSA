package HW8.PB3;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeLogic
{
	public static void main(String args[])
	{
		Scanner scanner = null;
		ArrayList<Integer> primes = new ArrayList<>();
		
		try
		{
			FileReader file = new FileReader("C:\\primes.txt");
			scanner = new Scanner(file);
			
			
			while (scanner.hasNext()) 
			{
			    if (scanner.hasNextInt()) 
			    {
			    	primes.add(scanner.nextInt());
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
		
		int set[] = {1,2,4,8,16,32,64,128};
		
		
		
		long curTime = System.currentTimeMillis();
		int count = 0;
		for(Integer i : primes)
		{
			if(isSubsetSum(set, set.length, i) == true)
			{
				count ++;
			}
			
			if(i > 500)
			{
				break;
			}
		}
		
		System.out.println("Count :: " + count);
		System.out.println("Total Time :: " + (System.currentTimeMillis() - curTime));
	}
	
	static boolean isSubsetSum(int set[], int n, int sum)
	{
	    // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
	    //  with sum equal to i
	    boolean subset[][] = new boolean[sum+1][n+1];
	 
	    // If sum is 0, then answer is true
	    for (int i = 0; i <= n; i++)
	      subset[0][i] = true;
	 
	    // If sum is not 0 and set is empty, then answer is false
	    for (int i = 1; i <= sum; i++)
	      subset[i][0] = false;
	 
	     // Fill the subset table in botton up manner
	     for (int i = 1; i <= sum; i++)
	     {
	       for (int j = 1; j <= n; j++)
	       {
	         subset[i][j] = subset[i][j-1];
	         if (i >= set[j-1])
	           subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
	       }
	     }
	 
	    /* // uncomment this code to print table
	     for (int i = 0; i <= sum; i++)
	     {
	       for (int j = 0; j <= n; j++)
	          printf ("%4d", subset[i][j]);
	       printf("\n");
	     } */
	 
	     return subset[sum][n];
	}
}
