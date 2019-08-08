package graphAL;
import java.util.*;

//1
//11 17
//0 1
//0 1
//0 1
//1 0
//1 2
//1 10
//2 3
//2 4
//3 4
//4 10
//4 9
//10 9
//4 5
//5 6
//5 8
//6 4
//6 7
//0 9


//Using visited would not consider the cases of self loop but in case of not 
//using it, you would end up in an infinite loop in case there exists a cycle or loop

public class Count_All_Paths {
	static class Graph{
        int V;
        Vector<Integer>[] adj;
        
        @SuppressWarnings("unchecked")
        Graph(int V){
            this.V=V;
            adj=new Vector[V];
            
            for(int i=0;i<V;i++){
                adj[i]=new Vector<>();
            }
        }
        
        void addEdge(int u,int v){
            adj[u].add(v);
        }
        
        void display(){
        	for(int i=0;i<V;i++){
        		System.out.println(i+" : "+adj[i]);
        	}
        }
        
        int dfs(int s,int d){
            boolean[] visited=new boolean[V];
            visited[s]=true;
            int[][] dp=new int[V][V];
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    dp[i][j]=-1;
                }
            }
            return dfs(s,d,visited,dp);
        }
        
        int dfs(int s,int d,boolean[] visited,int[][] dp){
            if(s==d){
                visited[s]=false;
                return 1;
            }
            if(dp[s][d]!=-1){
                visited[s]=false;
                return dp[s][d];
            }
            
            int cnt=0;
            for(Integer i:adj[s]){
                if(!visited[i]){
                    visited[i]=true;
                    cnt+=dfs(i,d,visited,dp);
                }
            }
            visited[s]=false;
            return dp[s][d]=cnt;
        }
    }
     
	public static void main (String[] args){
	    Scanner scn=new Scanner(System.in);
	    int t=scn.nextInt();
	    for(int i=0;i<t;i++){
	        int v=scn.nextInt();
	        Graph g=new Graph(v);
	        int e=scn.nextInt();
	        for(int j=0;j<e;j++){
	            g.addEdge(scn.nextInt(), scn.nextInt());
	        }
	        g.display();
	        System.out.println(g.dfs(scn.nextInt(),scn.nextInt()));
	    }
	    scn.close();
	}
}