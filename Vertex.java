package Homework5;

import java.util.ArrayList;

public class Vertex implements IVertex {
	
	//instance variables 
	public String value;
	public ArrayList<Edge> neighbors;
	
	//additional instance variables 
	public int x;
	public int y;
	public double totalDistance;
	public boolean hasVisited;
	public Vertex comingFrom;

	//constructors 
	public Vertex(String value) {
		this.value = value;
		neighbors = new ArrayList<Edge>();
		this.x = 0;
		this.y = 0;
		this.totalDistance = 0;
		this.hasVisited = false;
	}
	
	public Vertex(String value, int x, int y) {
		this.value = value;
		neighbors = new ArrayList<Edge>();
		this.x = x;
		this.y = y;
		this.totalDistance = 0;
		this.hasVisited = false;
		
	}
	
	@Override
	public void addEdge(Edge e) {
		neighbors.add(e);
	}

	public String toString() {
		return value;
		
	}
	

}
