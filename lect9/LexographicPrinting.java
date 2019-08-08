package lect9;

public class LexographicPrinting {

	public static void main(String[] args) {
		HELPER(100);

	}
	public static void HELPER(int max)
	{
		for(int i=1;i<10;i++)
			LEX_PRINT(max,i);
	}
	public static void LEX_PRINT(int max,int num)
	{
		if(num>max)
			return;
		System.out.println(num);
		for(int i=0;i<10;i++)
		{
			LEX_PRINT(max,num*10+i);
		}
	}

}
