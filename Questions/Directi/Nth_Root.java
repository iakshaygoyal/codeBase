package Questions.Directi;
import java.util.*;

public class Nth_Root {

	 public static void main(String[] args) {
	    	Scanner scn=new Scanner(System.in);
	    	int t=scn.nextInt();
	    	for(int i=0;i<t;i++){
	    		int a=scn.nextInt();
	    		int n=scn.nextInt();
	    		
	    		double prev=1;
	    		double diff=Double.MAX_VALUE;
	    		double acc=0.001;
	    		while(Math.abs(diff)>acc){
	    			double curr=(((n-1)*prev) + (a/Math.pow(prev, n-1)))/n;
	    			diff=curr-prev;
	    			prev=curr;
	    		}
	    		System.out.println(prev);
	    	}
	    	scn.close();
	}
	    
}
