package pal;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
	List<Node> nodes;
	
	public DisjointSet(int nodeCount){
		nodes = new ArrayList<Node>(nodeCount);
		for(int i=0;i<nodeCount;i++){
			nodes.add(new Node(i));
		}
	}
	
	public int union (int a, int b){
		Node nodeA = nodes.get(find(a));
		Node nodeB = nodes.get(find(b));
		nodeB.setParent(nodeA);
		return nodeA.getId();
	}
	
	public int find(int a) {
		int jumps = 0;
		Node n = nodes.get(a);
		while(n.getParent() != null){
			n = n.getParent();
			jumps++;
		}
		if(jumps > 1) repair(a,n.getId());
		return n.getId();
	}

	private void repair(int a, int id) {
		Node n = nodes.get(a);
		while(n.getId() != id){
			Node tmp = n.getParent();
			n.setParent(nodes.get(id));
			n = tmp;
		}
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < nodes.size(); i++) {
			builder.append(find(i) + " ");
		}
		return builder.toString();
	}
}
