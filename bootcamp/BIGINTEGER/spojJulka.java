package bootcamp.BIGINTEGER;
import java.util.*;
import java.lang.*;
import java.math.*;
class spojJulka
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		for(int i=0;i<10;i++){
			BigInteger total=new BigInteger(s.next());
			BigInteger extra=new BigInteger(s.next());
			BigInteger x=(total.subtract(extra)).divide(BigInteger.valueOf(2));
			System.out.println(x);
			System.out.println(x.add(extra));
		}
	}
}
