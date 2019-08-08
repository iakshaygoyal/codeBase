package Questions.DpWithBitmasking;
import java.util.*;
public class NQueen2 {

	static int DONE;
	static int cnt;
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			cnt=0;
			DONE=(1<<n)-1;
			solve(0, 0, 0);
			System.out.println(cnt);
		}
	}
	
	static void solve(int rowmask,int ld,int rd){
		if(rowmask==DONE){
			cnt++;
			return;
		}
		int safe=DONE&(~(rowmask|ld|rd));
		while(safe>0){
			int p=safe&(-safe);
			safe-=(p);
			solve(rowmask|p, (ld|p)<<1, (rd|p)>>1);
		}
	}

}
