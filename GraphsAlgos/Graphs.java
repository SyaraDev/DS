package com.syara.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graphs {

	static class Graph{
		int siz;
		LinkedList<Integer> vertex[];
		
		Graph(int siz){
			this.siz=siz;
			vertex = new LinkedList[siz];
			for(int i=0; i<siz; i++) {
				vertex[i]= new LinkedList<>();
			}
			
		}
	}
	static void DFSUtil(Graph graph,int v, boolean[] isVisited) {
		isVisited[v] = true;
		System.out.print(v +" ");
		Iterator<Integer> e = graph.vertex[v].iterator();
		while(e.hasNext()) {
			int r = e.next();
			if(!isVisited[r]) {
				DFSUtil(graph, r, isVisited);
			}
		}
	}
	static void dfs(Graph graph,int v) {
		boolean[] isVisited = new boolean[graph.siz];
		System.out.println("DFS print::::");
		DFSUtil(graph,v,isVisited);
	}
	
	static void addEdge(Graph graph, int src, int dest) {
		graph.vertex[src].add(dest);
		graph.vertex[dest].add(src);
	}
	static void printLinks(Graph graph) {
		for(int i=0; i<graph.siz; i++) {
			System.out.print(i +" ");
			for(Integer k:graph.vertex[i]) {
				
				System.out.print("--> " +k);
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
	    int V = 5; 
        Graph graph = new Graph(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
        printLinks(graph);
        dfs(graph,2);
	}
	
	
}	

