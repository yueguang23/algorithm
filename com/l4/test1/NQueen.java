package com.l4.test1;

import java.util.Scanner;

public class NQueen {
	
	private static int n;//n���ʺ�
	private static int x[] = new int [100];//���еı�
	private static int sum ;
	private static int queen[][] = new int[100][100];
	//����
	private static void swap(int a[],int x,int y) {
		int temp;
		temp = a[x] ;
		a[x] = a[y];
		a[y] = temp;
	}
	
	//�ж��Ƿ�Ϻ�Ҫ��
	private static boolean legal(int t) {
		boolean flag = true;
		for(int i = 1;i < t;i++) {
			if(Math.abs(i-t)==Math.abs(x[i]-x[t])) {
				flag = false;
			}
		}
		return flag;
	}
	
	public static void BackTrack(int t) {
		if(t > n) {
			sum ++;
			for(int i = 1;i<=n;i++) {
				queen[i][x[i]] = 1;
			}
			for(int i =1;i<=n;i++) {
				for(int j = 1;j<=n;j++) {
					System.out.print(queen[i][j] + " ");
				}
				System.out.println();
				
			}
			for(int i = 1;i<=n;i++) {
				queen[i][x[i]] = 0;
			}
			System.out.println();
		}else {
			for(int i = t;i<=n;i++) {
				swap(x,t,i);
				if(legal(t)||t==1) {
					BackTrack(t+1);
				}
				swap(x,t,i);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		for(int i= 1;i<=n;i++) {
			x[i] = i;
		}
//		for(int i =1;i<=n;i++) {
//			System.out.println(x[i]);
//		}
		BackTrack(1);
		System.out.println(sum);
	}

}
