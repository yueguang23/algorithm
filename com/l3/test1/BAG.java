package com.l3.test1;

import java.util.Scanner;

public class BAG {
	/*
	 * f[i][j] = 前i个物品的体积为j的最大价值
	 */
	static int f[][] = new int [1010][1010];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//物品个数
		int m = input.nextInt();//体积
		
		int v[] = new int[1010];//体积
		int w[] = new int[1010];
		
		for(int i = 1;i<=n;i++) {
			v[i] = input.nextInt();
			w[i] = input.nextInt();
		}
		
		for(int i = 1;i<= n;i++) {
			for(int j = 0;j <=m;j++) {
				f[i][j] =f[i-1][j];//当j<v[i]的时候罂告有值
				if(j >= v[i]) {
				f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]]+w[i]);
				}
			}
		}
		
		System.out.println(f[n][m]);
	}
}
