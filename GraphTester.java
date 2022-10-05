package Homework5;

import java.util.NoSuchElementException;

public class GraphTester {
	public static void main(String[] args) {
		//creating vertex 
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C", 3, 6);
		Vertex v4 = new Vertex("D", 2, 8);
		Vertex v5 = new Vertex("W");
		Vertex v6 = new Vertex("X");
		Vertex v7 = new Vertex("Y");
		Vertex v8 = new Vertex("Z");

		//testing edges 
		Edge e1 = new Edge(8, v1, v2);
		Edge e2 = new Edge(1, v3, v4);
		
		//testing graphs
		Graph g1 = new Graph();
		Graph g2 = new Graph();
		Graph g3 = new Graph();
		Graph g4 = new Graph();

		//adding to the graph
		System.out.println("Testing addVertex():");
		g1.addVertex(v1);
		g1.addVertex(v4);
		try {
			g1.addVertex(v4);
		}catch(IllegalArgumentException ex) {
			System.out.println("This vertex is already in the graph.");
		}
		
		g3.addVertex(v5);
		g3.addVertex(v6);
		g3.addVertex(v7);
		g3.addVertex(v8);
		
		System.out.println();
	
		//testing getVertices
		System.out.println("Testing getVertices():");
		System.out.println(g1.getVertices().toString());
		System.out.println();
		
		//testing hasVertex()
		System.out.println("Testing hasVertex():");
		System.out.println(g1.hasVertex(v4)); //true
		System.out.println(g1.hasVertex(v1)); //true
		System.out.println(g1.hasVertex(v2)); //false
		System.out.println();
		
		//testing getVertex()
		System.out.println("Testing getVertex():");
		System.out.println(g1.getVertex("A")); //return v1
		System.out.println(g1.getVertex("D")); //return v4
		System.out.println(g1.getVertex("E")); //return null
		try {
			System.out.println(g2.getVertex("C"));

		}catch(NoSuchElementException ex) {
			System.out.println("There are no vertices in this graph.");

		}
		System.out.println();


		//testing to String 
		System.out.println("Testing toString():");
		System.out.println("Vertices:");
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v3.toString());
		System.out.println(v4.toString());
		System.out.println();

		System.out.println("Edges:");
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println();

		//Testing addEdge();
		System.out.println("Testing addEdge():");
		g3.addEdge("W", "Y", 7.9);
		g3.addEdge("X", "Z", 5.2);
		g1.addEdge("A", "D", 1.0);
		try {
			g1.addEdge("C", "D", 4.0);
		}catch(NoSuchElementException ex) {
			System.out.println("One of the vertices is not in the graph.");
		}
		System.out.println("New vertices with edges:");
		System.out.println(v5.neighbors.toString());
		
		//testing the weight
		for (int i = 0; i < v5.neighbors.size(); i++) {
			System.out.println(v5.neighbors.get(i).weight);
		}
		System.out.println(v6.neighbors.toString());
		for (int i = 0; i < v6.neighbors.size(); i++) {
			System.out.println(v6.neighbors.get(i).weight);
		}
		System.out.println(v1.neighbors.toString());
		for (int i = 0; i < v1.neighbors.size(); i++) {
			System.out.println(v1.neighbors.get(i).weight);
		}
		System.out.println();


		System.out.println("ComingFrom:");
		System.out.println(v7.comingFrom + " -> " + v7.value);
		System.out.println(v8.comingFrom + " -> " + v8.value);
		System.out.println(v4.comingFrom + " -> " + v4.value);
		System.out.println();
	
		g3.addUndirectedEdge("X", "Y", 2.9);
		
	
		System.out.println();
		System.out.println("Coming from:");
		System.out.println(v6.comingFrom); //X
		System.out.println(v7.comingFrom); //Y
		System.out.println(v8.comingFrom); //Y		

		try {
			g1.addUndirectedEdge("C", "A", 4.0);
		}catch(NoSuchElementException ex) {
			System.out.println("One of the vertices is not in the graph.");
		}
		
		System.out.println();
		System.out.println("Testing Dijkstra's:");
		System.out.println();
		
		//creating vertices
		Vertex dv1 = new Vertex("A");
		Vertex dv2 = new Vertex("B");
		Vertex dv3 = new Vertex("C");
		Vertex dv4 = new Vertex("D");
		Vertex dv5 = new Vertex("E");
		Vertex dv6 = new Vertex("F");
		Vertex dv7 = new Vertex("G");
		
		//adding vertices
		g4.addVertex(dv1);
		g4.addVertex(dv2);
		g4.addVertex(dv3);
		g4.addVertex(dv4);
		g4.addVertex(dv5);
		g4.addVertex(dv6);
		g4.addVertex(dv7);
		
		/**
		//adding edges
		g4.addEdge("A", "B", 2.0); //A -> B
		g4.addEdge("A", "D", 1.0); //A -> D
		g4.addEdge("B", "E", 10.0); //B -> E
		g4.addEdge("D", "E", 2.0); //D -> E
		g4.addEdge("C", "A", 4.0); //C -> A
		g4.addEdge("B", "D", 3.0); //B -> D
		g4.addEdge("C", "F", 5.0); //C -> F
		g4.addEdge("D", "G", 4.0); //D -> G
		g4.addEdge("E", "G", 6.0); //E -> G
		g4.addEdge("G", "F", 1.0); //G -> F
		g4.addEdge("D", "F", 8.0); //D -> F
		g4.addEdge("D", "C", 2.0); //D -> C
		*/
		
		//adding edges
				g4.addUndirectedEdge("A", "B", 2.0); //A -> B
				g4.addUndirectedEdge("A", "D", 1.0); //A -> D
				g4.addUndirectedEdge("B", "E", 10.0); //B -> E
				g4.addUndirectedEdge("D", "E", 2.0); //D -> E
				g4.addUndirectedEdge("C", "A", 4.0); //C -> A
				g4.addUndirectedEdge("B", "D", 3.0); //B -> D
				g4.addUndirectedEdge("C", "F", 5.0); //C -> F
				g4.addUndirectedEdge("D", "G", 4.0); //D -> G
				g4.addUndirectedEdge("E", "G", 6.0); //E -> G
				g4.addUndirectedEdge("G", "F", 1.0); //G -> F
				g4.addUndirectedEdge("D", "F", 8.0); //D -> F
				g4.addUndirectedEdge("D", "C", 2.0); //D -> C

		
		//Tester to print commented in graph class
		g4.dijkstra("A");
		System.out.println();
		g4.getDijkstraPath("A", "B");
		System.out.println();

		g4.getDijkstraPath("A", "E");
		System.out.println();

		g4.getDijkstraPath("A", "G");
		System.out.println();

		g4.getDijkstraPath("A", "C");
		System.out.println();

		g4.getDijkstraPath("A", "F");
		System.out.println();

		g4.printGraph();
		
		
		 
		


		
		

		
	}
	
}
