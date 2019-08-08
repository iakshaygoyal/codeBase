package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class codeChefChopsticks {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long d=s.nextLong();
		long[] a=new long[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextLong();
		}
		Arrays.sort(a);
		long j=a[0];
		long p=0;
		for(int i=1;i<n;i++){
			if((a[i]-j)<=d){
				p++;
				i++;
			}
			if(i!=n){
				j=a[i];
			}
		}
		System.out.println(p);
	}
}
