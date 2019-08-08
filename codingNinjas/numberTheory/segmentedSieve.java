package codingNinjas.numberTheory;
import java.util.*;
public class segmentedSieve {

	public static void main(String[] args) {
		ArrayList<Integer> primes=sieve();
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			long l=scn.nextLong();
			long r=scn.nextLong();
			printPrimes(l, r, primes);
		}
		scn.close();
	}
	
	static void printPrimes(long l,long r,ArrayList<Integer> primes){
		boolean[] arr=new boolean[(int)(r-l+1)];
		Arrays.fill(arr, true);
		for(int i=0;i<primes.size() && primes.get(i)*(long)primes.get(i)<=r;i++){
			int cp=primes.get(i);
			long base=(l/cp)*cp;
			if(base<l){
				base+=cp;
			}
			for(long j=base;j<=r;j+=cp){
				arr[(int)(j-l)]=false;
			}
			if(base==cp){
				arr[(int)(base-l)]=true;
			}
		}
		for(int i=0;i<(r-l+1);i++){
			if(arr[i]){
				System.out.println(i+l);
			}
		}
	}
	
	static ArrayList<Integer> sieve(){
		int size=1000001;
		boolean[] arr=new boolean[size];
		Arrays.fill(arr, true);
		
		for(int i=2;i*i<size;i++){
			if(arr[i]){
				for(int j=i*i;j<size;j+=i){
					arr[j]=false;
				}
			}
		}
		
		ArrayList<Integer> primes=new ArrayList<>();
		primes.add(2);
		for(int i=3;i<size;i+=2){
			if(arr[i]){
				primes.add(i);
			}
		}
		
		return primes;
	}

}
