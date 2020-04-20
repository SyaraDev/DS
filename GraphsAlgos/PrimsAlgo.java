package com.syara.graphs.Prims;

public class PrimsAlgo {

	static void primMST(int[][]graph, int v) {
		int[] key = new int[v];
		boolean[] mst  = new boolean[v];
		
		for(int i=0; i<v; i++) {
			key[i]  = Integer.MAX_VALUE;
			mst[i] = false;
		}
		
		int count=0;
		key[0]=0;
		int[] parent = new int[v];
		parent[0]=-1;
		while(count++<v-1) {
			int u = getLeastWeight(key,mst);
			mst[u]= true;
			for(int i=0; i<v; i++) {
				if(graph[u][i]!=0 && mst[i]==false && graph[u][i]<key[i]) {
					key[i]= graph[u][i];
					parent[i]=u;
				}
			}
		
		}
		printMST(parent,graph);
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
		int v=5;
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } }; 
  
        // Print the solution 
        primMST(graph,v); 
}
}
