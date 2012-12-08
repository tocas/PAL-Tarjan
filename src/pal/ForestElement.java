package pal;

public class ForestElement {
	public Edge edge;
	public ForestElement next;
	public ForestElement prev;
	public ForestElement nextPrint;
	public ForestElement parrent;
	
	public void chreateChildList(Cycle cycle){
		CycleElement c = cycle.first();
		while(c != null){
			c.edge.forestElement.parrent = this;
			c = c.next;
		}
	}
}
