package lec06;

public class Subsequence {

	public static void main(String[] args) {
		String[] x=SUBSEQUENCE("abc");
		for(String val:x)
		System.out.println(val);

	}
	public static String[] SUBSEQUENCE(String s)
	{
		if(s.length()==0)
			return new String[] {""};
	String[] smaller=SUBSEQUENCE(s.substring(1));
	String[] current=new String[2*smaller.length];
	for(int i=0;i<smaller.length;i++)
		current[i]=smaller[i];
	for(int i=0;i<smaller.length;i++)
		current[smaller.length+i]=s.charAt(0)+smaller[i];
	return current;
	}

}
