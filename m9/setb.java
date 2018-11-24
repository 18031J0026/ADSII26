package ADS2;

import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
class setb
{ 
    static final int V=29; 
    static int minDistance(int dist[], Boolean sptSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    static void printSolution(m9 d,int dist[], int n,int sr) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(d.Countries[sr]+"   "+d.Countries[i]+" = "+dist[i]); 
    } 
    static void dijkstra(m9 a,int graph[][], int src) 
    { 
        int dist[] = new int[V];  
  
        Boolean sptSet[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        dist[src] = 0; 
        for (int count = 0; count < V-1; count++) 
        { 
            int u = minDistance(dist, sptSet); 
            sptSet[u] = true; 
            for (int v = 0; v < V; v++) 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        printSolution(a,dist, V,src); 
    }
    public static void main(String[] args)
    {
    	m9 adj=new m9();
    	try {
			adj.matrix();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int src=0;
    	dijkstra(adj,adj.matrix,src);
    	
    }
    }

