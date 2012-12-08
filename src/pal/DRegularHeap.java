package pal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DRegularHeap {
	private int d;
	private List<Integer> heap;
	
	public DRegularHeap(int d){
		this.d = d;
		this.heap = new ArrayList<Integer>();
	}
	public DRegularHeap(int d, Integer[] array ){
		this.d = d;
		this.heap = new ArrayList<Integer>(Arrays.asList(array));
		buildHeap();
	}
	private void buildHeap() {
		System.out.println("Build"+heap.size());
		for( int i=(heap.size()/d); i>0;--i){
			percolateDown(i-1);
		}
	}
	private void percolateDown(int nodeIndex) {
		int min[] = minFromBranch(nodeIndex);
		if(min[0] < heap.get(nodeIndex)){
			heap.set(min[1], heap.get(nodeIndex));
			heap.set(nodeIndex, min[0]);
			percolateDown(min[1]);
		}
	}
	public int accessMin(){
		return heap.get(0);
	}
	public void insert(int value){
		heap.add(value);
        siftUp(heap.size() - 1);
	}
	private void siftUp(int nodeIndex) {
		int parentIndex, tmp;
        if (nodeIndex != 0) {
              parentIndex = getParentIndex(nodeIndex);
              if (heap.get(parentIndex) > heap.get(nodeIndex)) {
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
		int min[] = minFromBranch(nodeIndex);
		if(min[0] < heap.get(nodeIndex)){
			heap.set(min[1], heap.get(nodeIndex));
			heap.set(nodeIndex, min[0]);
			siftDown(min[1]);
		}
	}
	private int[] minFromBranch(int id) {
		int min[] = new int[]{Integer.MAX_VALUE,0};
		for(int i=1;i < d+1;i++){
			if((d*id) + i >= heap.size()) break;
			if(min[0] > heap.get((d*id) + i)) {
				min[0] =  heap.get((d*id) + i);
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
		for(Integer i:heap){
			sb.append(i+"\n");
		}
		return sb.toString();
	}
}
