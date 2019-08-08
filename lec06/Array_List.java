package lec06;

import java.util.ArrayList;

public class Array_List {

	public static void main(String[] args) {
		ArrayList<String> x=new ArrayList<>();
		x.add("qwerty");
		System.out.println(x);
		System.out.println(x.size());
		x.add("hi");
		System.out.println(x);
		System.out.println(x.size());
		System.out.println(x.get(1));
	}
	public static ArrayList<String> KEYPAD(String s)
	{
		if(s.length()==1)
		{
			String currentcode=GET_CODE(s.charAt(0));
			ArrayList<String> current=new ArrayList<>();
			for(int i=0;i<currentcode.length();i++)
			{
				current.add(currentcode.substring(i,i+1));
			}
			return current;
		}
		ArrayList<String> smaller=KEYPAD(s.substring(1));
		String currentcode=GET_CODE(s.charAt(0));
		ArrayList<String> current=new ArrayList<>();
		for(int i=0;i<currentcode.length();i++)
		{
			for(int j=0;j<smaller.size();j++)
			{
				current.add(currentcode.charAt(i)+smaller.get(j));
			}
		}
		return current;
	}
	public static String GET_CODE(char c)
	{
		String s="";
		switch(c)
		{
		case 1:
			s="abc";
			break;
			
		case 2:
			s="def";
			break;
			
		case 3:
			s="ghi";
			break;
			
		case 4:
			s="jkl";
			break;
			
		case 5:
			s="mno";
			break;
			
		case 6:
			s="pqr";
			break;
			
		case 7:
			s="stu";
			break;
			
		case 8:
			s="vwx";
			break;
			
		case 9:
			s="yz";
			break;
			
			default:
				break;
				
		}
		return s;
	}

}
