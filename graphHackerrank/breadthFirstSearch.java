package graphHackerrank;
import java.util.*;
public class breadthFirstSearch {

	public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int q=s.nextInt();
        for(int i=0;i<q;i++){
            int n=s.nextInt();
            int m=s.nextInt();
            int[][] graph=new int[n][n];
            for(int j=0;j<m;j++){
            	int a=s.nextInt();
            	int b=s.nextInt();
                graph[a-1][b-1]=6;
                graph[b-1][a-1]=6;
            }
            int src=s.nextInt();
            dijkstra(graph,src-1);
        }
    }
	
    public static void dijkstra(int[][] graph,int src){
        int v=graph.length;
        int[] dist=new int[v];
        boolean[] spt=new boolean[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
            spt[i]=false;
        }
        dist[src]=0;
        for(int i=0;i<v-1;i++){
            int min=Integer.MAX_VALUE;
            int idx=-1;
            for(int j=0;j<v;j++){
                if(spt[j]==false && dist[j]<=min){
                    min=dist[j];
                    idx=j;
                }
            }
            spt[idx]=true;
            for(int j=0;j<v;j++){
                if(spt[j]==false && graph[idx][j]!=0 && dist[idx]+graph[idx][j]<dist[j]){
                    dist[j]=dist[idx]+graph[idx][j];
                }
            }
        }
        for(int i=0;i<v;i++){
            if(dist[i]==Integer.MAX_VALUE || dist[i]<0){
                System.out.print("-1 ");
            }
            else if(dist[i]==0){
                continue;
            }
            else{
                System.out.print(dist[i]+" ");
            }
        }
        System.out.println();
    }
}