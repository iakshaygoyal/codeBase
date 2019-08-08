package bootcamp.sieveFolder;
import java.util.*;
import java.lang.*;
public class sieve {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n+1];
		sieveFunction(a);
		int cnt=0;
		for(int i=0;i<a.length;i++){
			if(a[i]==1){
				cnt++;
				System.out.print(i+" ");
			}
		}
		System.out.println();
		System.out.println("count : "+cnt);
		sieveFunction1(a);
		System.out.print(2+" ");
		for(int i=3;i<a.length;i+=2){
			if(a[i]==1){
				System.out.print(i+" ");
			}
		}
	}
	
	public static void sieveFunction(int[] a){
		Arrays.fill(a, 1);
		for(int i=2;i*i<=a.length;i++){
			if(a[i]==1){
				for(int j=i*i;j<a.length;j+=i){
					a[j]=0;
				}
			}
		}
		a[0]=0;
		a[1]=0;
	}
	public static void sieveFunction1(int[] a){
		Arrays.fill(a, 1);
		for(int i=3;i*i<=a.length;i+=2){
			if(a[i]==1){
				for(int j=i*i;j<a.length;j+=i){
					a[j]=0;
				}
			}
		}
	}
}
