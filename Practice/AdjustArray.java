import java.util.*;
import java.lang.*;
import java.io.*;

class AdjustArray {
    public static int func(int[] arr, int n, int i, int prev, int target, int[][] dp)
    {
        if(i==n)
        {
            return 0;
        }
        if(dp[i][prev]!=-1)
        {
       //     return dp[i][prev];
        }
        
        int min=Integer.MAX_VALUE;
        for(int j=prev-target;j<=prev+target;j++)
        {
            if(j<=0)
            {
                continue;
            }
            if(j>100)
            {
                break;
            }
            
            int temp=Math.abs(arr[i]-j);
            
            int small=func(arr,n,i+1,j,target,dp);
            if(small!=Integer.MAX_VALUE && small+temp<min)
            {
                min=small+temp;
            }
        }
        
        return dp[i][prev]=min;
    }
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int j=0;j<t;j++)
		{
		    int n=sc.nextInt();
		    int target=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    int min=Integer.MAX_VALUE;
		    int dp[][]=new int[n][101];
		    for(int i=0;i<n;i++)
		    {
		        for(int k=1;k<=100;k++)
		        {
		            dp[i][k]=-1;
		        }
		    }
		   
		    for(int i=1;i<=100;i++)
		    {
		        int temp=Math.abs(arr[0]-i);
		        int output=func(arr,n,1,i,target,dp);
		        if(output!=Integer.MAX_VALUE && output+temp<min)
		        {
		            min=output;
		        }
		    }

		    System.out.println(target % 2 != 0 ? min + 1 : min);
		}
	}
}