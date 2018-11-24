import java.util.Scanner;
class LeastCommonSequence
{
	int leastCommonSequence( char[] X, char[] Y, int m, int n ) 
	  { 
	    if (m == 0 || n == 0) 
	      return 0; 
	    if (X[m-1] == Y[n-1]) 
	      return 1 + leastCommonSequence(X, Y, m-1, n-1); 
	    else
	      return max(leastCommonSequence(X, Y, m, n-1), leastCommonSequence(X, Y, m-1, n)); 
	  } 
	  
	  /* Utility function to get max of 2 integers */
	  int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 
	public int maximum(int a,int b)
	{
		if(a>b)
		{
			return a;
		}
		else 
			return b;
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string and subStrings:");
		String s = scan.nextLine();
		String sub = scan.next();
		char x[]=s.toCharArray();
		char y[]=sub.toCharArray();
		int s_of_s=x.length;
		int s_of_sub=y.length;
		LeastCommonSequence lcs = new LeastCommonSequence();
		System.out.println("The length of the sub String is:"+lcs.leastCommonSequence(x, y, s_of_s, s_of_sub));
		
	}
}


