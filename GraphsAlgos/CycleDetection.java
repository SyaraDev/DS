package com.syara.graphs;

import java.util.Arrays;
import java.util.LinkedList;

import com.syara.graphs.Graphs.Graph;

public class CycleDetection {
	
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
	
	static void addEdge(Graph graph, int src, int dest) {
		graph.vertex[src].add(dest);
		graph.vertex[dest].add(src);
	}
	
	static void isCycleDetected(Graph graph) {
		int[] cycArr = new int[graph.siz];
		Arrays.fill(cycArr, -1);
		boolean isCycle=false;
		for(int i=0; i<graph.siz; i++) {
			for(Integer k : graph.vertex[i]) {
				if(cycArr[k]==-1 || cycArr[i]==k) {
					cycArr[k]=i;
					System.out.print(k +" ");
					System.out.println(cycArr[k]);
				}
				else {
					isCycle=true;
					break;
				}
			}
			if(isCycle) {
				break;
			}
		}
		if(isCycle) {
			System.out.println("is a cycle");
		}
		else {
			System.out.println("not cycle");
		}
		
	}
	
	public static void main(String[] args) {
	    int V = 3; 
        Graph graph = new Graph(V); 
        addEdge(graph, 0, 1); 
        addEdge(graph, 0, 2); 
        addEdge(graph, 1, 2); 
		/*
		 * addEdge(graph, 1, 3); addEdge(graph, 1, 4); addEdge(graph, 2, 3);
		 * addEdge(graph, 3, 4);
		 */ 
        isCycleDetected(graph);
	}
}
