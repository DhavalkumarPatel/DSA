package HW8.PB1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class HashTest 
{
	public static final int M = 701;
	public static void main(String args[])
	{
		Scanner scanner = null;
		String text = null;
		try
		{
			FileReader file = new FileReader("C:\\alice_in_wonderland.txt");
			scanner = new Scanner(file);
			text = scanner.useDelimiter("\\A").next();
		}
		catch(Exception e)
		{
			System.err.println("Error while reading file." + e);
		}
		finally
		{
			scanner.close();
		}
		
		String[] splitStr = text.split("[\\W]");
		System.out.println(splitStr.length);
		
		/*for(int i =0; i<splitStr.length; i++)
		{
			System.out.println(splitStr[i]);
		}*/
		
		Hashing h = new Hashing();
		for(int i=0; i<splitStr.length; i++)
		{
			if(splitStr[i] !=null && !splitStr[i].isEmpty())
			{
				h.increase(splitStr[i]);
			}
		}
		
		h.printKeyVal();
		
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter("output.txt");
			int c = 0;
			for(String k: h.listAllKeys())
			{
				pw.println(k + " -> " + h.find(k));
				c++;
			}
			System.out.println("TotalKeys = "+c);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error writing to file");
			e.printStackTrace();
		}
		finally
		{
			pw.close();
		}
	}
}
