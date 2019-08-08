import java.io.*;
import java.util.*;

public class si {

	static class tuple implements Comparable<tuple>{
		int fh;int sh;int idx;
		tuple(int fh,int sh,int idx){
			this.fh=fh;
			this.sh=sh;
			this.idx=idx;
		}
		tuple(){}
		public int compareTo(tuple t){
			return (this.fh==t.fh?this.sh-t.sh:this.fh-t.fh);
		}
	}
	
    public static void main(String[] args) {
    	Scanner scn=new Scanner(System.in);
    	int t=scn.nextInt();
    	for(int i=0;i<t;i++){
    		String s=scn.next();
    		int k=scn.nextInt();
    		int[] sa=suffixArray(s);
    		System.out.println(Arrays.toString(sa));
    		int n=s.length();
    		HashSet<String> set=new HashSet<>();
    		for(int j=0;j<n;j++){
    			String s1=s.substring(sa[j],n);
    			int m=s1.length();
    			int flag=0;
    			for(int l=0;l<m;l++){
    				String s2=s1.substring(0, l+1);
    				if(set.contains(s2)){
    					continue;
    				}
    				else{
    					set.add(s2);
    					System.out.println(s2);
    					if(k<=s2.length()){
//    						System.out.println(s2.charAt(k-1));
    						flag=1;
    						break;
    					}
    					k-=(s2.length());
    				}
    			}
    			if(flag==1){
    				break;
    			}
    		}
    	}
    }
    
    static int[] suffixArray(String s){
    	int n=s.length();
    	int[] a=new int[n];
    	for(int i=0;i<n;i++){
    		a[i]=s.charAt(i)-'a';
    	}
    	tuple[] ta=new tuple[n];
    	for(int i=0;i<n;i++){
    		ta[i]=new tuple();
    	}
    	
    	for(int i=1;i<n;i*=2){
    		for(int j=0;j<n;j++){
    			ta[j].fh=a[j];
    			ta[j].sh=j+i<n?a[j+i]:-1;
    			ta[j].idx=j;
    		}
    		Arrays.sort(ta);
    		a[ta[0].idx]=0;
    		for(int j=1,rank=0;j<n;j++){
    			if(ta[j-1].fh!=ta[j].fh || ta[j-1].sh!=ta[j].sh){
    				rank++;
    			}
    			a[ta[j].idx]=rank;
    		}
    	}
    	int[] sa=new int[n];
    	for(int i=0;i<n;i++){
    		sa[i]=ta[i].idx;
    	}
    	return sa;
    }
}