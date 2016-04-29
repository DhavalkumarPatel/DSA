package HW2;

public class TableauTest 
{
	public static void main(String args[])
	{
		int[] a = {9,16,3,2,4,8,5,14,12};
		
		Tableau t = new Tableau(4, 4, 0);
		int ii =10;
		ii *= 10;
		
		System.out.println(ii);
		TableauUtility tu = new TableauUtility();
		
		for(int i = 0; i < a.length; i++)
		{
			tu.insert(t, a[i]);
		}
		
		System.out.println("Tableau After Insert :: ");
		t.print();
		
		System.out.println("Search for 9 :: " + tu.SearchInTableau(t, 9));
		System.out.println("Search for 16 :: " + tu.SearchInTableau(t, 16));
		System.out.println("Search for 17 :: " + tu.SearchInTableau(t, 17));
		System.out.println("Search for 1 :: " + tu.SearchInTableau(t, 1));
		
		System.out.println("Extracting Minimum :: " + tu.extractMinTableau(t));
		
		System.out.println("Tableau After Extracting Minimum :: ");
		t.print();
	}
}
