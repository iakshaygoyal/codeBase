package lec06;
import java.util.*;
public class KeypadAgain {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		String s=scn.next();
		System.out.println(f(s));
	}
	
	static ArrayList<String> f(String s){
		if(s.length()==0){
			ArrayList<String> retval=new ArrayList<>();
			retval.add("");
			return retval;
		}
		String code=getCode(s.charAt(0)-'0');
		ArrayList<String> curr=f(s.substring(1));
		ArrayList<String> retval=new ArrayList<>();
		for(int i=0;i<curr.size();i++){
			for(int j=0;j<code.length();j++){
				retval.add(code.charAt(j)+curr.get(i));
			}
		}
		return retval;
	}
	
	static String getCode(int n){
		switch(n){
		case 1:
			return "abc";
		case 2:
			return "def";
		case 3:
			return "ghi";
		case 4:
			return "jkl";
		case 5:
			return "mno";
		case 6:
			return "pqr";
		case 7:
			return "stu";
		case 8:
			return "vwx";
		case 9:
			return "yz";
		}
		return "";
}
}
