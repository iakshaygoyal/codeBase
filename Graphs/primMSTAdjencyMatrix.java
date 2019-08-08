package Graphs;

public class primMSTAdjencyMatrix {

	public static void main(String[] args) {
		int graph[][] = {{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
               };
		prim(graph);
	}
	
	public static void prim(int[][] graph){
		int v = graph.length;
		int[] key = new int[v];
		int[] parent = new int[v];
		boolean[] mst = new boolean[v];
		
		for(int i=0; i<v; i++){
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		
		for(int i=0; i<v-1; i++){
			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for(int j=0; j<v; j++){
				if(mst[j] == false && key[j] < min){
					min = key[j];
					minidx = j;
				}
			}
			mst[minidx] = true;
			
			for(int j=0; j<v; j++){
				if(mst[j] == false && graph[minidx][j] != 0 && graph[minidx][j] < key[j]){
					key[j] = graph[minidx][j];
					parent[j] = minidx;
				}
			}
		}
		
		System.out.println("Edge    Weight");
		for(int i=1; i<v; i++){
			System.out.println(parent[i] + " -> " + i + " =   " + graph[parent[i]][i]);
		}
	}

}
