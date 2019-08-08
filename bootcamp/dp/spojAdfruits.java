package bootcamp.dp;
import java.util.*;
import java.lang.*;
public class spojAdfruits {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		while(s.hasNext()){
			String s1=s.next();
			String s2=s.next();
			s1=s1.trim();
			s2=s2.trim();
			int n=s1.length();
			int m=s2.length();
			int[][] dp=new int[n+1][m+1];
			for(int i=1;i<n+1;i++){
				for(int j=1;j<m+1;j++){
					if(s1.charAt(i-1)==s2.charAt(j-1)){
						dp[i][j]=1+dp[i-1][j-1];
					}
					else{
						dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
					}
				}
			}
			StringBuilder sb=new StringBuilder();
			int i=n;
			int j=m;
			while(i>0 && j>0){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					sb.append(s1.charAt(i-1));
					i--;
					j--;
				}
				else{
					if(dp[i-1][j]>dp[i][j-1]){
						i--;
					}
					else{
						j--;
					}
				}
			}
			sb.reverse();
			StringBuilder result=new StringBuilder();
			int x=0;
			int y=0;
			for(int z=0;z<sb.length();z++){
				while(s1.charAt(x)!=sb.charAt(z)){
					result.append(s1.charAt(x));
					x++;
				}
				x++;
				while(s2.charAt(y)!=sb.charAt(z)){
					result.append(s2.charAt(y));
					y++;
				}
				y++;
				result.append(sb.charAt(z));
			}
			while(x<s1.length()){
				result.append(s1.charAt(x));
				x++;
			}
			while(y<s2.length()){
				result.append(s2.charAt(y));
				y++;
			}
			System.out.println(result);
		}
	}

}
