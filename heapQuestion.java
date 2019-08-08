import java.util.*;
public class heapQuestion {

	static class pair implements Comparable<pair>{
		long l1;
		long l2;
		pair(long l1,long l2){
			this.l1=l1;
			this.l2=l2;
		}
		pair(){}
		public int compareTo(pair p){
			return (int)(this.l1-p.l1);
		}
	}
	static class comp implements Comparator<pair>{
		public int compare(pair p1, pair p2) {
			return (int)(p1.l2-p2.l2);
		}
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		pair[] arr=new pair[n];
		for(int i=0;i<n;i++){
			arr[i]=new pair();
		}
		for(int i=0;i<n;i++){
			arr[i].l1=s.nextLong();
			arr[i].l2=s.nextLong();
		}
		Arrays.sort(arr);
		Comparator<pair> c=new comp();
		Queue<pair> pq=new PriorityQueue<>(c);
		long ct=0;
		long wt=0;
		pq.offer(arr[0]);
		int idx=1;
		while(!pq.isEmpty()){
			pair p=pq.poll();
			if(ct-p.l1>0){
				wt+=(ct-p.l1+p.l2);
				ct+=p.l2;
			}
			else{
				wt+=p.l2;
				ct=p.l1+p.l2;
			}
			while(idx!=n && arr[idx].l1<=ct){
				pq.offer(arr[idx]);
				idx++;
			}
			if(idx!=n && pq.isEmpty()){
				pq.offer(arr[idx]);
				idx++;
			}
		}
		System.out.println(wt/=n);
	}
}
