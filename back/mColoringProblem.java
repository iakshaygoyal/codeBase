package back;
import java.util.*;
public class mColoringProblem {


	static int[][] adj;
	static int[] color;
	static int V;
	static int m;
	public static void main (String[] args){
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			V=scn.nextInt();
			adj=new int[V][V];
			color=new int[V];
			Arrays.fill(color, -1);
			m=scn.nextInt();
			int e=scn.nextInt();
			for(int j=0;j<e;j++){
				int x=scn.nextInt()-1;
				int y=scn.nextInt()-1;
				adj[x][y]=1;
				adj[y][x]=1;
			}
			if(mc(0)){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
			System.out.println(Arrays.toString(color));
		}
	}
	
	static boolean mc(int u){
		if(u==V){
			return true;
		}
		for(int c=0;c<m;c++){
			if(isSafe(u, c)){
				color[u]=c;
				if(mc(u+1)){
					return true;
				}
				color[u]=-1;
			}
		}
		return false;
	}
	
	static boolean isSafe(int u,int c){
		for(int v=0;v<V;v++){
			if(adj[u][v]==1 && color[v]==c){
				return  false;
			}
		}
		return true;
	}
}
