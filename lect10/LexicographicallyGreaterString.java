package lect10;

public class LexicographicallyGreaterString {

	public static void main(String[] args) {
		PRINT_PERMUTATION("abcd","");

	}
	public static void PRINT_PERMUTATION(String s,String outputsofar)
	{
		if(s.length()==0)
		{
			FUN(outputsofar,"badc");
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			String rest=s.substring(0,i)+s.substring(i+1);
			PRINT_PERMUTATION(rest,outputsofar+c);
		}
	}
	public static void FUN(String s,String x)
	{
		int i;
		for(i=0;i<s.length();i++)
		{
			if((int)s.charAt(i)>(int)x.charAt(i))
				break;
			else if((int)s.charAt(i)==(int)x.charAt(i))
				continue;
			else
				return;
		}
		if(i!=s.length())
			System.out.println(s);
	}
//	public static void PRINT_PERMUTATION(String s,String outputsofar,String x,boolean b)
//	{
//		if(s.length()==0)
//		{
//			if(b==false)
//			{
//				System.out.println(outputsofar);
//			}
//			return;
//		}
//		for(int i=0;i<s.length();i++)
//		{
//			char c=s.charAt(i);
//			if((int)c>(int)x.charAt(0) || b==false)
//			{
//				b=false;
//				String rest=s.substring(0,i)+s.substring(i+1);
//				PRINT_PERMUTATION(rest,outputsofar+c,x.substring(1),b);
//			}
//			else if((int)c==(int)x.charAt(0))
//			{
//				String rest=s.substring(0,i)+s.substring(i+1);
//				PRINT_PERMUTATION(rest,outputsofar+c,x.substring(1),b);
//			}
//			else
//				continue;
//			
//		}
//	}

}
