package bootcamp.dp;
import java.util.*;
import java.math.*;
public class hkSamandsubstrings {

	static HashMap<String ,Long> map=new HashMap<>();
	  public static void main(String[] args) {
	        Scanner scn =new Scanner(System.in);
	        String s=scn.nextLine();
	        long value=0;
	        for(int i=0;i<s.length();i++){
	            String s1=s.substring(i);
	            for(int j=1;j<=s1.length();j++){
	                value+=(convert(s1.substring(0,j)));
	            }
	        }
	        System.out.println(value%1000000007);
	    }
	    
	    public static long convert(String s){
	        if(map.containsKey(s)){
	        	return map.get(s);
	        }
	    	if(s.length()==0){
	            return 0;
	        }
	        char c=s.charAt(0);
	        long i=c-'0';
	        long retval=i*power(10,s.length()-1)+convert(s.substring(1));
	        retval%=1000000007;
	        map.put(s, retval);
	        return retval;
	    }
	    
	    public static long power(int x,int n){
	    	if(n==0){
	    		return 1;
	    	}
	    	if(n%2==0){
	    		long val=power(x,n/2)%1000000007;
	    		return (val*val)%1000000007;
	    	}
	    	else{
	    		long val=power(x,n/2)%1000000007;
	    		return (x*val*val)%1000000007;
	    	}
	    }
}