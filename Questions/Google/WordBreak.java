package Questions.Google;
import java.util.*;
public class WordBreak {

	static String[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			arr=new String[n];
			for(int j=0;j<n;j++){
				arr[j]=scn.next();
			}
			String s=scn.next();
			
//			if(wb(s,0,s.length()-1,new Object[s.length()][s.length()])){
//				System.out.println("1");
//			}
//			else{
//				System.out.println("0");
//			}
			
			if(wb(s)){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}
		scn.close();
	}
	
	static boolean wb(String s,int si,int ei,Object[][] dp){
		if(isPresent(s.substring(si, ei+1))){
			dp[si][ei]=true;
			return (boolean)dp[si][ei];
		}
		
		if(dp[si][ei]!=null){
			return (boolean)dp[si][ei];
		}
		
		for(int i=si;i<ei;i++){
			if(wb(s,si,i,dp) && wb(s,i+1,ei,dp)){
				dp[si][ei]=true;
				return (boolean)dp[si][ei];
			}
		}
		dp[si][ei]=false;
		return (boolean)dp[si][ei];
	}
	
	static boolean wb(String s){
		int n=s.length();
		boolean[][] dp=new boolean[n][n];
		for(int i=(n-1);i>=0;i--){
			for(int j=0;j<n;j++){
				if(i>j){
					continue;
				}
				else if(isPresent(s.substring(i, j+1))){
					dp[i][j]=true;
				}
				else{
					dp[i][j]=false;
					for(int k=i;k<j;k++){
						if(dp[i][k] && dp[k+1][j]){
							dp[i][j]=true;
						}
					}
				}
			}
		}
		return dp[0][n-1];
	}
	
	static boolean isPresent(String s){
		for(int i=0;i<arr.length;i++){
			if(s.equals(arr[i])){
				return true;
			}
		}
		return false;
	}
	
}