package Questions.DpWithBitmasking;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Tshirts {
	
		static Vector<Integer>[] arr=new Vector[101];
		static long[][] dp;
		static int DONE;
		static int N=1000000007;
		public static void main (String[] args){
			Scanner scn=new Scanner(System.in);
			int t=scn.nextInt();
			
			for(int i=0;i<t;i++){
				for(int j=0;j<101;j++){
					arr[j]=new Vector<>(0,1);
				}
				dp=new long[1025][102];
				for(int j=0;j<1025;j++){
					for(int k=0;k<102;k++){
						dp[j][k]=-1;
					}
				}
				
				int n=scn.nextInt();
				DONE=(1<<n)-1;
				scn.nextLine();
				
				for(int j=0;j<n;j++){
					String s=scn.nextLine();
					int k=0;
					int l=0;
					while(l<s.length()){
						if(s.charAt(l)!=' '){
							l++;
							continue;
						}
						arr[Integer.parseInt(s.substring(k,l))].add(j);
						l++;
						k=l;
					}
					arr[Integer.parseInt(s.substring(k,l))].add(j);
				}
				System.out.println(evaluate(0, 1));
			}
		}
		
		static long evaluate(int mask,int tid){
			if(mask==DONE){
				return 1;
			}
			if(tid==101){
				return 0;
			}
			if(dp[mask][tid]!=-1){
				return dp[mask][tid];
			}
			long result=0;
			result+=(evaluate(mask, tid+1));
			result%=N;
			
			Vector<Integer> vector=arr[tid];
			for(Integer p:vector){
				int value=1<<p;
				if((mask&value)==0){
					result+=(evaluate(mask|value, tid+1));
					result%=N;
				}
			}
			return dp[mask][tid]=result;
		}
		
		
	 
	} 