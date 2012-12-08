package pal;

import java.util.ArrayList;
import java.util.List;

public class BinomialElement {
	Edge edge;
	BinomialElement parent;
	int increase;
	List<BinomialElement> children;
	int order;
	BinomialElement heapVirtual;
	
	public BinomialElement(){
		increase = 0;
	};
	
	public BinomialElement(Edge edge, BinomialElement virtual){
		children = new ArrayList<BinomialElement>();
		this.edge = edge;
		this.increase = 0;
		this.order = 0;
		this.heapVirtual = virtual;
	}

	public int getIncrease(){
		if(parent == null){
			return increase+heapVirtual.increase;
		}else{
			return increase+parent.getIncrease();
		}
	}
	
	public int getValue(){
		int value = edge.getWeight();
		value +=increase;
		if(parent != null) value +=parent.getIncrease();
		return value;
	}
}
