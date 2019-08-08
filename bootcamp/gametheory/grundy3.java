package bootcamp.gametheory;
import java.util.*;
/* A recursive C++ program to find Grundy Number for
a game.
Game Description :  The game starts with a number- 'n'
and the player to move divides the number- 'n' with 2, 3
or 6 and then takes the floor. If the integer becomes 0,
it is removed. The last player to move wins.  */

public class grundy3 {

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
		set.add(calculateGrundy(n/2,dp));
		set.add(calculateGrundy(n/3,dp));
		set.add(calculateGrundy(n/6,dp));
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
