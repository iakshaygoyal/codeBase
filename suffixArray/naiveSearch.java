package suffixArray;
import java.util.*;
public class naiveSearch {

	static class pair implements Comparable<pair>{
		int i;
		String s;
		pair(int i,String s){
			this.i=i;
			this.s=s;
		}
		public int compareTo(pair p){
			return this.s.compareTo(p.s);
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String T=in.next();
		String P=in.next();
		int m=T.length();
		int n=P.length();
		pair[] arr=new pair[(m-n+1)];
		for(int i=0;i<(m-n+1);i++){
			arr[i]=new pair(i,T.substring(i,m));
		}
		Arrays.sort(arr);
		int[] arr1=new int[(m-n+1)];
		for(int i=0;i<(m-n+1);i++){
			arr1[i]=arr[i].i;
		}
		searching(T, P, n, arr1);
	}
	
	static void searching(String T,String P,int n,int[] arr){
		int start=0;
		int end=arr.length-1;
		while(start<=end){
			int mid=start+(end-start)/2;
			int val=P.compareTo(T.substring(arr[mid],arr[mid]+n));
			if(val==0){
				System.out.println(arr[mid]);
				return;
			}
			else if(val>0){
				start=mid+1;
			}
			else{
				end=mid-1;
			}
		}
		System.out.println("-1");
	}

}
