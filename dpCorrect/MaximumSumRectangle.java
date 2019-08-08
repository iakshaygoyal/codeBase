package dpCorrect;
import java.util.*;
public class MaximumSumRectangle {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int row=scn.nextInt();
			int col=scn.nextInt();
			int[][] a=new int[row][col];
			for(int j=0;j<row;j++){
				for(int k=0;k<col;k++){
					a[j][k]=scn.nextInt();
				}
			}
			System.out.println(msr(a, row, col));
			System.out.println(msr1(a, row, col));
		}
	}
	
	//O(N^4)
	static int msr(int[][] a,int row,int col){
		int[][] b=new int[row][col];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				
				for(int k=i;k<row;k++){
					for(int l=j;l<col;l++){
						if(l==0){
							b[k][l]=a[k][l];
						}
						else{
							b[k][l]=b[k][l-1]+a[k][l];
						}
					}
				}
				
				for(int k=i+1;k<row;k++){
					for(int l=j;l<col;l++){
						b[k][l]+=(b[k-1][l]);
					}
				}
				
				for(int k=i;k<row;k++){
					for(int l=j;l<col;l++){
						if(b[k][l]>max){
							max=b[k][l];
						}
						b[k][l]=0;
					}
				}
			}
		}
		return max;
	}	
	
	
	//O(N^3)
	static int msr1(int[][] a,int row,int col){
		int[] b=new int[row];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<col;i++){
			Arrays.fill(b, 0);
			for(int j=i;j<col;j++){
				for(int k=0;k<row;k++){
					b[k]+=(a[k][j]);
				}
				int val=kadane(b);
				if(val>max){
					max=val;
				}
			}
		}
		return max;
	}
	static int kadane(int[] a){
		int n=a.length;
		int max=Integer.MIN_VALUE;
		int curr=0;
		for(int i=0;i<n;i++){
			curr+=(a[i]);
			if(curr>max){
				max=curr;
			}
			if(curr<0){
				curr=0;
			}
		}
		return max;
	}
	

}