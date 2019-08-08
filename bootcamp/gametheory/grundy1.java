package bootcamp.gametheory;
import java.util.*;
/* A recursive C++ program to find Grundy Number for
a game which is like a one-pile version of Nim.
Game Description : The game starts with a pile of n stones,
and the player to move may take any positive number of
stones. The last player to move wins. Which player wins
the game? */
public class grundy1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] dp=new int[n+1];
		Arrays.fill(dp, -1);
		for(int i=0;i<=n;i++){
			System.out.print(calculateGrundy(i, dp)+" ");
		}
	}
	
	static int calculateGrundy(int n,int[] dp){
		if(dp[n]!=-1){
			return dp[n];
		}
		if(n==0){
			return dp[n]=0;
		}
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<=(n-1);i++){
			set.add(calculateGrundy(i,dp));
		}
		return dp[n]=calculateMex(set);
	}
	
	static int calculateMex(HashSet<Integer> set){
		int mex=0;
		while(set.contains(mex)){
			mex++;
		}
		return mex;
	}

}
