package pal;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private int d;
	private List<Edge> heap;
	
	//int[0] - weight
	//int[1] - id of node
	
	public Heap(int d){
		this.d = d;
		this.heap = new ArrayList<Edge>();
	}
	public Edge accessMin(){
		Edge e = heap.get(0);
		deleteMin();
		return e;
	}
	
	public boolean contains(Edge edge){
		return heap.contains(edge);
	}
	
	public List<Edge> getHeap(){
		return heap;
	}
	public void insert(Edge edge){
		heap.add(edge);
        siftUp(heap.size() - 1);
	}
	private void siftUp(int nodeIndex) {
		int parentIndex;
		Edge tmp;
        if (nodeIndex != 0) {
              parentIndex = getParentIndex(nodeIndex);
              if (heap.get(parentIndex).getWeight() > heap.get(nodeIndex).getWeight()) {
                    tmp = heap.get(parentIndex);
                    heap.set(parentIndex,heap.get(nodeIndex));
                    heap.set(nodeIndex,tmp);
                    siftUp(parentIndex);
              }
        }
	}
	private int getParentIndex(int nodeIndex) {
		return Integer.valueOf(nodeIndex / d);
	}
	public void deleteMin(){
		if(heap.size() > 0){
			heap.set(0,heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			if(heap.size() > 0) siftDown(0);
		}
	}
	
	
	private void siftDown(int nodeIndex) {
		int[] min = minFromBranch(nodeIndex);
		if(min[0] < heap.get(nodeIndex).getWeight()){
			Edge tmp = heap.get(min[1]);
			heap.set(min[1], heap.get(nodeIndex));
			heap.set(nodeIndex,tmp);
			siftDown(min[1]);
		}
	}
	private int[] minFromBranch(int id) {
		int min[] = new int[]{Integer.MAX_VALUE,0};
		for(int i=1;i < d+1;i++){
			if((d*id) + i >= heap.size()) break;
			if(min[0] > heap.get((d*id) + i).getWeight()) {
				min[0] =  heap.get((d*id) + i).getWeight();
				min[1] = (d*id) + i;
			}
		}
		return min;
	}
	public int heapSize(){
		return heap.size();
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(Edge i:heap){
			sb.append("Edge from:"+i.getFrom()+ "weight:"+i.getWeight() + "\n");
		}
		return sb.toString();
	}
}
