package pal;

import java.util.PriorityQueue;

public class Forest {
	ForestElement first;
	
	public Forest(){
		first = null;
	}
	
	public ForestElement insert(Edge parent, Cycle cycle){
		ForestElement p = new ForestElement();
		p.edge = parent;
		parent.forestElement = p;
		p.parrent = null;
		if(cycle != null) p.chreateChildList(cycle);
		p.next = first;
		p.prev = null;
		if(first != null) first.prev = p;
		first = p;
		return first;
	}
	
	public Edge add(Edge edge){
		return edge;
	}
	
	public void deleteFormF(ForestElement x){
		if(x.prev != null && x.next != null){
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}else if(x.prev != null){
			x.prev.next = null;
		}else if(x.next != null){
			first = x.next;
		}
		if(x.parrent != null) deleteFormF(x.parrent);
	}

	public void add_as_child(ForestElement n, PriorityQueue<Edge> priorityQueue) {
		for(Edge edge:priorityQueue){
			edge.forestElement.parrent = n;
		}
	}

	public void delete_path_from(ForestElement forestElement) {
		if(forestElement.prev == null) {
			first = forestElement.next;
			first.prev = null;
		}else{
			forestElement.prev.next = forestElement.next;
		}
	}
}
