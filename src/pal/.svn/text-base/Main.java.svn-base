package pal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader  inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);

        int countOfNodes = Integer.valueOf(br.readLine());
                
        Boolean debug = false;
        
        
        
        int[] min = new int[countOfNodes];
        List<PriorityQueue<Edge>> cycle = new ArrayList<PriorityQueue<Edge>>(countOfNodes);
        ForestElement[] lambda = new ForestElement[countOfNodes];
        BinomialHeap[] inputs = new BinomialHeap[countOfNodes];
        Edge[] enter = new Edge[countOfNodes];
        Stack<Integer> roots = new Stack<Integer>();
        int dblCou = countOfNodes;
        for(int i=0; i<countOfNodes; i++){
        	inputs[i] = new BinomialHeap(dblCou);
        	roots.push(i);
        	cycle.add(new PriorityQueue<Edge>());
        }
        
        Stack<Integer> rootsNew = new Stack<Integer>();
        while(!roots.empty()){
        	rootsNew.add(roots.pop());
        }
        
        roots = rootsNew;
        
        StringTokenizer st = null;
        int nodeFrom, nodeTo, weight;
        st = new StringTokenizer(br.readLine());
        
        nodeFrom = Integer.parseInt(st.nextToken());
        nodeTo = Integer.parseInt(st.nextToken());
        weight = Integer.parseInt(st.nextToken());
        
        while(nodeFrom != nodeTo){
        	inputs[nodeTo].insert(new Edge(nodeFrom,nodeTo,weight));
            st = new StringTokenizer(br.readLine());
            nodeFrom = Integer.parseInt(st.nextToken());
            nodeTo = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<countOfNodes; i++){
        	min[i] = i;
        }
        DisjointSet S = new DisjointSet(countOfNodes);
        DisjointSet W = new DisjointSet(countOfNodes);
        int root = -1,u,v,k,m,rep;
        Edge edge,e, max_edge;
        ForestElement n;
        
        PriorityQueue<Edge> C = new PriorityQueue<Edge>();
        Forest F = new Forest();
        
        List<Integer> X = null;
        
        while(!roots.empty()) {
        	int r = roots.pop();
        	
        	if(inputs[r].isEmpty()) {
        		if(root != -1){
        			System.out.println("-1");
        			return;
        		}else{
        			root = r;
            		continue;
        		}
        	}
        	
        	edge = inputs[r].accesMin();
        	
        	u = edge.getFrom();
        	v = edge.getTo();
        	
        	n = F.insert(edge,null);
        	
        	if(cycle.get(r).isEmpty()){
        		lambda[r] = n;
        	}else{
        		F.add_as_child(n, cycle.get(r));
        	}
        	
        	if(W.find(u) != W.find(v)){
        		W.union(W.find(u), W.find(v));
        		enter[r] = edge;
        	}else{
        		C.clear();
        		C.add(edge);
        		e = edge;
        		
        		while(true){
        			e = enter[S.find(e.getFrom())];
        			if ( e == null) break;
        			C.add(e);
        			if (S.find(e.getFrom()) == S.find(edge.getTo())) break;
        		}
        		
        		max_edge = C.element();
        		
        		X = new ArrayList<Integer>();
        		for(Edge f:C){
        			k = S.find(f.getTo());
        			X.add(k);
        			inputs[k].increase(max_edge.getWeight() - f.getWeight());
        		}
        		int i = C.size();
        		m = min[S.find(max_edge.getTo())];
        		
        		for(int j=1;j<i;j++){
        			S.union(X.get(0), X.get(j));
        		}
        		
        		rep = S.find(X.get(0));
        		
        		min[rep] = m;
        		
        		roots.push(rep);
        	
        		cycle.set(r, C);
        		if(debug){
        			System.out.println("Probiha union " + rep + " " + (i-1));
        			System.out.println(edge);
        		}
        		for(int z= 0;z<i;z++){
        			if( rep != X.get(z)) inputs[rep].mergeHeap(inputs[X.get(z)]);
        		}
        		
        		
        	}
        	
        	
        }
        
        
        if(lambda[min[root]] != null){
        	F.delete_path_from(lambda[min[root]]);
        }
        ForestElement tmp = F.first;
        System.out.println(root);
        int count = 0;
        while(tmp != null){
        	count +=tmp.edge.getWeight();
        	tmp = tmp.next;
        }
        System.out.println(count);
        tmp = F.first;
        while(tmp != null){
        	System.out.println(tmp.edge);
        	tmp = tmp.next;
        }
        System.out.println("0 0 0");
	}
}
