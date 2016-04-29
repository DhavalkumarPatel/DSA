package HW13.PB6;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args)
	{
		int a = 3;
		int b = 280;
		DXY dxy = ExtendedEuclid.calculateGCD(a, b);
		System.out.println("GCD(" + a + ", " + b + ") = " + dxy.d + " where m = " + dxy.x + " and n = " + dxy.y + " [GCD(a,b) = m*a + n*b]");
		
		RSA rsa = new RSA();
		
		BigInteger m = new BigInteger("100");
		BigInteger n = new BigInteger("319");
		System.out.println("Encrypt :: " + rsa.encrypt(m, 3, n));
		
		System.out.println("Decrypt :: " + rsa.decrypt(rsa.encrypt(m, 3, n), -93, n));
	}

}
