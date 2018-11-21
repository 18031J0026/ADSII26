
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Graph
{
	static int count=0;
	int V;
	int E;
	String s[];
	LinkedList<Integer> adj[];
	Graph(int v,int e)
	{
		this.V=v;
		this.E=e;
		adj=new LinkedList[v];
		for(int i=1;i<v;i++) {
			adj[i]=new LinkedList<Integer>();
		}
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public boolean hasNext()
	{
		return false;
		
	}
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	void dfs(int i,int c)
	{
		boolean vis[]=new boolean[V];
		countPath(i,vis,c);
	}
	void countPath(int i,boolean[] visited,int count1)
	{
		visited[i]=true;
		Iterator<Integer> j=adj[i].listIterator();
		while(j.hasNext())
		{
			int n=j.next();
			if(!visited[n])
			{
				countPath(n,visited,count1);
				count=count+1;
			}
			
		}
		if(count==count1)
			System.out.println(count+"");
	}
}
public class Socialnetworking {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String[] s2=s.split(" ");
		Graph g = new Graph(Integer.parseInt(s2[0])+1,Integer.parseInt(s2[1])+1);
		for(int i=1;i<=Integer.parseInt(s2[1]);i++)
		{
			String s1=scan.nextLine();
			String str1[]=s1.split(" ");
			g.addEdge(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]));
			g.dfs(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]));
		}
		//queries
		int n;
		String s3=scan.nextLine();
		n=Integer.parseInt(s3);
		for(int i=0;i<n;i++)
		{
			String s4=scan.nextLine();
			String[] str3=s4.split("");
			g.dfs(Integer.parseInt(str3[0]),Integer.parseInt(str3[1]));
		}
		
	}

}

