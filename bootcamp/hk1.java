package bootcamp;
import java.util.*;
import java.lang.*;
public class hk1 {

	public static class pair{
		long l1;
		long l2;
		pair(long l1,long l2){
			this.l1=l1;
			this.l2=l2;
		}
		pair(){}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long xt=s.nextLong();
		long yt=s.nextLong();
		int n=s.nextInt();
		pair[] a=new pair[n];
		for(int i=0;i<n;i++){
			a[i]=new pair();
		}
		for(int i=0;i<n;i++){
			a[i].l1=s.nextLong();
			a[i].l2=s.nextLong();
		}
		for(int i=n-1;i>=0;i--){
			xt-=a[i].l1;
			yt-=a[i].l2;
		}
		System.out.println(xt+" "+yt);
	}

}
