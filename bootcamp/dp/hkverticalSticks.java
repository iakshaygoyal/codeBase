package bootcamp.dp;
import java.util.*;
import java.lang.*;
import java.text.*;
public class hkverticalSticks {
	    static double total=0;
	    static double num=0;
	    public static void main(String[] args) {
	        Scanner s=new Scanner(System.in);
	        int t=s.nextInt();
	        for(int i=0;i<t;i++){
	        	total=0;
	        	num=0;
	            int n=s.nextInt();
	            int[] a=new int[n];
	            for(int j=0;j<n;j++){
	                a[j]=s.nextInt();
	            }
	            per(a,0);
	            double d=total/num;
	            DecimalFormat df=new DecimalFormat("0.00");
	            System.out.println(df.format(d));
	        }
	    }
	    
	    public static void per(int[] a,int idx){
	        if(idx==a.length){
	            num+=1;
	            int value1=1;
	            for(int i=1;i<a.length;i++){
	                int value2=1;
	                for(int j=i-1;j>=0;j--){
	                    if(a[j]<a[i]){
	                        value2++;
	                    }
	                    else{
	                        break;
	                    }
	                }
	                value1+=value2;
	            }
	            total+=value1;
	            return;
	        }
	        HashSet<Integer> visited=new HashSet<>();
	        for(int i=idx;i<a.length;i++){
	            if(!visited.contains(a[i])){
	                visited.add(a[i]);
	                swap(a,idx,i);
	                per(a,idx+1);
	                swap(a,idx,i);
	            }
	        }
	    }
	    
	    public static void swap(int[] a,int i,int j){
	        int temp=a[i];
	        a[i]=a[j];
	        a[j]=temp;
	    }
	}