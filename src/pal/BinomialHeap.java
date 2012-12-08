package pal;

public class BinomialHeap {
	BinomialElement[] nodes;
	BinomialElement min;
	BinomialElement virtual;
	
	public BinomialHeap(int capacity){
		nodes = new BinomialElement[capacity];
		min = null;
		virtual = new BinomialElement();
	}
	
	public void increase(int increase){
		virtual.increase +=increase;
	}
	
	public void insert(Edge edge){
		BinomialElement element = new BinomialElement(edge,virtual);
		if(nodes[0] != null){
			merge(element,nodes[0]);
		}else{
			nodes[0]=element;
		}
		
		if(min == null){
			min = element;
		}else{
			min = min.getValue() < element.getValue()? min:element;
		}
		
	}
	
	public void mergeHeap(BinomialHeap heap){
		BinomialElement carry = null;
		for(int i=0;i<heap.nodes.length;i++){
			if(nodes[i] == null){
				if(heap.nodes[i] == null){
					nodes[i] = carry;
					carry = null;
				}else{
					if(carry != null){
						carry = mergeTree(carry, heap.nodes[i]);
					}else{
						nodes[i] = heap.nodes[i];
					}
				}
			}else{
				if( heap.nodes[i] == null){
					if(carry != null){
						carry = mergeTree(nodes[i], carry);
						nodes[i]=null;
					}
				}else{
					if(carry == null){
						carry = mergeTree(nodes[i], heap.nodes[i]);
						nodes[i] = null;
					}else{
						carry = mergeTree(carry, heap.nodes[i]);
					}
				}
			}
		}
		if(carry != null) throw new InternalError("Pole preteklo");
		
		
		if(this.min == null) this.min = heap.min;
		else if(this.min != null && heap.min != null && (this.min.getValue() > heap.min.getValue())) this.min = heap.min;
	}

	private void merge(BinomialElement a, BinomialElement b) {
		if(a.order != b.order) throw new IllegalArgumentException("Mergovani dvou ruzne velkych stromu!");
		int tmpOrder = a.order;
		nodes[tmpOrder] =  null;
		BinomialElement newRoot = mergeTree(a,b);
		if( nodes[tmpOrder + 1] == null){
			nodes[tmpOrder + 1] = newRoot;
		}else{
			merge(newRoot,nodes[tmpOrder + 1]);
		}
	}

	private BinomialElement mergeTree(BinomialElement a, BinomialElement b) {
		BinomialElement newRoot = null;
		if(a.getValue() < b.getValue()){
			b.parent = a;
			b.increase = b.heapVirtual.increase - a.heapVirtual.increase;
			a.children.add(b);
			a.order++;
			newRoot = a;
		}else{
			a.parent = b;
			a.increase = a.heapVirtual.increase - b.heapVirtual.increase;
			b.children.add(a);
			b.order++;
			newRoot = b;
		}
		return newRoot;
	}

	public boolean isEmpty() {
		if(min != null) return false;
		else return true;
	}

	public Edge accesMin() {
		if(min == null) return null;
		Edge tmp = min.edge;
		nodes[min.order] = null;
		for(BinomialElement child: min.children){
			child.parent = null;
			if(nodes[child.order] != null) merge(child, nodes[child.order]);
			else nodes[child.order] = child;
		}
		
		min.children.clear();
		
		int minValue = Integer.MAX_VALUE;
		BinomialElement minElement = null;
		for(int i=0;i<nodes.length;i++){
			if(nodes[i] != null){
				if(minValue == Integer.MAX_VALUE){
					minValue = nodes[i].getValue();
					minElement = nodes[i];
				}else if(minValue > nodes[i].getValue()){
					minValue = nodes[i].getValue();
					minElement = nodes[i];
				}
			}
		}
		min = minElement;
		return tmp;
	}
	

}
