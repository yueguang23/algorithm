package com.l3.test1;

import java.util.Scanner;

public class BAG2Wei {
	/*
	 * f[i][j][k] = ǰi����Ʒ�����Ϊj����Ϊk������ֵ
	 */
	static int f[][][] = new int [101][101][101];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//��Ʒ����
		int m = input.nextInt();//���
		int q = input.nextInt();//����
		
		int v[] = new int[101];//���
		int w[] = new int[101];//����
		int z[] = new int[101];//��ֵ
		
		for(int i = 1;i<=n;i++) {
			v[i] = input.nextInt();
			w[i] = input.nextInt();
			z[i] = input.nextInt();
		}
		
		for(int i = 1;i<= n;i++) {
			for(int j = 0;j <=m;j++) {
				for(int k = 0;k<=q;k++) {
				f[i][j][k] =f[i-1][j][k];//��j<v[i]��ʱ��Ӧ����ֵ
				if(j >= v[i]&&k >= w[i]) {
				f[i][j][k] = Math.max(f[i][j][k], f[i-1][j-v[i]][k-w[i]]+z[i]);
				}
				}
			}
		}
		
		System.out.println(f[n][m][q]);
	}
}