package ADS2week2;
	import java.util.ArrayList;
	import java.util.Scanner;

	class Edge1
	{
	@Override
		public String toString() 
		{
			return  " "+x + "-" + y + "  " + (float)weight +"0000"+"  ";
		}
	public int x; int y;
	public final double weight;
	public Edge1(int x, int y, double weight)
	{
		this.x = y;
		this.x = y;
		this.weight = weight;
	}
	public int x()
	{ 
		return x;
	}
	public int y()
	{ 
		return y; 
	}
	public double weight()
	{ 
		return  weight; 
	}

	}
	class Graph1
	{
	 private int X,count=0;;
	 private ArrayList<Edge1>[] adj;
	 public Graph1(int V)
	 {
	     this.X = X;
	     adj = (ArrayList<Edge1>[]) new ArrayList[X+1];
	    for (int x = 0; x <=X; x++)
	     adj[x] = new ArrayList<Edge1>();
	 }
	 public void addEdge(int s,int d,double weight)
	 {
		 count++;
		  Edge1 e=new Edge1(s,d,weight);
		  Edge1 e1=new Edge1(s,d,weight);
	      int x = e.x();
	      int y=e.x();
	      int p=e.y();
	      adj[x].add(e);
	      adj[p].add(e1);
	 }
	 public Iterable<Edge1> adj(int x)
	 { 
		 return adj[x]; 
	 }
	    int X()
	 {
		  return X;
	 }
	 public void display()
	 {
		 System.out.println(X-1+" vertices "+count+" edges");
		 for(int i = 0;i<X-1;i++)
		 { 
			 System.out.print(i +" :");
			 for(int j=adj[i].size()-1;j>=0;j--)
			 {
				System.out.print(adj[i].get(j));
			 }
			 System.out.println();
			 
		 }
		 
	 }
	}

	public class AmazonTransportAgent{
		public static void main(String args[])
		{
			Scanner s=new Scanner(System.in);
			int n1=s.nextInt();
			int n2=s.nextInt();
			Graph1 g=new Graph1(n1+1);
			for(int i = 0;i<n2;i++)
			{
				int n11=s.nextInt();
				int n12=s.nextInt();
				int n13=s.nextInt();
				g.addEdge(n11, n12, n13);
				
			}
			String st=s.nextLine();
			String str=s.nextLine();
			
			switch(str)
			{
			case "Graph":
				g.display();
			break;
			case "DirectedPaths":break;
			case "ViaPaths":break;
			}
		}

	}


	
	