package Homework5;

/**
 * Do not modify this file.
 * Your Edge implementation should implement this interface.
 */

public interface IEdge {

	/**
	 * Here is the general information regarding your Edge class.
	 * Each edge should have:
	 		a non negative weight (e.g. 4 or 101.2), 
	 		a source vertex (e.g. Vertex A),
	 		and a destination vertex (e.g. Vertex B).
	 */
	
	/**
	 * Constructor:
	 * 		Your constructor for Edge class should take:
	 * 			 a weight, 
	 * 			 a source vertex 
	 * 			 and a destination vertex as parameters.
	 */
	
	/**
	 * toString returns a formatted String in the following format:
	 * 
	 *  (A - B)
	 *   where A is the source, B is the destination and - represents the edge between A and B.
	 */
	public String toString();
	
}
