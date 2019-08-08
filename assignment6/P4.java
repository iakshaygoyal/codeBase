package assignment6;

import java.util.ArrayList;

public class P4 {

	public static void main(String[] args) {
		PRINT_CODES("1123","");
		System.out.println(getCode("1123"));

	}
	public static void PRINT_CODES(String s,String outputsofar)
	{
		if(s.length()==0)
		{
			System.out.println(outputsofar);
			return;
		}
		String smaller1=GET_STRING(s.substring(0,1));
		PRINT_CODES(s.substring(1),outputsofar+smaller1);
		if(s.length()>1)
		{
			int n1=s.charAt(0)-'0';
			int n2=s.charAt(1)-'0';
			int n=10*n1+n2;
			if(n<=26)
			{
				String smaller2=GET_STRING(s.substring(0,2));
				PRINT_CODES(s.substring(2),outputsofar+smaller2);
			}
		}
	}
	
	public static ArrayList<String> getCode(String s){
		if(s.length() == 0){
			ArrayList<String> retval = new ArrayList<>();
			retval.add(" ");
			return retval;
		}
		
		ArrayList<String> smaller = getCode(s.substring(1));
		String code = GET_STRING(s.substring(0, 1));
		
		ArrayList<String> current = new ArrayList<>();
		
		for(String str : smaller){
			current.add(code + str);
		}
		
		if(s.length()>1)
		{
			int n1=s.charAt(0)-'0';
			int n2=s.charAt(1)-'0';
			int n=10*n1+n2;
			if(n<=26)
			{
				ArrayList<String> smaller1 = getCode(s.substring(2));
				String code1 = GET_STRING(s.substring(0, 2));
				
				for(String str1 : smaller1){
					current.add(code1 + str1);
				}
			}
		}
		
		return current;
	}
	
	
	public static String GET_STRING(String c)
	{
		String retval="";
		switch(c)
		{
			case "1":
				retval="a";
				break;
			
			case "2":
				retval="b";
				break;
			
			case "3":
				retval="c";
				break;
			
			case "4":
				retval="d";
				break;
				
				
			case "5":
				retval="e";
				break;
				
				
			case "6":
				retval="f";
				break;
				
				
			case "7":
				retval="g";
				break;
				
				
			case "8":
				retval="h";
				break;
				
			case "9":
				retval="i";
				break;
				
				
			case "10":
				retval="j";
				break;
				
				
			case "11":
				retval="k";
				break;
				
				
			case "12":
				retval="l";
				break;
				
				
			case "13":
				retval="m";
				break;
				
				
			case "14":
				retval="n";
				break;
				
				
			case "15":
				retval="o";
				break;
				
				
			case "16":
				retval="p";
				break;
				
				
			case "17":
				retval="q";
				break;
				
				
			case "18":
				retval="r";
				break;
				
				
			case "19":
				retval="s";
				break;
				
				
			case "20":
				retval="t";
				break;
				
				
			case "21":
				retval="u";
				break;
				
				
			case "22":
				retval="v";
				break;
				
				
			case "23":
				retval="w";
				break;
				
				
			case "24":
				retval="x";
				break;
				
				
			case "25":
				retval="y";
				break;
				
				
			case "26":
				retval="z";
				break;
			
			default:
				break;
		}
		return retval;
	}

}
