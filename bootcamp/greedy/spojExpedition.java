package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class spojExpedition {

	public static class pair implements Comparable<pair>{
		int dist;
		int fuel;
		pair(int dist,int fuel){
			this.dist=dist;
			this.fuel=fuel;
		}
		pair(){}
		public int compareTo(pair p){
			return this.dist-p.dist;
		}
	}
	public static class rcomparator implements Comparator<Integer>{
		public int compare(Integer i,Integer j){
			return j-i;
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			pair[] a=new pair[n+1];
			for(int j=0;j<(n+1);j++){
				a[j]=new pair();
			}
			for(int j=0;j<n;j++){
				a[j].dist=s.nextInt();
				a[j].fuel=s.nextInt();
			}
			int totaldist=s.nextInt();
			int currentfuel=s.nextInt();
			for(int j=0;j<n;j++){
				a[j].dist=totaldist-a[j].dist;
			}
			a[n].dist=totaldist;
			a[n].fuel=0;
			Arrays.sort(a);
			Comparator<Integer> c=new rcomparator();
			Queue<Integer> q=new PriorityQueue<>(c);
			int j=0;
			int cnt=0;
			for(j=0;j<(n+1);j++){
				int flag=0;
				if(currentfuel<a[j].dist){
					while(q.peek()!=null){
						currentfuel+=q.poll();
						cnt++;
						if(currentfuel>=a[j].dist){
							flag=1;
							break;
						}
					}
					if(flag==0){
						break;
					}
				}
				q.offer(a[j].fuel);
			}
			if(j==n+1){
				System.out.println(cnt);
			}
			else{
				System.out.println("-1");
			}
		}
	}

}
