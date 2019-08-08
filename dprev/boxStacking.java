package dprev;
import java.util.*;
//4
//4 6 7
//1 2 3
//4 5 6
//10 12 32
public class boxStacking {

	// we are only considering the 3 instances out of 6 instances as the 2 instances with same height can be used simultaneously
	// we are sorting the blocks according to there base areas as a block with a larger area can be placed inside the block with lower area but the other case is not possible
	static class tri implements Comparable<tri>{
		int h;
		int w;
		int d;
		tri(int h,int w,int d){
			this.h=h;
			this.w=w;
			this.d=d;
		}
		tri(){}
		public int compareTo(tri t){
			return ((t.w)*(t.d)-(this.w)*(this.d));
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		tri[] a=new tri[n];
		for(int i=0;i<n;i++){
			a[i]=new tri(s.nextInt(),s.nextInt(),s.nextInt());
		}
		tri[] b=new tri[3*n];
		for(int i=0;i<(3*n);i++){
			b[i]=new tri();
		}
		int k=0;
		for(int i=0;i<n;i++){
			int x=a[i].h;
			int y=a[i].w;
			int z=a[i].d;
			for(int j=0;j<3;j++){
				if(j==0){
					b[k].h=x;
					if(y>z){
						b[k].w=y;
						b[k].d=z;
					}
					else{
						b[k].d=y;
						b[k].w=z;
					}
				}
				else if(j==1){
					b[k].h=y;
					if(x>z){
						b[k].w=x;
						b[k].d=z;
					}
					else{
						b[k].d=x;
						b[k].w=z;
					}
				}
				else{
					b[k].h=z;
					if(x>y){
						b[k].w=x;
						b[k].d=y;
					}
					else{
						b[k].d=x;
						b[k].w=y;
					}
				}
				k++;
			}
		}
		Arrays.sort(b);
		int[] dp=new int[3*n];
		for(int i=0;i<(3*n);i++){
			dp[i]=b[i].h;
		}
		for(int i=1;i<(3*n);i++){
			for(int j=0;j<i;j++){
				if(b[j].d>b[i].d && b[j].w>b[i].w && dp[j]+b[i].h>dp[i]){
					dp[i]=dp[j]+b[i].h;
				}
			}
		}
		int max=-1;
		for(int i=0;i<(3*n);i++){
			if(dp[i]>max){
				max=dp[i];
			}
		}
		System.out.println(max);
	}

}
