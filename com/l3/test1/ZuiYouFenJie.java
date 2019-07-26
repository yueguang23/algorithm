package com.l3.test1;

import java.util.Scanner;

public class ZuiYouFenJie {
	/*
	 * 先分解成从2开始的连续自然数的数组，然后再将剩下的数字给分解出来的数字从大到小
	 * 加1，这样就会是连续，保证乘积最大
	 * 例如：10 分解为2,3,4
	 * 剩下1，那么1加到4上，即分解为2,3,5
	 * 乘积最大为2*3*5=30
	 * 
	 */
	public static int fenjie(int n) {
		
		int a[] = new int[100];
		int i = 2;//从开始的连续的自然数
		int sum = 0;//记录分解后的数字相加是否已经大于或者等于n
		int count = 0;//记录分解后的数字的个数
		
		//分解数字（最初）
		while(sum <= n) {
			sum = sum + i;
			a[i-2] = i;
			i = i + 1;
			count++;
		}
		count--;
		i=i-1;
		a[i-2] = 0;
		sum = sum - i;
		
		
		
		int b = n-sum;//看最后剩下的数字是多少
//		for(int j = 0;j<count;j++) {
//			System.out.println(a[j]);
//		}
		while(b>0) {
			if(b<count) {//如果最后剩下的数字比分解的个数小，那么就按照这个个数来加
				for(int j = count-1;j>count-b-1;j--) {
					a[j] = a[j] +1;
				}
			}else {//如果剩下的个数比分解的个数多，那么先按照分解的个数加，然后再减去个数，看是否还大于
				for(int j = count-1;j>=0;j--) {
					a[j] = a[j] +1;
				}
			}
			b = b-count;
		}
		
		for(int j = 0;j<count;j++) {
			System.out.println(a[j]);
		}
//		
		int c = 1;//乘积
		for(int j = 0;j<count;j++) {
			c = c * a[j];
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int c = fenjie(n);
		System.out.println(c);
	}
}
