package pal2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader  inp = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(inp);
	
	    int countOfNodes = Integer.valueOf(br.readLine());
	            
	    
	    Node[] nodeList = new Node[countOfNodes];
	    for(int i=0;i<countOfNodes;i++){
	    	nodeList[i] = new Node(i);
	    }
	    
	    AdjacencyList list = new AdjacencyList();
	    
	    StringTokenizer st = null;
	    int nodeFrom, nodeTo, weight;
	    st = new StringTokenizer(br.readLine());
	    
	    nodeFrom = Integer.parseInt(st.nextToken());
	    nodeTo = Integer.parseInt(st.nextToken());
	    weight = Integer.parseInt(st.nextToken());
	    Node firstNode = new Node(nodeTo);
	    while(nodeFrom != nodeTo){
	    	list.addEdge(nodeList[nodeFrom], nodeList[nodeTo], weight);
	        st = new StringTokenizer(br.readLine());
	        nodeFrom = Integer.parseInt(st.nextToken());
	        nodeTo = Integer.parseInt(st.nextToken());
	        weight = Integer.parseInt(st.nextToken());
	    }
	    Edmonds edmonds = new Edmonds();
	    list = edmonds.getMinBranching(firstNode, list);
	    System.out.println(list);
	}
}
