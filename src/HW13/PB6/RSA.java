package HW13.PB6;

import java.math.BigInteger;

public class RSA 
{
	public BigInteger encrypt(BigInteger m, int e, BigInteger n)
	{
		return m.pow(e).mod(n);
	}
	
	public BigInteger decrypt(BigInteger c, int d, BigInteger n)
	{
		return c.pow(d).mod(n);
	}
}
