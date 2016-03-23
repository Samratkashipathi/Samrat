import java.io.*;
//import java.lang.String.*;
import java.util.Arrays;
import java.util.*;
class maze
{
private int maze[][];
private int trav[];
ArrayList<Integer> creat;
ArrayList<Integer> arrow;
ArrayList<Integer> flash;
PrintWriter fout=null;

public void creatmaze() throws Exception
	{
		Scanner sn =new Scanner(System.in);	
		creat=new ArrayList<Integer>();
		BufferedReader fin=null;
		
		
		
		fin =new BufferedReader(new FileReader("CreateMaze.txt"));
		String s=fin.readLine();
		while(s!=null)
		{ 
		   String[]z=s.split(" ");
		   int len=z.length;
		   s=fin.readLine();
		   for(int i=0;i<len;i++)
			{ 
			   creat.add(Integer.parseInt(z[i]));   
			}
		}
		
			int rooms=(creat.size())/5;
			maze=new int[rooms+1][4];
			int k=0,t=0;
			for(int i=0;i<creat.size();i++)
			{
				if(i%5==0)
				{
					k++;
					t=0;
				}
				else
				{
					int w=creat.get(i);
					maze[k][t++]=w;
				}
				
			}
		
	
		
	}
	
	
	
	
	public void travel()
	{
		Scanner sn =new Scanner(System.in);	
		arrow=new ArrayList<Integer>();
		BufferedReader fin=null;
		
		try
		{
		fin =new BufferedReader(new FileReader("TraverseMaze.txt"));
		String s=fin.readLine();
		int size=0;
		while(s!=null)
		{ 
		   String[]z=s.split(" ");
		   int len=z.length;
		   s=fin.readLine();
		   for(int i=0;i<len;i++)
			{ 
			   arrow.add(Integer.parseInt(z[i]));   
			}
			
		     arrow.add(-1);
			 size++;			 
		}
		
		
				
				int k=0;
				trav=new int[size];
				int q=arrow.size();
				int current=arrow.get(0);
				
				
				
				for(int j=1;j<q;j++)
				{
					
					  if(arrow.get(j)>=0)
					   {
							int y=maze[current][arrow.get(j)];
							if(y>0)
							{
							current=y;
							}
					   }	
						
							
							if(arrow.get(j)==-1)
							{
							//System.out.println(current);
							//System.out.println("got");
							trav[k++]=current;
							if(k!=size)
							{
							current=arrow.get(++j);
							}
							else{j++;}
							}
					
					
				}
		destination();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	
		
	}
	
	public void destination() throws Exception 
	{
		fout=new PrintWriter(new FileWriter("result.txt"));
		for(int i=0;i<trav.length;i++)
		{
			System.out.println("destination "+(i+1)+":"+trav[i]);
			fout.println(trav[i]);
		}
		
		fout.close();
		
		
	}
  
  
  public void travelmanually()
  {
  ArrayList<Integer> flash=new ArrayList<Integer>();
  int i=0,n=0;
  int wish=1;
  int size;
  int a=1;
  Scanner sn=new Scanner(System.in);
      while(wish!=0)
      {
        if(i==0)
        {
          System.out.println("Enter the room no");
          n=sn.nextInt();
          flash.add(n);
          i++;
          }
          System.out.println("0:East");
          System.out.println("1:West");
          System.out.println("2:North");
          System.out.println("3:South");
          System.out.println("In Which direction do you want to go next");
           n=sn.nextInt();
           flash.add(n);
           System.out.println("0:exit,1:continue");
           wish=sn.nextInt();
      }
        size=flash.size();
        int k=0;
				trav=new int[size];
				//int q=arrow.size();
				int current=flash.get(0);
				
				
				
				for(int j=1;j<size;j++)
				{
					
					  
							int y=maze[current][flash.get(j)];
							if(y>0)
							{
							current=y;
							}
					   
				
         }
          System.out.println("Destination:"+current);
	
	
}
}