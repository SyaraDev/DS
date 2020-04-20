package com.syara.graphs.Prims;

public class AllPairShortestPath {
	static final int INF = 564564656;
	
public static void main(String[] args) {
    int graph[][] = { {0,   5,  INF, 10}, 
            {INF, 0,   3, INF}, 
            {INF, INF, 0,   1}, 
            {INF, INF, INF, 0} 
          }; 
   alpaiShPat(graph);
}

static void alpaiShPat(int[][]graph) {
for(int k=0; k<graph.length; k++) {
	for(int i=0; i<graph.length; i++) {
		for(int j=0; j<graph.length; j++) {
			if(graph[i][j]> graph[i][k] + graph[k][j]) {
				graph[i][j]=graph[i][k] + graph[k][j];
			}  
		}
	}
	
}
//printing all pair shortest distant path'
for(int i=0; i<graph.length; i++) {
	for(int j=0; j<graph.length; j++) {
		if(graph[i][j]==INF) {
			System.out.print("INF ");
		}
		else {
			System.out.print(graph[i][j] +" ");
		}
		
	}
	System.out.println();
}
	
}
}
