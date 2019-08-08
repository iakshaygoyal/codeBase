package Questions.Directi;
import java.util.*;
public class Max_Overlapping_Intervals {
	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int n=scn.nextInt();
	        int[] entry=new int[n];
	        int[] exit=new int[n];
	        for(int j=0;j<n;j++){
	            entry[j]=scn.nextInt();
	        }
	        for(int j=0;j<n;j++){
	            exit[j]=scn.nextInt();
	        }
	        
	        Arrays.sort(entry);
	        Arrays.sort(exit);
	        
	        int time=entry[0];
	        int max_guest=1;
	        int cnt=1;
	        int j=1,k=0;
	        while(j<n && k<n){
	            if(entry[j]<=exit[k]){
	                cnt++;
	                if(cnt>max_guest){
	                    max_guest=cnt;
	                    time=entry[j];
	                }
	                j++;
	            }
	            else{
	                cnt--;
	                k++;
	            }
	        }
	        System.out.println(max_guest+" "+time);
	    }
	    scn.close();
	}
}