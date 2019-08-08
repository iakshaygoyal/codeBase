package importantConcepts;

public class powerModified {

	public static void main(String[] args) {
//		System.out.println(power(2.0f, -3));
		System.out.println(power1(3, 5));
	}
	
	/* Extended version of power function that can work
	 for float x and negative y O(logn)*/
	static float power(float x, int y)
	{
	    float temp;
	    if( y == 0)
	       return 1;
	    temp = power(x, y/2);       
	    if (y%2 == 0)
	        return temp*temp;
	    else
	    {
	        if(y > 0)
	            return x*temp*temp;
	        else
	            return (temp*temp)/x;
	    }
	}  
	
	/* Function to calculate x raised to the power y in O(logn)*/
	static int power1(int x, int y)
	{
	    if( y == 0)
	        return 1;
	    int temp = power1(x, y/2);
	    if (y%2 == 0)
	        return temp*temp;
	    else
	        return x*temp*temp;
	}

}
