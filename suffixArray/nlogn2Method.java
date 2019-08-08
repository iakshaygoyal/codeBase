package suffixArray;
import java.util.*;
public class nlogn2Method {
	
//	ababababababababab
//	[16, 14, 12, 10, 8, 6, 4, 2, 0, 17, 15, 13, 11, 9, 7, 5, 3, 1]
//	[2, 4, 6, 8, 10, 12, 14, 16, 0, 1, 3, 5, 7, 9, 11, 13, 15, 0]
	
	static class Tuple implements Comparable<Tuple>{
		int fh;
		int sh;
		int idx;
		
		Tuple(int fh,int sh,int idx){
			this.fh=fh;
			this.sh=sh;
			this.idx=idx;
		}
		
		public int compareTo(Tuple t){
			return this.fh==t.fh ? this.sh-t.sh : this.fh-t.fh;
 		}
	}
	
	public static void main(String[] args){
    	Scanner scn=new Scanner(System.in);
    	String T=scn.next();
    	int n=T.length();
    	int[] suffix_arr=new int[n];
    	for(int i=0;i<n;i++){
    		suffix_arr[i]=T.charAt(i)-'a';
    	}
    	Tuple[] tuple_arr=new Tuple[n];
    	
    	for(int cnt=1;cnt<n;cnt*=2){
    		for(int i=0;i<n;i++){
    			tuple_arr[i]=new Tuple(suffix_arr[i]
    					, ((i+cnt)>=n) ? -1 : suffix_arr[i+cnt]
    							, i);
    		}
    		
    		Arrays.sort(tuple_arr);
    		
    		suffix_arr[tuple_arr[0].idx]=0;
    		int rank=0;
    		for(int i=1;i<n;i++){
    			if(tuple_arr[i-1].fh!=tuple_arr[i].fh || tuple_arr[i-1].sh!=tuple_arr[i].sh){
    				rank++;
    			}
    			suffix_arr[tuple_arr[i].idx]=rank;
    		}
    	}
    	
    	for(int i=0;i<n;i++){
    		suffix_arr[i]=tuple_arr[i].idx;
    	}
    	System.out.println(Arrays.toString(suffix_arr));
    	kasai(T, suffix_arr, n);
    }
	
	static void kasai(String T,int[] suffix_arr,int n){
		int[] lcp_arr=new int[n];
		int[] inverse_arr=new int[n];
		for(int i=0;i<n;i++){
			inverse_arr[suffix_arr[i]]=i;
		}
		int k=0;
		for(int i=0;i<n;i++){
			if(inverse_arr[i]==(n-1)){
				k=0;
				continue;
			}
			int j=suffix_arr[inverse_arr[i]+1];
			while(i+k<n && j+k<n && T.charAt(i)==T.charAt(j)){
				k++;
			}
			lcp_arr[inverse_arr[i]]=k;
			if(k>0){
				k--;
			}
		}
		System.out.println(Arrays.toString(lcp_arr));
	}
	
}
