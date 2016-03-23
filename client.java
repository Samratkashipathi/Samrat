import java.util.*;
class client
{
public static void main(String args[]) throws Exception
	{
	maze m=new maze();
	m.creatmaze();
	m.travel();
  int wish=0;
  Scanner in=new Scanner(System.in);
  System.out.println("Do you want to travel manually");
  wish=in.nextInt();
	while(wish==1)
  {
    m.travelmanually();
     System.out.println("Do you want to travel manually again \n 0:No 1:Yes ");
  wish=in.nextInt();
    }
	}
}