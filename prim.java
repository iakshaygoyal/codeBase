public class prim {

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
		int[] par = new int[v];
		boolean[] ismst = new boolean[v];
		
		for(int i=0; i<v; i++){
			key[i] = Integer.MAX_VALUE;
			ismst[i] = false;
		}
		key[0] = 0;
		par[0] = -1;
		
		for(int i=0; i<v-1; i++){
			int min = Integer.MAX_VALUE;
			int minidx = -1;
			for(int j=0; j<v; j++){
				if(ismst[j] == false && key[j] < min){
					min = key[j];
					minidx = j;
				}
			}
			ismst[minidx] = true;
			
			for(int j=0; j<v; j++){
				if(ismst[j] == false && graph[minidx][j] != 0 && graph[minidx][j] < key[j]){
					key[j] = graph[minidx][j];
					par[j] = minidx;
				}
			}
		}
		
		System.out.println("Edge    Weight");
		for(int i=1; i<v; i++){
			System.out.println(par[i] + " -> " + i + " =   " + graph[par[i]][i]);
		}
	}

}
