package Questions.DpWithBitmasking;
import java.util.*;
public class NQueen1 {

	static int n;
	static int cnt;
	static boolean[] rowarr;
	static boolean[] d1arr;
	static boolean[] d2arr;
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			cnt=0;
			n=scn.nextInt();
			rowarr=new boolean[n];
			d1arr=new boolean[2*n-1];
			d2arr=new boolean[2*n-1];
			solve(0);
			System.out.println(cnt);
		}
	}
	
	static void solve(int col){
		if(col==n){
			cnt++;
			return;
		}
		for(int row=0;row<n;row++){
			if(!rowarr[row] && !d1arr[row-col+(n-1)] && !d2arr[row+col]){
				rowarr[row]=d1arr[row-col+(n-1)]=d2arr[row+col]=true;
				solve(col+1);
				rowarr[row]=d1arr[row-col+(n-1)]=d2arr[row+col]=false;
			}
		}
	}

}
