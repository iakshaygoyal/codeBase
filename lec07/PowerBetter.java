package lec07;

public class PowerBetter {

	public static void main(String[] args) {
		System.out.println(POWER(3,4));

	}
	public static int POWER(int x,int n)
	{
		if(n==0)
			return 1;
		if(n%2==0)
		{
			int y=POWER(x,n/2);
			return y*y;
		}
		else
		{
			int y=POWER(x,n/2);
			return x*y*y;
		}
	}

}
