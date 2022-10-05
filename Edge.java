package Homework5;

public class Edge implements IEdge {
	
	//instance variables 
	public double weight; //nonegative 
	public Vertex source;
	public Vertex dest;
	
	//constructor 
	public Edge(double weight, Vertex source, Vertex dest) {
		this.weight = weight;
		this.source = source;
		this.dest = dest;
	}
	
	//toString() method 
	public String toString() {
		return "(" + source + " - " + dest + ")";
	}
	
	
	
}
