package dpCorrect;
import java.util.*;
public class MobileNumericKeypad {

	static long[][] dp=new long[10][31];
	static class Graph{
		int V;
		Vector<Integer>[] adj;
		@SuppressWarnings("unchecked")
		Graph(int V){
			this.V=V;
			adj=new Vector[V];
			for(int i=0;i<V;i++){
				adj[i]=new Vector<>(0,1);
			}
		}
		
		void addEdge(int u,int v){
			if(u==v){
				adj[u].add(v);
				return;
			}
			adj[u].add(v);
			adj[v].add(u);
		}
		
		long dfs(int n){
			long cnt=0;
			for(int i=0;i<V;i++){
				cnt+=(dfs(i, n));
			}
			System.out.println();
			return cnt;
		}
		
		long dfs(int u,int n){
			if(dp[u][n]!=0){
				return dp[u][n];
			}
			if(n==1){
				return dp[u][n]=1;
			}
			Vector<Integer> vec=adj[u];
			long cnt=0;
			for(Integer v:vec){
				cnt+=(dfs(v, n-1));
			}
			return dp[u][n]=cnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		
		Graph g=new Graph(10);
		for(int i=0;i<10;i++){
			g.addEdge(i, i);
		}
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 5);
		g.addEdge(4, 7);
		g.addEdge(5, 6);
		g.addEdge(5, 8);
		g.addEdge(6, 9);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(8, 0);
		
		int t=scn.nextInt();
		for(int i=0;i<t;i++){
			int n=scn.nextInt();
			System.out.println(g.dfs(n));
		}
	}

}
