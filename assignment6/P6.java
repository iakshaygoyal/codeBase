package assignment6;

import java.util.ArrayList;

public class P6 {

	public static void main(String[] args) {
		int[] a=new int[] {10,11,1};
		System.out.println(SUBSETS_ARRAY(a,0));

	}
	public static ArrayList<String> SUBSETS_ARRAY(int[] a,int index)
	{
		if(index==a.length)
		{
			ArrayList<String> current=new ArrayList<>();
			current.add("");
			return current;
		}
		ArrayList<String> smaller=SUBSETS_ARRAY(a,index+1);
		ArrayList<String> current=new ArrayList<>();
		for(int i=0;i<smaller.size();i++)
			current.add(smaller.get(i));
		for(int i=0;i<smaller.size();i++)
			current.add(a[index]+"  "+smaller.get(i));
		return current;
	}

}
