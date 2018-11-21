
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 


public class Graph 
{ 
	private int V; 
	private LinkedList<Integer> adj[]; 
	int time = 0; 
	static final int NIL = -1; 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w);  
		adj[w].add(v);
	} 

	void AP(int u, boolean visited[], int disc[], 
				int low[], int parent[], boolean ap[]) 
	{ 
		int children = 0; 
		visited[u] = true; 
		disc[u] = low[u] = ++time; 
		Iterator<Integer> i = adj[u].iterator(); 
		while (i.hasNext()) 
		{ 
			int v = i.next(); 
			if (!visited[v]) 
			{ 
				children++; 
				parent[v] = u; 
				AP(v, visited, disc, low, parent, ap); 
				low[u] = Math.min(low[u], low[v]); 
				if (parent[u] == NIL && children > 1) 
					ap[u] = true; 
				if (parent[u] != NIL && low[v] >= disc[u]) 
					ap[u] = true; 
			} 
			else if (v != parent[u]) 
				low[u] = Math.min(low[u], disc[v]); 
		} 
	} 
	void AP() 
	{ 
		boolean visited[] = new boolean[V]; 
		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 
		boolean ap[] = new boolean[V]; 
		for (int i = 0; i < V; i++) 
		{ 
			parent[i] = NIL; 
			visited[i] = false; 
			ap[i] = false; 
		} 
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				AP(i, visited, disc, low, parent, ap); 
		int count=0;
		for (int i = 0; i < V; i++) {
			if (ap[i] == true) {
				count++;
			//	System.out.print((i+1)+" ");
				}
				
		}
		System.out.println(count);
	
	} 
	public static void main(String args[]) 
	{ 
		System.out.println("Number of Island submergered when its disconnenect "); 
		Graph g1 = new Graph(4); 
		g1.addEdge(0, 1); 
		g1.addEdge(1, 2); 
		g1.addEdge(2, 0);
		g1.addEdge(2, 3);
		g1.AP(); 
		
	} 
} 