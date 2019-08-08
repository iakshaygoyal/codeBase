package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class spojBiasedStandings {

	static class pair implements Comparable<pair>{
		String name;
		long rank;
		pair(String name,long rank){
			this.name=name;
			this.rank=rank;
		}
		pair(){}
		public int compareTo(pair p){
			return (int)(this.rank-p.rank);
		}
	}
	
	//COMPLEXITY - O(NLOGN)
	
//	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		long t=s.nextLong();
//		for(long i=0;i<t;i++){
//			System.out.prlongln();
//			long n=s.nextLong();
//			pair[] a=new pair[(long)n];
//			for(long j=0;j<n;j++){
//				a[j]=new pair();
//			}
//			for(long j=0;j<n;j++){
//				a[j].name=s.next();
//				a[j].rank=s.nextLong();
//			}
//			Arrays.sort(a);
//			long badness=0;
//			for(long j=0;j<n;j++){
//				badness+=(Math.abs(a[j].rank-(j+1)));
//			}
//			System.out.prlongln(badness);
//		}
//	}
	
// COMPLEXITY - O(N)
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long t=s.nextLong();
		for(long i=0;i<t;i++){
			System.out.println();
			long n=s.nextLong();
			Map<Long,Long> map=new HashMap<>();
			for(long j=0;j<n;j++){
				String name=s.next();
				long rank=s.nextLong();
				if(!map.containsKey(rank)){
					map.put(rank,1l);
				}
				else{
					map.put(rank,map.get(rank)+1l);
				}
			}
			long[] a=new long[(int)(n+1)];
			long k=1;
			for(long j=1;j<(n+1);j++){
				if(map.containsKey(j)){
					long value=map.get(j);
					while(value!=0){
						a[(int)(k++)]=j;
						value--;
					}
				}
			}
			long badness=0;
			for(long j=1;j<(n+1);j++){
				badness+=(Math.abs(a[(int)j]-j));
			}
			System.out.println(badness);
		}
	}

}
