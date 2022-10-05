package Homework5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

public class Graph implements IGraph{
	
	//instance variables 
	public List<Vertex> vertices;
	
	//constructor 
	public Graph() {
		this.vertices = new ArrayList<Vertex>();
	}

	@Override
	public boolean hasVertex(Vertex v) {
		//check to see if the graph is empty 
		if(vertices.size() == 0) {
			return false; 
		}else if (vertices.contains(v)) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<Vertex> getVertices() {
		if(vertices.size()==0) {
			return null;
		}else {
			return vertices; //return the list of vertices if list is not empty 
		}
	}

	@Override
	public void addVertex(Vertex v) {
		//check to see if the graph already contains the vertex
		if (hasVertex(v)) {
			//throw exception
			throw new IllegalArgumentException();
		}else { //else add the vertex to the graph
			v.totalDistance = Integer.MAX_VALUE;
			vertices.add(v);
		}
	}

	@Override
	public Vertex getVertex(String name) {
		//check to see if the vertices list is empty
		if(vertices.size() == 0) {
			throw new NoSuchElementException();
		}		
		//if not, loop through the list and compare each of the vertex values with the name
		for (int i = 0; i < vertices.size(); i++) {
			//if is equal, return he vertex with value 
			if (vertices.get(i).value.equals(name)) {
				return vertices.get(i);
			}
		}
		//else return null (not found)
		return null;
	}

	@Override
	public void addEdge(String start, String dest, Double cost) {
		//look for the start vertex
		Vertex startVertex = getVertex(start);
		//look for the dest vertex
		Vertex destVertex = getVertex(dest);
		

		//check to see if there is no vertex in the graph's list of vertices
		if (startVertex == null || destVertex == null) {
			throw new NoSuchElementException();
		}
		//make a new edge connecting the vertices with the cost
		Edge newEdge = new Edge(cost, startVertex, destVertex);
		//add the edge to the list of edges
		startVertex.addEdge(newEdge);
		//assign the cost to the weight of the edge
		newEdge.weight = cost;
		//update the vertex instance variables
		
		if (destVertex.comingFrom == null) {
			destVertex.comingFrom = startVertex;
		}
		
	}

	@Override
	//can call addedge to both ends
	//
	public void addUndirectedEdge(String start, String dest, Double cost) {
		//check to see if it works 
		//call the directed edge function going both ways
		addEdge(start, dest, cost);
		addEdge(dest, start, cost);

	}
	
	
	/**
	 * findClosestVertex takes a list of vertices
	 * and returns the index of the vertex that has the least amount of total distance.
	 * @param list
	 * @return
	 */
	@Override
	public int findClosestVertex(List<Vertex> list) {
		//independent of where starting
		
		//keep track of each vertex's total distance 
		double minCost = Integer.MAX_VALUE; //initialize it to infinity (or largest integer)
		//keep track of the index 
		int index = -1;
		
		//go through the list 
		for (int i = 0; i < list.size(); i++) {
			//check to see if each vertex's total distance is less than the minCost 
			if (list.get(i).totalDistance < minCost) {
				minCost = list.get(i).totalDistance;
				//return the index of the closest Vertex
				index = i;
			}
		}
		
		//when have gone through the whole list, return the vertex index
		return index;
	}

	/**
	 * dijkstra takes a starting value
	 * and runs dijkstra's algorithm on the graph.
	 * Use the homework description to structure your code logic.
	 * @param s
	 */
	@Override
	public void dijkstra(String s) {
		//initialize a vertex as the starting vertex
		Vertex startVertex = getVertex(s);
		
		//set the total distance to 0 for startVertex
		startVertex.totalDistance = 0;
		//set hasVisited to true for startVertex
		startVertex.hasVisited = true;
						
		//keep set of visited vertices 
		Set<Vertex> visited = new HashSet<>();
		//also keep an arraylist of the unvisited vertices
		ArrayList<Vertex> unvisited = new ArrayList<>();

		//add the starting vertex to the set of visited vertices
		visited.add(startVertex);
				
		//for every neighbor of s, set the total distance to the cost of the edge 
		for(Edge edge: startVertex.neighbors) {
			//update the distance for all the edge destinations
			edge.dest.totalDistance = edge.weight;
			//add the nieghbor to the list of unvisited vertices
			unvisited.add(edge.dest); 

		}
		
		//while all the unvisited vertices have not been visited...
		while(unvisited.size() != 0){
			//find the next closest vertex using the index of the vertex with the shortest distance			
			Vertex nextVertex = unvisited.get(findClosestVertex(unvisited));
			
			//update hasVisited to true;
			nextVertex.hasVisited = true;
			//add that vertex to the visited list 
			visited.add(nextVertex);
			
			//remove the vertex from the unvisited list 
			ArrayList<Vertex> v = new ArrayList<Vertex>();
			v.add(nextVertex);
			unvisited.removeAll(v);
			v.remove(0);
			
			//add its neighbors to the list of unvisited vertices
			for (Edge edge: nextVertex.neighbors) {
				
				if (edge.dest.hasVisited == false) {

					//set the totalDistance of the neighbors to the weight/cost of the edge
					if(edge.dest.totalDistance > (edge.weight + edge.source.totalDistance)) {
						edge.dest.totalDistance = edge.weight + edge.source.totalDistance;
						edge.dest.comingFrom = edge.source;
					}
				
					//add the neighbors to the list of unvisited vertices
					unvisited.add(edge.dest);
					//check to see if the destination of the current edge is the start
				}else if (edge.dest.value.equals(startVertex.value)) {
					//set its source to the startVertex
					edge.source.comingFrom = startVertex;
				}
				
			}
		}		
				
		
	}
		
			
	/**
	 * getDijkstraPath takes a starting value and destination value
	 * first runs dijkstra's algorithm on the graph,
	 * then reconstruct the path going from the vertex with the starting value to the vertex with the destination value.
	 * You may use any List type data structures (e.g., ArrayList, LinkedList, etc.) 
	 * @param start
	 * @param dest
	 * @return
	 */
	@Override
	public List<Edge> getDijkstraPath(String start, String dest) {
		//run dijkstra's algorithmn on the graph
		dijkstra(start);
				
		//create a stack of Edges
		Stack<Edge> stack = new Stack<Edge>();
		
		
		//create a current reference to the destination vertex
		Vertex current = getVertex(dest);
		
		//first add the first edge from the destination to the stack
		for (Edge currentNeighbor: current.comingFrom.neighbors) {
			//if the neighbor's dest is the current city
			if(currentNeighbor.dest.value.equals(current.value)) {
				//push it into the stack
				stack.push(currentNeighbor);
			}
		}
		
		//loop through each of the city's coming From while it is not the start value itself (already added)
		while (current.comingFrom.value != null && !stack.peek().source.value.equals(start)){
			//look through each of the current city's source neighbors
			for (Edge e: current.comingFrom.neighbors) {
				//if the destination is the next city 
				if(e.dest.value.equals(current.comingFrom.comingFrom.value)) {
					//push the edge into the stack
					stack.push(e);
				}
			}
			//then set the current city to the next edge source in the stack
			current = stack.peek().source;
			//if the edge's destination is the start, you can break out of the while loop
			if (stack.peek().dest.value.equals(start)) {
				break;
			}
		}
		
		//create a list to return 
		ArrayList<Edge> path = new ArrayList<Edge>();
				
		//pop() and add the edges to a list 
		while(!stack.isEmpty()) {
				path.add(stack.peek());
				stack.pop();
		}
				
		return path;
		
	}

	
	/**
	 * printGraph prints the entire graph in the following format:
	 * 
	 *  A: (A - B)(A - C)(A - E)
	 *  ......
	 * 
	 * A is a vertex and (A - B)(A - C)(A - E) are all the edges between A and its neighbors.
	 */
	@Override
	public void printGraph() {
		//for each vertex in the graph 
		for (Vertex v: vertices) {
			//create 2 string objects to add to 
			String print1 = v.value + ": ";
			String print2 = v.value + " is a vertex and ";
			//for each of the edges for the vertex
			if(v.neighbors.isEmpty()) {
				print1 += v.value + " has no edges.";
				print2 += "()";
			}else {
				for (Edge edge: v.neighbors) {
					//add the edge to the string 
					print1 += edge.toString();
					//add the edge to the second string 
					print2 += edge.toString();
				}
				
			}
			System.out.println(print1);
			System.out.println(print2 + " are all the edges between " + v.value + " and its neighbors");
			System.out.println();

		}
			
	}

}
