package com.l3.test1;

import java.util.Scanner;

public class BAG {
	/*
	 * f[i][j] = ǰi����Ʒ�����Ϊj������ֵ
	 */
	static int f[][] = new int [1010][1010];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();//��Ʒ����
		int m = input.nextInt();//���
		
		int v[] = new int[1010];//���
		int w[] = new int[1010];
		
		for(int i = 1;i<=n;i++) {
			v[i] = input.nextInt();
			w[i] = input.nextInt();
		}
		
		for(int i = 1;i<= n;i++) {
			for(int j = 0;j <=m;j++) {
				f[i][j] =f[i-1][j];//��j<v[i]��ʱ������ֵ
				if(j >= v[i]) {
				f[i][j] = Math.max(f[i][j], f[i-1][j-v[i]]+w[i]);
				}
			}
		}
		
		System.out.println(f[n][m]);
	}
}
