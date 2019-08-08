package Graphs;

public class dijkstraShortestPathAlgoAdjacencyMatrix {

	public static void main(String[] args) {
		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
             {4, 0, 8, 0, 0, 0, 0, 11, 0},
             {0, 8, 0, 7, 0, 4, 0, 0, 2},
             {0, 0, 7, 0, 9, 14, 0, 0, 0},
             {0, 0, 0, 9, 0, 10, 0, 0, 0},
             {0, 0, 4, 14, 10, 0, 2, 0, 0},
             {0, 0, 0, 0, 0, 2, 0, 1, 6},
             {8, 11, 0, 0, 0, 0, 1, 0, 7},
             {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };
		dijkstra(graph, 1);
	}
	
	public static void dijkstra(int[][] graph, int src){
		int v = graph.length;
		int[] dist = new int[v];
		int[] par = new int[v];
		boolean[] spt = new boolean[v];//shortest path tree
		
		for(int i=0; i<v; i++){
			dist[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}
		dist[src] = 0;
		par[src] = -1;
		
		for(int i=0; i<v-1; i++){
			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for(int j=0; j<v; j++){
				if(spt[j] == false && dist[j] < min){
					min = dist[j];
					minidx = j;
				}
			}
			spt[minidx] = true;
			
			for(int j=0; j<v; j++){
				if(spt[j] == false && graph[minidx][j] != 0 && dist[minidx] != Integer.MAX_VALUE && graph[minidx][j] + dist[minidx] < dist[j]){
					dist[j] = graph[minidx][j] + dist[minidx];
					par[j] = minidx;
				}
			}
		}
		
		System.out.println("Edge    distance");
		for(int i=0; i<v; i++){
			System.out.println(src + " -> " + i + " =   " + dist[i]);
		}
		
		System.out.println("Paths");
		for(int i=0; i<v; i++){
			int j = i;
			while(j != src){
				System.out.print(j + " <= ");
				j = par[j];
			}
			System.out.println(src);
		}
	}
}
