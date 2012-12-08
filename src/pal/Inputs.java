package pal;


public class Inputs {
	private Heap edges;
	public int increase = 0;
	
	public Inputs(){
		edges = new Heap(4);
	}
	public Heap getEdges(){
		return edges;
	}
	public void increase(int i) {
		increase = i;
	}
	public void union(Inputs inputs) {
		int ic = inputs.increase;
		for(Edge edge:inputs.getEdges().getHeap()){
			if(!edges.contains(edge)){
				edge.setWeight(edge.getWeight()+ic);
				edges.insert(edge);
			}
		}
	}
}
