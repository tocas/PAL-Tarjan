package pal;

import java.util.ArrayList;
import java.util.List;

public class Set {
	private int representand;
	private List<Integer> set;
	
	public Set(int repre){
		this.representand = repre;
		set = new ArrayList<Integer>();
		set.add(repre);
	}
	
	public int getRepresentand() {
		return representand;
	}
	public void setRepresentand(int representand) {
		this.representand = representand;
	}
	public List<Integer> getSet() {
		return set;
	}
	public void setSet(List<Integer> set) {
		this.set = set;
	}

	public boolean has(int id) {
		for(Integer item:set){
			if(item == id) return true;
		}
		return false;
	}
}
