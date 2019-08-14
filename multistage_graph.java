import java.util.*;
import java.lang.*;
import java.io.*;

class MS
{
	int multistage_graph(int[][] cost,int n,int src,int d)
	{
		int min,i,j,x;
		int[] s=new int[n+1];
		s[d]=0;
		for(i=n-1;i>=1;i--)
		{
			min=999;
			for(j=i+1;j<=n;j++)
			{
				x=cost[i][j]+s[j];
				if(min>x)
					min=x;
			}
			s[i]=min;
		}
		return s[1];
	}
	public static void main(String args[])
	{
		int n,i,j;
		Scanner in=new Scanner(System.in);
		System.out.print("Enter no. of vertices: ");
		n=in.nextInt();
		int[][] cost=new int[n+1][n+1];
		System.out.println("\nNote: \nGraph should be numbered in such a way that\nsource to destination vertices are numbered\nin increasing order starting from 1\n");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				System.out.print("Enter cost["+i+"]["+j+"] : ");
				cost[i][j]=in.nextInt();
			}
		}
		System.out.println("\nDirected Weight Matrix: ");
		for(i=1;i<=n;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(cost[i][j]==999)
					System.out.print((char)8734+" ");
				else
					System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}
		MS x=new MS();
		int sp=x.multistage_graph(cost,n,1,n);
		System.out.println("Shortest path from 1 to "+n+" is "+sp);
	}
}