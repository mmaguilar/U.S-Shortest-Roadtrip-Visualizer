package Homework5;

/**
 * Do not modify this file.
 * Your Vertex implementation should implement this interface.
 */

public interface IVertex {
	/**
	 * Here is the general information regarding your Vertex class.
	 * Each vertex should have:
	 		a String type value (e.g. "A" or "Boston"), 
	 		and a list of Edges (e.g. [(A - B), (A - C)]).	
	 
	 * Here are addition instance variables you need in this case:		
	 	* In order to visualize the map, you also need to keep track of its x and y coordinates on the map.
	 	
	 	* In order to calculate the shortest path between two vertices, you also need to keep track of:
	 		total distance (e.g. 19.23 or 1000),
	 		has visited or not e.g. true or false), 
	 		and where it is coming from (e.g. Vertex A).
	 */
	
	/**
	 * Constructors:
	 * 		Constructor 1: This constructor should take only a String value as its parameter.
	 * 					   In the constructor, initialize edge list, set x, y, total distance to 0; hasVisited to false
	 * 
	 * 
	 * 		Constructor 2: This constructor should take a String value, an x value and a y value as its parameter.
	 * 					   In the constructor, initialize and set all the instance variables.
	 */
	
	/**
	 * addEdge takes an edge e and adds e to the list of its adjacent edges.
	 * 
	 * @param e
	 */
	public void addEdge(Edge e);
	
	/**
	 * toString returns a formatted String in the following format:
	 * 
	 * A
	 * where A is the value of this vertex.
	 */
	public String toString();
}
