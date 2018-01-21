package graphKind;

import java.util.*;

/* 
http://www.geeksforgeeks.org/number-of-triangles-in-a-undirected-graph/
http://www.geeksforgeeks.org/number-of-triangles-in-directed-and-undirected-graphs/
Given a undirected graph with corresponding edges. Find the number of possible triangles?
Example:
0 1
2 1
0 2
4 1

Answer:
1
One method:
Time complexity:The time complexity of below algorithm is O(V3) where V is number of vertices in 
the graph, we can improve the performance to O(V2.8074) using Strassen’s matrix multiplication algorithm.
 Note: Theorem result 
If we compute An for an adjacency matrix representation of graph, then a value Apowern[i][j] represents number of 
distinct walks between vertex i to j in graph of length n. In A3, we get all distinct paths of length 3 between every 
pair of vertices.
A triangle is a cyclic path of length three, i.e. begins and ends at same vertex. So A3[i][i] represents a 
triangle beginning and ending with vertex i. Since a triangle has three vertices and it is counted for 
every vertex, we need to divide result by 3. Furthermore, since the graph is undirected, every triangle 
twice as i-p-q-j and i-q-p-j, so we divide by 2 also. Therefore, number of triangles is trace(A3) / 6.

for directed graphs we have to divide by 3.

Second Method:
The idea is to use three nested loops to consider every triplet (i, j, k) and check for the above condition 
(there is an edge from i to j, j to k and k to i).However in an undirected graph, the triplet (i, j, k) 
can be permuted to give six combination (See above first method for details). 
Hence we divide the total count by 6 to get the actual number of triangles.
In case of directed graph, the number of permutation would be 3 (as order of nodes becomes relevant). Hence in this case the total number of triangles will be obtained by dividing total count by 3.
 */
public class number_of_triangles_in_a_undirected_graph {

	private static class Edge {
		private final Object from;
		private final Object to;
		
		public Edge(Object from, Object to){
			this.from = from;
			this.to = to;
		}
		
		public Object getFrom(){return from;}
		public Object getTo(){return to;}
		
		@Override
		public String toString(){
			return "(" + ((from!=null) ? from.toString() : null) + "," + ((to!=null) ? to.toString() : null) + ")";
		}
	}
	
	
	
	public static Map<Object,Set<Object>> buildAdjacencyMap(List<Edge> edges){
		if ((edges==null) || (edges.isEmpty())){
			return Collections.<Object,Set<Object>>emptyMap();
		}
		
		Map<Object,Set<Object>> graph = new HashMap<>();
		for (Edge e : edges){
			if (!graph.containsKey(e.getFrom())){
				graph.put(e.getFrom(), new HashSet<Object>());
			}
			if (!graph.containsKey(e.getTo())){
				graph.put(e.getTo(), new HashSet<Object>());
			}
			graph.get(e.getFrom()).add(e.getTo());
			graph.get(e.getTo()).add(e.getFrom());
		}
		
		return graph;
	}
	//Second  Method
	public static int getNumberOfTriangles1(List<Edge> edges){
		Map<Object,Set<Object>> graph = buildAdjacencyMap(edges);
		
		int triangles = 0;
		for (Set<Object> neighbors : graph.values()){
			for (Object v2 : neighbors){
				for (Object v3 : neighbors){
					if ((!v2.equals(v3)) && (graph.get(v2).contains(v3))){
						triangles++;
					}
				}
			}
		}
		
		return (triangles/6);
	}
	
	//First Method
	static int[][] buildAdjacencyMatrix(ArrayList<Edge> edges){
		int[][]matrix=new int[5][5];
		for(int i=0;i<edges.size();i++){
			int row=(int) edges.get(i).from;
			int col=(int) edges.get(i).to;
			matrix[row][col]=1;
			matrix[col][row]=1;
		}
		return matrix;
	}
//  Utility function for matrix multiplication
static void multiply(int A[][], int B[][], int C[][])
{
    for (int i = 0; i < A.length; i++)
    {
        for (int j = 0; j <B.length ; j++)
        {
            C[i][j] = 0;
            for (int k = 0; k < C.length; k++)
                C[i][j] += A[i][k]*B[k][j];
        }
    }
}
 
//  Utility function to calculate trace of a matrix (sum of
//  diagnonal elements)
static int getTrace(int graph[][])
{
    int trace = 0;
    for (int i = 0; i < graph.length; i++)
        trace += graph[i][i];
    return trace;
}
	//First Method
	public static int  getNoOfTriangles(ArrayList<Edge> edges){
		int [][]matrix=buildAdjacencyMatrix(edges);
		int aux2[][]=new int[matrix.length][matrix[0].length];  // To Store graph^2
	    int aux3[][]=new int[matrix.length][matrix[0].length];; // To Store graph^3
	 
	    
	    // aux2 is graph^2 now  printMatrix(aux2);
	    multiply(matrix, matrix, aux2);
	 
	    // after this multiplication aux3 is
	    // graph^3 printMatrix(aux3);
	    multiply(matrix, aux2, aux3);
	 
	    int trace = getTrace(aux3);
	    return trace / 6;
	}
		
	
	public static void main(String[] args){
		Edge e1=new Edge(0,1);
		Edge e2=new Edge(2,1);
		Edge e3=new Edge(0,2);
		Edge e4=new Edge(4,1);
		ArrayList<Edge> edges=new ArrayList<Edge>();
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		System.out.println(getNumberOfTriangles1( edges));//Second Method-time complexity:0(n3-cube)
		System.out.println(getNoOfTriangles(edges));//First Method
	}
	
}

