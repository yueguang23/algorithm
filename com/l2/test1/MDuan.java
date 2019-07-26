package com.l2.test1;

import java.util.Scanner;

public class MDuan {
		
	public static int a[] = new int[100];
	public static int dp[][] = new int[1000][1000];
	
	public static void main(String[] args) {
		int n,m,maxvalue = 0;
		
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		m = input.nextInt();
		
		for(int i = 1;i <= n;i++) {
			a[i] = input.nextInt();
		}
		
		for(int i = 1;i <=n;i++) {
			dp[i][1] = dp[i-1][1] + a[i];
		}
		
		for(int i =1;i<=n;i++) {
			for(int j=2;j<=m;j++) {
				int minvalue = 99999;
				for(int k = 1;k <i;k++) {
					int temp = MAX(dp[i][1]-dp[k][1],dp[k][j-1]);
					if(temp < minvalue) {
						minvalue = temp;
					}
				}
				dp[i][j] = minvalue;
			}
			
		}
		
		System.out.println(dp[n][m]);
	}

	
	public static int MAX(int a,int b) {
		
		if(a>b) {
			return a;
		} else {
			return b;
		}
		
		
	}
}
