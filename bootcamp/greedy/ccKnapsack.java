package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class ccKnapsack {

	public static class rcomparator implements Comparator<Long>{
		public int compare(Long i,Long j){
			return (int) (j-i);
		}
	}
//	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		int n=s.nextInt();
//		Comparator<Long> z=new rcomparator();
//		Queue<Long> orgcost1=new PriorityQueue<>(z);
//		Queue<Long> orgcost2=new PriorityQueue<>(z);
//		int sum=0;
//		for(int i=0;i<n;i++){
//			int w=s.nextInt();
//			long c=s.nextLong();
//			sum+=w;
//			if(w==1){
//				orgcost1.offer(c);
//			}
//			else{
//				orgcost2.offer(c);
//			}
//		}
//		for(int i=1;i<=sum;i++){
//			Queue<Long> cost1=new PriorityQueue<>(orgcost1);
//			Queue<Long> cost2=new PriorityQueue<>(orgcost2);
//			long e1=0l;
//			long e2=0l;
//			long e3=0l;
//			if(cost1.size()>0){
//				e1=cost1.poll();
//				if(cost1.size()>0){
//					e2=cost1.poll();
//				}
//			}
//			if(cost2.size()>0){
//				e3=cost2.poll();
//			}
//			int maxcost=0;
//			int j=i;
//			while(j!=0){
//				if(j%2!=0){
//					maxcost+=e1;
//					e1=e2;
//					e2=0l;
//					if(cost1.size()>0){
//						e2=cost1.poll();
//					}
//					j-=1;
//				}
//				else{
//					if(e3>e1+e2){
//						maxcost+=(e3);
//						e3=0l;
//						if(cost2.size()>0){
//							e3=cost2.poll();
//						}
//					}
//					else{
//						maxcost+=(e1+e2);
//						e1=0l;
//						e2=0l;
//						if(cost1.size()>0){
//							e1=cost1.poll();
//							if(cost1.size()>0){
//								e2=cost1.poll();
//							}
//						}
//					}
//					j-=2;
//				}
//			}
//			System.out.print(maxcost+" ");
//		}
//		
//	}

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Comparator<Long> z=new rcomparator();
		Queue<Long> cost1e=new PriorityQueue<>(z);
		Queue<Long> cost2e=new PriorityQueue<>(z);
		int sum=0;
		for(int i=0;i<n;i++){
			int w=s.nextInt();
			long c=s.nextLong();
			sum+=w;
			if(w==1){
				cost1e.offer(c);
			}
			else{
				cost2e.offer(c);
			}
		}
		Queue<Long> cost1o=new PriorityQueue<>(cost1e);
		Queue<Long> cost2o=new PriorityQueue<>(cost2e);
		long e1=0l;
		long e2=0l;
		long e3=0l;
		long[] storage=new long[200001];
		Queue<Long> q1;
		Queue<Long> q2;
		for(int i=1;i<=sum;i++){
			if(i%2==0){
				q1=cost1e;
				q2=cost2e;
				if(q1.size()>0){
					e1=q1.poll();
					if(q1.size()>0){
						e2=q1.poll();
					}
				}
				if(q2.size()>0){
					e3=q2.poll();
				}
			}
			else{
				q1=cost1o;
				q2=cost2o;
				if(q1.size()>0){
					e1=q1.poll();
					if(q1.size()>0){
						e2=q1.poll();
					}
				}
				if(q2.size()>0){
					e3=q2.poll();
				}
			}
			long maxcost=0;
			int j=i;
			if(i>2){
				maxcost=storage[i-2];
				j=2;
			}
			while(j!=0){
				if(j%2!=0){
					maxcost+=e1;
					e1=e2;
					e2=0l;
					if(q1.size()>0){
						e2=q1.poll();
					}
					j-=1;
				}
				else{
					if(e3>e1+e2){
						maxcost+=(e3);
						e3=0l;
						if(q2.size()>0){
							e3=q2.poll();
						}
					}
					else{
						maxcost+=(e1+e2);
						e1=0l;
						e2=0l;
						if(q1.size()>0){
							e1=q1.poll();
							if(q1.size()>0){
								e2=q1.poll();
							}
						}
					}
					j-=2;
				}
			}
			if(e1!=0l){
				q1.offer(e1);
			}
			if(e2!=0l){
				q1.offer(e2);
			}
			if(e3!=0l){
				q2.offer(e3);
			}
			storage[i]=maxcost;
			System.out.print(maxcost+" ");
			
		}
		
	}

}
