import javafx.util.Pair;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraPQ 
{
    static class Edge 
    {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) 
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph 
    {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        Graph(int vertices) 
        {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            
            for (int i=0;i<vertices;i++) 
            {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEdge(int source, int destination, int weight)
        {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);

            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge); 
       }

        public void dijkstra_GetMinDistances(int sourceVertex)
        {

            boolean[] SPT = new boolean[vertices];
           int distance[] = new int[vertices];
            for(int i=0;i<vertices;i++) 
            {
                distance[i] = Integer.MAX_VALUE;
            }
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vertices, new Comparator<Pair<Integer, Integer>>() 
            {
                 @Override
                public int compare(Pair<Integer, Integer> p1,Pair<Integer,Integer> p2) 
                 {
                    int key1 = p1.getKey();
                    int key2 = p2.getKey();
                    return key1-key2;
                }
            });
            
            distance[0]=0;
            Pair<Integer,Integer> p0 = new Pair<>(distance[0],0);
            pq.offer(p0);
           
            while(!pq.isEmpty())
            {
                Pair<Integer,Integer> extractedPair = pq.poll();
                int extractedVertex = extractedPair.getValue();
                if(SPT[extractedVertex]==false) 
                {
                    SPT[extractedVertex] = true;
                  LinkedList<Edge> list = adjacencylist[extractedVertex];
                    for(int i= 0;i<list.size();i++)
                    {
                        Edge edge=list.get(i);
                        int destination = edge.destination;
                        if(SPT[destination] == false) 
                        {
                            
                            int newKey =  distance[extractedVertex] + edge.weight ;
                            int currentKey = distance[destination];
                            if(currentKey>newKey)
                            {
                                Pair<Integer, Integer> p = new Pair<>(newKey, destination);
                                pq.offer(p);
                                distance[destination] = newKey;
                            }
                        }
                    }
                }
            }
           
            printDijkstra(distance, sourceVertex);
        }

        public void printDijkstra(int[] distance, int sourceVertex)
        {
            System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
            for (int i = 0; i <vertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + distance[i]);
            }
        }

        public static void main(String[] args) 
        {
            int vertices = 9;
            Graph graph = new Graph(vertices);
            graph.addEdge(0, 1, 4 );
            graph.addEdge(1, 2, 8 );
            graph.addEdge(2, 3, 7 );
            graph.addEdge(3, 4, 9 );
            graph.addEdge(4, 5, 10);
            graph.addEdge(5, 6, 2 );
            graph.addEdge(6, 7, 1 );
            graph.addEdge(5, 3, 14);
            graph.addEdge(5, 2, 4 );
            graph.addEdge(6, 8, 6 );
            graph.addEdge(8, 2, 2 );
            graph.addEdge(7, 8, 7 );
            graph.addEdge(1, 7, 11);
            graph.addEdge(0, 7, 8 );

            graph.dijkstra_GetMinDistances(0);
        }
    }
}