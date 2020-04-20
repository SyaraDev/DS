package com.syara.graphs.Prims;

public class MultiStageGraphs {
	static final int MaxV = 45454545;
public static void main(String[] args) {
	  int[][] graph = new int[][]
		   {{0, 1, 2, 5, 0, 0, 0, 0}, 
	        {0, 0, 0, 0, 4, 11, 0, 0}, 
	        {0, 0, 0, 0, 9, 5, 16, 0}, 
	        {0, 0, 0, 0, 0, 0, 2, 0}, 
	        {0, 0, 0, 0, 0, 0, 0, 18}, 
	        {0, 0, 0, 0, 0, 0, 0, 13}, 
	        {0, 0, 0, 0, 0, 0, 0, 2}}; 
	        shortestDist(graph);
	//        System.out.println(shortestDist(graph)); 
	    } 
static void shortestDist(int[][] graph) {
	int n= graph.length+1;
	int[] weighs = new int[n];
	int[] paths = new int[n];
	
	for(int i=0;i<weighs.length;i++) {
		weighs[i]=MaxV;
		paths[i]=-1;
	}
	weighs[n-1] = 0;
	for(int i= n-2; i>= 0; i--) {
		int pathV = -1;
		for(int j=i; j<n; j++) {
			if(graph[i][j]!=0 &&  weighs[j]+graph[i][j]< weighs[i]) {
				weighs[i] = weighs[j]+graph[i][j];
				pathV = j;
			                        	
			}
		}
		//weighs[i]= min;
		paths[i]=pathV;
	}
	int[] result = new int[4];
	result[0] = 0;
	int v=0;
		
		  for(int i=1; i<4; i++) { result[i]= paths[v]; v= result[i]; } for(int i:
		  result) { System.out.print( i +"--"); } System.out.println(); for(int i:
		  paths) { System.out.print( i +"--"); }
		 
	System.out.println();
	for(int i: weighs) {
		System.out.print( i +"--");
	}
}
}

