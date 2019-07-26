package com.l4.test1;

import java.util.Scanner;

public class ZhengShuBianHuan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		char a[] = new char[100];
		int i = 0;
		while(i<a.length) {
			if(m > n) {
				m = m/2;
				a[i] = 'g';
				i++;
			}else if(m < n) {
				m = m*3;
				a[i] = 'f';
				i++;
			}else {
				break;
			}
		}
		if(i<100) {
		for(int j=i-1;j>=0;j--) {
			System.out.print(a[j]);
			}
		}else {
			System.out.println("没有办法通过这两个函数得到");
		}
	}
	
}
