package com.syara.graphs.Prims;

public class DijkstraAlgo {
	static void primMST(int[][]graph, int v) {
		int[] key = new int[v];
		boolean[] mst  = new boolean[v];
		
		for(int i=0; i<v; i++) {
			key[i]  = Integer.MAX_VALUE;
			mst[i] = false;
		}
		
		int count=0;
		key[0]=0;
		while(count++<v-1) {
			int u = getLeastWeight(key,mst);
			mst[u]= true;
			for(int i=0; i<v; i++) {
				if(graph[u][i]!=0 && mst[i]==false && key[u]+graph[u][i]<key[i]) {
					key[i]= graph[u][i] + key[u];
				}
			}
		
		}
		printDijkl(key);
	//	printMST(parent,graph);
	}
	static void printDijkl(int[] key) {
		for(int i=0; i< key.length; i++) {
			System.out.println(i +" -- " +key[i]);
		}
	}
	static void printMST(int[]parent, int[][]graph){
	     for(int i=1; i<parent.length; i++) {
	    	 System.out.println(parent[i] +"--" +i + " weight " +graph[i][parent[i]]);
	     }
	}
	static int getLeastWeight(int[]key, boolean[]mst) {
		int minIndex = -1;
		int minValue= Integer.MAX_VALUE;
		for(int i=0; i<key.length; i++) {
			if(key[i]<minValue && mst[i]==false) {
				minValue = key[i];
				minIndex= i;
			}
		}
		return minIndex;
	}
	public static void main(String[] args) {
		int v=9;
		 int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
             { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
             { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
             { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
             { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
             { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
             { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
             { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
             { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
  
        // Print the solution 
        primMST(graph,v); 
}
}
