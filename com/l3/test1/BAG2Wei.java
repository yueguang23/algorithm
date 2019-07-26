package com.l3.test1;

import java.util.Scanner;

public class BAG2Wei {
	/*
	 * f[i][j][k] = 前i个物品的体积为j重量为k的最大价值
	 */
	static int f[][][] = new int [101][101][101];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//物品个数
		int m = input.nextInt();//体积
		int q = input.nextInt();//重量
		
		int v[] = new int[101];//体积
		int w[] = new int[101];//重量
		int z[] = new int[101];//价值
		
		for(int i = 1;i<=n;i++) {
			v[i] = input.nextInt();
			w[i] = input.nextInt();
			z[i] = input.nextInt();
		}
		
		for(int i = 1;i<= n;i++) {
			for(int j = 0;j <=m;j++) {
				for(int k = 0;k<=q;k++) {
				f[i][j][k] =f[i-1][j][k];//当j<v[i]的时候应该有值
				if(j >= v[i]&&k >= w[i]) {
				f[i][j][k] = Math.max(f[i][j][k], f[i-1][j-v[i]][k-w[i]]+z[i]);
				}
				}
			}
		}
		
		System.out.println(f[n][m][q]);
	}
}