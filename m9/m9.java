package ADS2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class m9 {
	int matrix[] [];
	String Countries[];
	String CountryCodes[];
	m9()
	{
		this.matrix=new int[29][29];
		Countries=new String[29];
		CountryCodes=new String[29];
	}
	
	public void matrix()  throws Exception
	{
	
	File file = new File("C:\\Users\\Priyanka\\Documents\\GitHub\\ADSII26\\m9\\Tests\\distance.txt"); 
	File file1 = new File("C:\\Users\\Priyanka\\Documents\\GitHub\\ADSII26\\m9\\Tests\\ha29_name.txt");
	File file2 = new File("C:\\Users\\Priyanka\\Documents\\GitHub\\ADSII26\\m9\\Tests\\ha29_code.txt");

	BufferedReader br = new BufferedReader(new FileReader(file));
	  BufferedReader brname = new BufferedReader(new FileReader(file1));
	  BufferedReader brcode = new BufferedReader(new FileReader(file2 ));
	  String st2=brname.readLine();
	  String st1=brname.readLine();
	  String st;
	  int i=0;
	  while ((st = brname.readLine()) != null) 
	  {
		  Countries[i]=st;
		  i++;
	  }
	  String st3=brcode.readLine();
	  String st4=brcode.readLine();
	  String st5;
	  
	  i=0;
	  while ((st5 = brcode.readLine()) != null) 
	  {
		 CountryCodes[i]=st5;
		 i++;
	  }
	  String st6=br.readLine();
	  String st7=br.readLine();
	  String st8=br.readLine();
	  String st9;
	  i=0;
	  while ((st9 = br.readLine()) != null) 
	  {
		 String[] b=st9.split("  ");
		// System.out.println(st9);
		 for(int j=0;j<b.length;j++)
		 {
			 matrix[i][j]=Integer.parseInt(b[j]);
		 }
		 i++;
	  }
}

}