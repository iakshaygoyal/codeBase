package strings;
import java.util.*;
public class googleInterview {
//	5 5
//	a c p r c
//	x s o p c
//	v o v n i
//	w g f m n
//	q a t i t
//	9
//	m i c r o s o f t
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int row=s.nextInt();
		int col=s.nextInt();
		char[][] M=new char[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				M[i][j]=s.next().charAt(0);
			}
		}
		int n=s.nextInt();
		char[] P=new char[n];
		for(int i=0;i<n;i++){
			P[i]=s.next().charAt(0);
		}
		System.out.println(foundPattern(M, P, row, col, n));
	}
	
	
	static boolean foundPattern(char[][] M,char[] P,int row,int col,int n){
		boolean[][] visited=new boolean[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(foundPattern(M, P, visited, row, col, n, i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	static boolean foundPattern(char[][] M,char[] P,boolean[][] visited,int row,int col,int n,int x,int y,int level){
		if(x==row || y==col || x==-1 || y==-1){
			return false;
		}
		if(level==n){
			return true;
		}
		if(visited[x][y]){
			return false;
		}
		if(M[x][y]!=P[level]){
			return false;
		}
		else{
			visited[x][y]=true;
			boolean b1=foundPattern(M, P, visited, row, col, n, x-1, y-1, level+1);
			boolean b2=foundPattern(M, P, visited, row, col, n, x-1, y, level+1);
			boolean b3=foundPattern(M, P, visited, row, col, n, x-1, y+1, level+1);
			boolean b4=foundPattern(M, P, visited, row, col, n, x, y-1, level+1);
			boolean b5=foundPattern(M, P, visited, row, col, n, x, y+1, level+1);
			boolean b6=foundPattern(M, P, visited, row, col, n, x+1, y-1, level+1);
			boolean b7=foundPattern(M, P, visited, row, col, n, x+1, y, level+1);
			boolean b8=foundPattern(M, P, visited, row, col, n, x+1, y+1, level+1);
			visited[x][y]=false;
			return b1||b2||b3||b4||b5||b6||b7||b8;
		}
	}
}