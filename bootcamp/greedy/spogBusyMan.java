package bootcamp.greedy;
import java.util.*;
import java.lang.*;
public class spogBusyMan {

	// COMPLEXITY - O(NLOGN)
	
//	static class pair implements Comparable<pair>{
//		int i1;
//		int i2;
//		pair(int i1,int i2){
//			this.i1=i1;
//			this.i2=i2;
//		}
//		pair(){}
//		public int compareTo(pair p){
//			return this.i2-p.i2;
//		}
//	}
//	
//	public static void main(String[] args) {
//		Scanner s=new Scanner(System.in);
//		int t=s.nextInt();
//		for(int i=0;i<t;i++){
//			int n=s.nextInt();
//			pair[] a=new pair[n];
//			for(int j=0;j<n;j++){
//				a[j]=new pair();
//			}
//			for(int j=0;j<n;j++){
//				a[j].i1=s.nextInt();
//				a[j].i2=s.nextInt();
//			}
//			Arrays.sort(a);
//			int time=0;
//			int cnt=0;
//			for(pair p:a){
//				if(p.i1>=time){
//					cnt++;
//					time=p.i2;
//				}
//			}
//			System.out.println(cnt);
//		}
//	}
//	
	
	//COMPLEXITY - O(N)
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++){
			int n=s.nextInt();
			int[] a=new int[1000001];
			for(int j=0;j<a.length;j++){
				a[j]=-1;
			}
			for(int j=0;j<n;j++){
				int st=s.nextInt();
				int ft=s.nextInt();
				if(a[ft]!=-1){
					if(st>a[ft]){
						a[ft]=st;
					}
				}
				else{
					a[ft]=st;
				}
			}
			int cnt=0;
			int prevfinishtime=0;
			for(int j=0;j<a.length;j++){
				if(a[j]!=-1){
					if(a[j]>=prevfinishtime){
						cnt++;
						prevfinishtime=j;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}