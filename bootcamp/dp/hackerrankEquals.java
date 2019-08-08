package bootcamp.dp;
import java.util.*;
public class hackerrankEquals {
	 public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
		 int t=s.nextInt();
		 for(int i=0;i<t;i++){
			 int n=s.nextInt();
			 int[] a=new int[n];
			 int min=Integer.MAX_VALUE;
			 for(int j=0;j<n;j++){
				 a[j]=s.nextInt();
				 if(a[j]<min){
					 min=a[j];
				 }
			 }
			 int minm=Integer.MAX_VALUE;
			 for(int j=0;j<5;j++){
				 if(min-j<0){
					 break;
				 }
				 int curr=equals(a, min-j);
				 if(curr<minm){
					 minm=curr;
				 }
			 }
			 System.out.println(minm);
		 }
	 }
	 
	 public static int equals(int[] a,int min){
		 int[] b=new int[a.length];
		 for(int i=0;i<b.length;i++){
			 b[i]=a[i];
		 }
		 for(int i=0;i<b.length;i++){
			 b[i]-=min;
		 }
		 int value=0;
		 for(int i=0;i<b.length;i++){
			 value+=(b[i]/5+(b[i]%5)/2+((b[i]%5)%2)/1);
		 }
		 return value;
	 }
}