package bootcamp.linearReccurene;
import java.util.*;
import java.lang.*;
public class matrixMultipication {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		int n=s.nextInt();
		int p=s.nextInt();
		int[][] a=new int[m][n];
		int[][] b=new int[n][p];
		int[][] c=new int[m][p];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				a[i][j]=s.nextInt();
			}
		}
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<p;j++){
				b[i][j]=s.nextInt();
			}
		}
		System.out.println();
		for(int i=0;i<m;i++){
			for(int j=0;j<p;j++){
				for(int k=0;k<n;k++){
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<p;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

}
