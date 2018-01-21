package graphKind;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Bridge_points_in_a_graph {
	// A Java program to find bridges in a given undirected graph

	// This class represents a undirected graph using adjacency list
	// representation
	class Graph {
		private int V; // No. of vertices

		// Array of lists for Adjacency List Representation
		private LinkedList<Integer> adj[];
		int time = 0;
		static final int NIL = -1;

		// Constructor
		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; ++i)
				adj[i] = new LinkedList();
		}

		// Function to add an edge into the graph
		void addEdge(int v, int w) {
			adj[v].add(w); // Add w to v's list.
			adj[w].add(v); // Add v to w's list
		}

		// A recursive function that finds and prints bridges
		// using DFS traversal
		// u --> The vertex to be visited next
		// visited[] --> keeps tract of visited vertices
		// disc[] --> Stores discovery times of visited vertices
		// parent[] --> Stores parent vertices in DFS tree
		void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
			visited[u] = true;
			int start = 0;
			int end = 0;
			boolean found = false;
		

			// Go through all vertices aadjacent to this
			Iterator<Integer> i = adj[u].iterator();
			while (i.hasNext()) {
				int v = i.next();
				if (!visited[v]) {
					parent[v] = u;
					bridgeUtil(v, visited, disc, low, parent);
					Iterator<Integer> i2=adj[u].iterator();
					int count=0;
					   while(i2.hasNext()){
						   count++;
						   int v2 = i2.next();
							if (v2 == parent[u]) {
								found = true;
								start = u;
								end = v2;
								
							}
							
					   }
				
					if(count>1){
						found=false;
					}
					

				} 
				else {
					boolean check=false;
					Iterator<Integer> i1=adj[u].iterator();
			   while(i1.hasNext()){
				   int v1 = i1.next();
					if (!visited[v1]) {
					check=true;
			   }
			   }
			 
			   if(!check){
				   found=false;
					Iterator<Integer> i2=adj[u].iterator();
					int count=0;
					   while(i2.hasNext()){
						   count++;
						   int v2 = i2.next();
							if (v2 == parent[u]) {
								found = true;
								start = u;
								end = v2;
								
							}
							if(parent[v2]==u){
								count--;
							}
					   }
				
					if(count>1){
						found=false;
					}
					 break;
				}
                      
				}

			}
			if (found) {
				System.out.println(start + " " + end);
			}
		}

		// DFS based function to find all bridges. It uses recursive
		// function bridgeUtil()
		void bridge() {
			// Mark all the vertices as not visited
			boolean visited[] = new boolean[V];
			int disc[] = new int[V];
			int low[] = new int[V];
			int parent[] = new int[V];

			// Initialize parent and visited, and ap(articulation point)
			// arrays
			for (int i = 0; i < V; i++) {
				parent[i] = NIL;
				visited[i] = false;
			}

			// Call the recursive helper function to find Bridges
			// in DFS tree rooted with vertex 'i'
			for (int i = 0; i < V; i++)
				if (visited[i] == false)
					bridgeUtil(i, visited, disc, low, parent);
		}
	}

	public static void main(String args[]) {
		// Create graphs given in above diagrams
		System.out.println("Bridges in first graph ");
		Bridge_points_in_a_graph t = new Bridge_points_in_a_graph();
		Graph g1 = t.new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.bridge();
		System.out.println();

		System.out.println("Bridges in Second graph");
		Graph g2 = t.new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.bridge();
		System.out.println();

		System.out.println("Bridges in Third graph ");
		Graph g3 = t.new Graph(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		g3.bridge();
	}

}
