package dprev;
import java.util.*;
public class maxSumRectanglein2dMatrix {

//	4
//	5
//	1 2 -1 -4 -20
//	-8 -3 4 2 1
//	3 8 10 1 3
//	-4 -1 1 7 -6
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int[][] a=new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j]=s.nextInt();
			}
		}
		int row=n;
		int col=m;
		int MAX=-1;
		int[] temp=new int[row];
		for(int i=0;i<col;i++){
			Arrays.fill(temp,0);
			for(int j=i;j<col;j++){
				for(int k=0;k<row;k++){
					temp[k]+=(a[k][j]);
				}
				int max=-1;
				int curr=0;
				for(int k=0;k<row;k++){
					curr=Math.max(0,curr+=(temp[k]));
					max=Math.max(curr,max);
				}
				if(max>MAX){
					MAX=max;
				}
			}
		}
		System.out.println(MAX);
		
//		O(N^5)
		
		
//		int max=Integer.MIN_VALUE;
//		for(int i=0;i<n;i++){
//			for(int j=0;j<m;j++){
//				for(int k=1;k<=m;k++){
//					int sum=0;
//					for(int l=i;l<n;l++){
//						for(int o=j;o<k;o++){
//							sum+=(a[l][o]);
//						}
//						if(sum>max){
//							max=sum;
//						}
//					}
//				}
//			}
//		}
//		System.out.println(max);
		
		
//		O(N^4)
		
		
//		int max=Integer.MIN_VALUE;
//		int[][] temp=new int[n][m];
//		for(int i=0;i<n;i++){
//			for(int j=0;j<m;j++){
//				
//				for(int k=i;k<n;k++){
//					for(int l=j;l<m;l++){
//						temp[k][l]=a[k][l];
//					}
//				}
//
//				for(int k=i;k<n;k++){
//					for(int l=j;l<m;l++){
//						if(l!=j){
//							temp[k][l]+=temp[k][l-1];
//						}
//					}
//				}
//				
//				for(int l=j;l<m;l++){
//					for(int k=i;k<n;k++){
//						if(k!=i){
//							temp[k][l]+=(temp[k-1][l]);
//						}
//						if(temp[k][l]>max){
//							max=temp[k][l];
//						}
//					}
//				}
//
//			}
//		}
//		System.out.println(max);
	}

}