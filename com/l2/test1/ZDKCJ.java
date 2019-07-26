package com.l2.test1;

import java.util.Scanner;

//���K�˻����� 83 3-13
public class ZDKCJ {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();//���г���
		int k = input.nextInt();//�ָ����
		int[] a = new int[n + 1];//nλʮ��������
		int[][] m = new int[n + 1][n + 1];//m(h,k)��h��k��ʮ������
		int[][] dp = new int[n + 1][n + 1];//dp(i,j)ǰiλ�ֳ�j�ε����˻�
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
	    
	    for(int i=1;i<=n;i++)//ö��ǰi������   
	    {  
	        for(int j=1;j<=k;j++)//ö�ٳ˺Ÿ���  
	        {  
	            if(j==1)  
	            {  
	                dp[i][j]=m[1][i];
	                continue;    
	            }  
	            for(int l=1;l<i;l++)//ö�ٳ˺�λ��   
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
