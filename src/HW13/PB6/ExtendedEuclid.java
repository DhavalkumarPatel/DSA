package HW13.PB6;

public class ExtendedEuclid 
{
	public static DXY calculateGCD(int a, int b)
	{
		if(b==0)
		{
			return new DXY(a, 1, 0);
		}
		else
		{
			DXY dxy = calculateGCD(b, a % b);
			int x = dxy.x;
			int y = dxy.y;
			
			dxy.x = y;
			dxy.y = x - (a/b)*y;
			return dxy;
		}
	}
}
