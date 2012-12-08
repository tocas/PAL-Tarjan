package pal;

public class Edge  implements Comparable<Edge>{
	private int from;
	private int to;
	private int weight;
	public ForestElement forestElement;
	
	
	public Edge(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int compareTo(Edge o) {
		return o.weight - this.weight;
	}

	public String toString(){
		return from + " " + to + " " + weight;
	}
	
}
