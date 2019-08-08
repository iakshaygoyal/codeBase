package Questions.Amazon;
import java.util.*;
public class Largest_Number_From_Array {
    
	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        String[] arr=new String[n];
	        for(int j=0;j<n;j++){
	        	arr[j]=scn.next();
	        }
	        Arrays.sort(arr,new Comparator<String>(){
	        	public int compare(String s1,String s2){
	        		String x=s1+s2;
	        		String y=s2+s1;
	        		return y.compareTo(x);
	        	}
	        });
	        String result="";
	        for(int j=0;j<n;j++){
	            result+=(arr[j]);
	        }
	        System.out.println(result);
	    }
	    scn.close();
	}
}