package Graphs;

import Graphs.Interfaces.negativeCycleException;

public class floydWarshallAdjaencyMatrix {

	public static void main(String[] args) {
//		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//             {4, 0, 8, 0, 0, 0, 0, 11, 0},
//             {0, 8, 0, 7, 0, 4, 0, 0, 2},
//             {0, 0, 7, 0, 9, 14, 0, 0, 0},
//             {0, 0, 0, 9, 0, 10, 0, 0, 0},
//             {0, 0, 4, 14, 10, 0, 2, 0, 0},
//             {0, 0, 0, 0, 0, 2, 0, 1, 6},
//             {8, 11, 0, 0, 0, 0, 1, 0, 7},
//             {0, 0, 2, 0, 0, 0, 6, 7, 0}
//            };
		int[][] graph = {{0,4,5,6,0,0},{0,0,-3,0,0,0},{0,0,0,0,0,4},{0,0,0,0,2,0},{0,0,0,0,0,2},{0,0,0,0,1,0}};
            try {
				floydWarshall(graph);
			} catch (negativeCycleException e) {
				System.out.println(e);
			}
	}
	
	public static void floydWarshall(int[][] graph) throws negativeCycleException{
		int v = graph.length;
		int[][] distance = new int[v][v];
		int[][] path = new int[v][v];
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(graph[i][j] != 0){
					distance[i][j] = graph[i][j];
					path[i][j] = i;
				}
				else{
					if(i == j){
						distance[i][j] = 0;
					}
					else{
						distance[i][j] = Integer.MAX_VALUE;
					}
					path[i][j] = -1;
				}
			}
		}
		for(int k=0; k<v; k++){
			for(int j=0; j<v; j++){
				for(int i=0; i<v; i++){
					if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE){
						continue;
					}
					if(distance[i][j] > distance[i][k] + distance[k][j]){
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}
			}
		}
		
		for(int i=0; i<v; i++){
			if(distance[i][i] < 0){
				throw new negativeCycleException();
			}
		}
		
		System.out.println("DISTANCE :");
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				System.out.println(i + "=>" + j + "=" + distance[i][j]);
			}
		}
		
		System.out.println("PATHS :");
		
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				if(path[i][j] == -1){
					System.out.println(i + "=>" + j + " No path");
				}
				else{
					int k = j;
					while(k!=i){
						System.out.print(k + "<=");
						k = path[i][k];
					}
					System.out.println(i);
				}
			}
		}
	}

}
