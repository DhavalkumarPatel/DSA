package HW8.PB3;

public class Test 
{

	public static void main(String[] args) 
	{
		int set[] = {9947, 9948, 9949, 9950, 9951, 9952, 9953, 9954, 9955, 9956, 9957, 9958, 9959,
				9960, 9961, 9962, 9963, 9964, 9965, 9966, 9967, 9968, 9969, 9970, 9971, 9972, 9973,
				9974, 9975, 9976, 9977, 9978, 9979, 9980, 9981, 9982, 9983, 9984, 9985, 9986, 9987,
				9988, 9989, 9990, 9991, 9992, 9993, 9994, 9995, 9996};
		int sum = 39794;
		if(isSubsetSum(set, set.length, sum) == true)
		     System.out.println("Found a subset with given sum");
		  else
			  System.out.println("No subset with given sum");
	}
	
	// Returns true if there is a subset of set[] with sun equal to given sum
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
