package pal2;

public class Node {

	   int name;
	   boolean visited = false;   // used for Kosaraju's algorithm and Edmonds's algorithm
	   int lowlink = -1;          // used for Tarjan's algorithm
	   int index = -1;            // used for Tarjan's algorithm
	   Node(int n){
	       name = n;
	   }

	   public int compareTo(Node n){
	       if(n == this)
	           return 0;
	       return -1;
	   }
}
