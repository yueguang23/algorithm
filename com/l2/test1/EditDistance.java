package com.l2.test1;

import java.util.Scanner;

public class EditDistance {
	
	private static int dis[][] = new int [100][100];
	//d[i][i]长度为i的字符串变为长度为j的编辑距离
	
	private static int MIN(int i,int j) {
		if(i > j) {
			return j;
		}else
			return i;
	}
	
	private static int editDistance(char a[],char b[]) {
		
		int lena = a.length;
		int lenb = b.length;
		//System.out.println("...." + lena + lenb);
//		for(int i = 0;i <=lena;i++) {
//			dis[i][0] = i;
//		}
//		
//		for(int j = 0;j <= lenb;j++) {
//			dis[0][j] = j;
//		}
		
		for(int i = 1;i<=lena;i++) {
			for(int j = 1;j<=lenb;j++) {
				
			int cost = (a[i-1]==b[j-1]?0:1);
			
			int delete = dis[i-1][j] + 1;
			int insert = dis[i][j-1] + 1;
			int sub = dis[i-1][j-1] + cost;
			
			dis[i][j] = MIN(delete,MIN(insert,sub));
			
			}
		}
		
//		for(int i =0;i<=lena;i++) {
//			for(int j = 0;j <=lenb;j++) {
//				System.out.print(dis[i][j]);
//			}
//			System.out.println();
//		}
		
		return dis[lena][lenb];
	}
	
	public static void main(String[] args) {
		char a[] = null;
		char b[] = null;
		
		String a1 = null;
		String b1 = null;
		
		Scanner input = new Scanner(System.in);
		
		a1 = input.nextLine();
		b1 = input.nextLine();
		
		a = a1.toCharArray();
		b = b1.toCharArray();
		
		int dis = editDistance(a, b);
		
		System.out.println(dis);
	}
}
