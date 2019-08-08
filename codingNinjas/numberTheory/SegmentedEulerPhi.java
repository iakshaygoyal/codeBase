package codingNinjas.numberTheory;
import java.util.*;

public class SegmentedEulerPhi {
	static ArrayList<Long> prime=new ArrayList<>();
	public static void main(String[] args) {
		sieve();
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			long l=scn.nextLong();
			long r=scn.nextLong();
			
			segEulerPhi(l, r);
		}
		scn.close();
	}
	
	static void segEulerPhi(long l,long r){
		long[] phi=new long[(int)(r-l+1)];
		long[] arr=new long[(int)(r-l+1)];
		
		for(int i=0;i<(r-l+1);i++){
			phi[i]=i+l;
			arr[i]=i+l;
		}
		
		for(int i=0;i<prime.size();i++){
			long cp=prime.get(i);
			if(cp>r){
				break;
			}
			long base=(l/cp)*cp;
			if(base<l){
				base+=cp;
			}
			for(long j=base;j<=r;j+=cp){
				phi[(int)(j-l)]*=(cp-1);
				phi[(int)(j-l)]/=cp;
				while(arr[(int)(j-l)]%cp==0){
					arr[(int)(j-l)]/=cp;
				}
			}
		}
		
		for(int i=0;i<(r-l+1);i++){
			if(arr[i]!=1){
				phi[i]*=(arr[i]-1);
				phi[i]/=arr[i];
			}
			System.out.println(i+l+" : "+phi[i]);
		}
	}
	
	static void sieve(){
		int MAX=1000001;
		boolean[] sieve=new boolean[MAX];
		Arrays.fill(sieve, true);
		for(int i=2;i*i<MAX;i++){
			if(sieve[i]){
				for(int j=i*i;j<MAX;j+=i){
					sieve[j]=false;
				}
			}
		}
		prime.add((long)2);
		for(int i=3;i<MAX;i+=2){
			if(sieve[i]){
				prime.add((long)i);
			}
		}
	}
}
