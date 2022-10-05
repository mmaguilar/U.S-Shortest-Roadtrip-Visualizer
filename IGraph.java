package Homework5;

import java.util.List;

/**
 * Do not modify this file.
 * Your Graph implementation should implement this interface.
 */
	
public interface IGraph {
	/**
	 * Here is the general information regarding your Graph class.
	 * Each graph should have:
	 * 		a list of Vertices
	 * 
	 * Assumption:
	 * 		This graph cannot have two vertices that have the same value.
	 */
	
	/**
	 * Constructor:
	 * 		The constructor should initialize the vertices list.
	 */

	/**
	 * hasVertex takes a Vertex v as parameter
	 * returns true if the graph contains any existing vertices that has the same value as the given vertex 
	 * @param v
	 * @return
	 */
	public boolean hasVertex(Vertex v);
	
	
	
	/**
	 * getVertices returns the list of Vertices of the graph.
	 * Since List is a Collection, you need a concrete class when creating a list object.
	 * You may use any List type data structures (e.g., ArrayList, LinkedList, etc.)
	 * @return
	 */
	public List<Vertex> getVertices();
	
	
	/**
	 * addVertex takes a Vertex v and add it to the graph.
	 * If the graph already contains a vertex with the same value, throw an IllegalArgumentException.
	 * @param v
	 */
	public void addVertex(Vertex v);
		
	
	/**
	 * getVertex takes a value and returns the vertex that contains the value.
	 * If the graph doesn't contain such vertex, return null.
	 * @param name
	 * @return
	 */
	public Vertex getVertex(String name);
	
	/**
	 * addEdge takes a starting value, a destination value, and a weight,
	 * and adds such edge between vertices that contain the starting value and destination value.
	 * This method constructs a directed edge, which means start -> dest.
	 * @param start
	 * @param dest
	 * @param cost
	 */
	public void addEdge(String start, String dest, Double cost);
	
	/**
	 * addUndirectedEdge takes a starting value, a destination value, and a weight,
	 * and adds a undirected edge between vertices that contain the starting value and destination value.
	 * This method constructs a undirected edge, which means start -> dest and dest -> start.
	 * @param start
	 * @param dest
	 * @param cost
	 */
	public void addUndirectedEdge (String start, String dest, Double cost);
	
	/**
	 * findClosestVertex takes a list of vertices
	 * and returns the index of the vertex that has the least amount of total distance.
	 * @param list
	 * @return
	 */
	public int findClosestVertex(List<Vertex> list);
	
	/**
	 * dijkstra takes a starting value
	 * and runs dijkstra's algorithm on the graph.
	 * Use the homework description to structure your code logic.
	 * @param s
	 */
	public void dijkstra (String s);
	
	/**
	 * getDijkstraPath takes a starting value and destination value
	 * first runs dijkstra's algorithm on the graph,
	 * then reconstruct the path going from the vertex with the starting value to the vertex with the destination value.
	 * You may use any List type data structures (e.g., ArrayList, LinkedList, etc.) 
	 * @param start
	 * @param dest
	 * @return
	 */
	public List<Edge> getDijkstraPath(String start, String dest);
	
	
	/**
	 * printGraph prints the entire graph in the following format:
	 * 
	 *  A: (A - B)(A - C)(A - E)
	 *  ......
	 * 
	 * A is a vertex and (A - B)(A - C)(A - E) are all the edges between A and its neighbors.
	 */
	public void printGraph();
	
}
