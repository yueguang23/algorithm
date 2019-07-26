package com.l2.test1;

import java.util.Scanner;

//最大K乘积问题 83 3-13
public class ZDKCJ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();//序列长度
		int k = input.nextInt();//分割段数
		int[] a = new int[n + 1];//n位十进制整数
		int[][] m = new int[n + 1][n + 1];//m(h,k)从h到k的十进制数
		int[][] dp = new int[n + 1][n + 1];//dp(i,j)前i位分成j段的最大乘积
		for(int i = 1; i <= n; i++) {
			a[i] = input.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			m[i][i]=a[i];
		}
		for(int i=1;i<=n;i++)  
	    {  
	        for(int j=i+1;j<=n;j++)  
	        {  
	            m[i][j]=m[i][j-1]*10+m[j][j];  
	        }  
	    } 
		
		for(int i=1;i<=n;i++)  
	    {  
	        for(int j=i;j<=n;j++)  
	        {  
	            System.out.print(m[i][j] + "  ");
	        }
	        System.out.println();
	    } 
	    
	    for(int i=1;i<=n;i++)//枚举前i个数字   
	    {  
	        for(int j=1;j<=k;j++)//枚举乘号个数  
	        {  
	            if(j==1)  
	            {  
	                dp[i][j]=m[1][i];
	                continue;    
	            }  
	            for(int l=1;l<i;l++)//枚举乘号位置   
	            {  
	                dp[i][j]=Math.max(dp[i][j],dp[l][j-1]*m[l+1][i]);  
	            }  
	              
	        }  
	    } 
	    
	    for(int i = 1; i <= n; i++) {
	    	for(int j = 0; j <= n; j++) {
	    		System.out.print(dp[i][j] + "   ");
	    	}
	    	System.out.println();
	    }
	    
	    System.out.println(dp[n][k]);
		
	}

}
