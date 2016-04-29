package HW8.PB3;

public class PrimeSets 
{
	
	public static Long calculateNoOfSubBagsWithPrimeWeight(int[] input)
	{
		Long noOfSubBags = 0L;
		
		int sumOfElements = 0;
		for(int i=0; i<input.length; i++)
		{
			sumOfElements = sumOfElements + input[i];
		}
		
		int c[][] = new int[input.length+1][sumOfElements + 1];
		
		for(int i=0; i<=input.length; i++)
		{
			c[i][0] = 0;
		}
		
		for(int j=0; j<=sumOfElements; j++)
		{
			c[0][j] = 0;
		}
		
		for(int i=1; i<=input.length; i++)
		{
			for(int j=1; j<=sumOfElements; j++)
			{
				if(input[i-1] <= j)
				{
					if((input[i-1] + c[i-1][j-input[i-1]]) > c[i-1][j])
					{
						c[i][j] = input[i-1] + c[i-1][j-input[i-1]];
					}
					else
					{
						c[i][j] = c[i-1][j];
					}
				}
				else
				{
					c[i][j] = c[i-1][j];
				}
			}
		}
		
		for(int j=1; j<=sumOfElements; j++)
		{
			if(c[input.length][j] == j && isPrime(j))
			{
				noOfSubBags++;
			}
		}
		
		return noOfSubBags;
	}
	
	private static boolean isPrime(int n) 
	{
		return !new String(new char[n]).matches(".?|(..+?)\\1+");
	}
	
	public static void main(String[] args) throws Exception 
	{		
		int input1[] = new int[]{1,1,1,1,1,1,1,1,1,1};
		Long expectedResult1 = 4L;
		
		int input2[] = new int[]{4,6,8,10,12,14};
		Long expectedResult2 = 0L;
		
		int input3[] = new int[]{1,2,4,8,16,32,64,128};
		Long expectedResult3 = 54L;
		
		int input4[] = new int[]{9947, 9948, 9949, 9950, 9951, 9952, 9953, 9954, 9955, 9956, 9957, 9958, 9959,
				9960, 9961, 9962, 9963, 9964, 9965, 9966, 9967, 9968, 9969, 9970, 9971, 9972, 9973,
				9974, 9975, 9976, 9977, 9978, 9979, 9980, 9981, 9982, 9983, 9984, 9985, 9986, 9987,
				9988, 9989, 9990, 9991, 9992, 9993, 9994, 9995, 9996};
		Long expectedResult4 = 91378169764810L;
		
		int input5[] = new int[]{9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947,
				9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9947, 9934, 9934, 
				9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934,
				9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934, 9934};
		Long expectedResult5 = 54L;
		
		int input6[] = new int[]{1, 1, 2, 2, 4, 4, 8, 8, 16, 16, 32, 32, 64, 64, 128, 128, 256, 256, 512, 512, 1024,
				1024, 2048, 2048, 4096, 1, 1, 2, 2, 4, 4, 8, 8, 16, 16, 32, 32, 64, 64, 128, 128, 256, 256,
				512, 512, 1024, 1024, 2048, 2048, 4096};
		Long expectedResult6 = 62648678L;
		
		int input7[] = new int[]{10000, 9999, 9998, 9997, 9996, 9995, 9994, 9993, 9992, 9991, 9990, 9989,
				9988, 9987, 9986, 9985, 9984, 9983, 9982, 9981, 9980, 9979, 9978, 9977, 9976, 9975,
				9974, 9973, 9972, 9971, 9970, 9969, 9968, 9967, 9966, 9965, 9964, 9963, 9962, 9961,
				9960, 9959, 9958, 9957, 9956, 9955, 9954, 9953, 9952, 9951};
		Long expectedResult7 = 89655114688016L;
		
		int input8[] = new int[]{9990, 9991, 9992, 9993, 9994, 9995, 9996, 9997, 9998, 9999, 9990, 9991, 9992,
				9993, 9994, 9995, 9996, 9997, 9998, 9999, 9990, 9991, 9992, 9993, 9994, 9995, 9996,
				9997, 9998, 9999, 9990, 9991, 9992, 9993, 9994, 9995, 9996, 9997, 9998, 9999, 9990,
				9991, 9992, 9993, 9994, 9995, 9996, 9997, 9998, 9999};
		Long expectedResult8 = 4814999L;
		
		int input9[] = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 10000, 10000, 10000, 10000, 10000,
				10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
				10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000,
				10000, 10000, 10000, 10000, 10000, 10000, 10000};
		Long expectedResult9 = 6555L;
		
		
		System.out.println("For Input 1 Expected Result is :: " + expectedResult1 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input1));
		System.out.println("For Input 2 Expected Result is :: " + expectedResult2 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input2));
		System.out.println("For Input 3 Expected Result is :: " + expectedResult3 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input3));
		System.out.println("For Input 4 Expected Result is :: " + expectedResult4 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input4));
		System.out.println("For Input 5 Expected Result is :: " + expectedResult5 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input5));
		System.out.println("For Input 6 Expected Result is :: " + expectedResult6 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input6));
		System.out.println("For Input 7 Expected Result is :: " + expectedResult7 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input7));
		System.out.println("For Input 8 Expected Result is :: " + expectedResult8 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input8));
		System.out.println("For Input 9 Expected Result is :: " + expectedResult9 + " and Actual Result is :: " + calculateNoOfSubBagsWithPrimeWeight(input9));
	}
}
