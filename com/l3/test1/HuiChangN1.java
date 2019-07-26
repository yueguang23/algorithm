package com.l3.test1;

import java.util.Scanner;

public class HuiChangN1 {
	/*
	 * 首先将所有的开始和结束时间都放到a数组中，然后同时对应b数组记录时间是开始的还是结束的
	 * 然后对a数组的数进行排序，b数组这时依然要记录对应的是开始还是结束的，所以如果a交换那么b一定也要交换
	 * 然后得到一个排好序的数组a和一个对应记录是开始还是结束的数组b
	 * 然后建立一个新数组c，遍历数组a，如果是开始时间count++，并且记录进c
	 * 如果是结束时间那么count--，记录进c，找到c数组中那个最大的就是对应的会场数count。
	 * 
	 */
	
	//最大值
	private static int Max(int c[]) {
		
		int max = c[1];
		
		for(int i = 1;i < c.length;i++) {
			if(c[i] > max) {
				max = c [i];
			}
		}
		
		return max;
	}
	
	//排序
	private static int[] Paixu(int a[],int b[]) {
		
		for(int i = 1;i < a.length;i++) {
			for(int j = 1;j < a.length-i;j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					int t = b[j];
					b[j] = b[j + 1];
					b[j + 1] = t;
				}
			}
		}
		
		return a;
	}
	//找会场数目
	private static int minHuiChang(int start[],int end[],int label[],int n) {
		
		int count = 0;
		
		int a[] = new int [2 * n + 1];//将所有的时间放到里面排序
		int b[] = new int [2 * n + 1];//看是start还是end里面的0表示start，1表示end
		
		for(int i = 1;i <= n;i++) {//将开始和结束数组赋进a
			a[i] = start[i];
			b[i] = 0;
			a[i + n] = end[i];
			b[i + n] = 1;
		}
		
		for(int i = 1;i < a.length;i++) {//输出未排序的数组a,b
			System.out.print(a[i] + " ");
			System.out.print(b[i] + " ");
		}
		
		a = Paixu(a,b);//排序
		
		System.out.println();
		for(int i = 1;i < a.length;i++) {//输出排好序的a,b
			System.out.print(a[i] + " ");
			System.out.print(b[i] + " ");
		}
		int c[] = new int [2*n+1];
		for(int i = 1;i < c.length;i++) {
			if(b[i] == 0) {
				count++;
				c[i] = count;
			}else if(b[i] == 1) {
				count--;
				c[i] = count;
			}
		}
		System.out.println();
		for(int i = 1;i < c.length;i++) {
			System.out.print(c[i] + " ");
		}
		
		count = Max(c);
		return count;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		n = input.nextInt();
		
		int start[] = new int[n + 1];
		int end[] = new int[n + 1];
		int label[] = new int[n + 1];
		
		for(int i = 1;i <= n;i++) {
			start[i] = input.nextInt();
			end[i] = input.nextInt();
			label[i] = 0;
		}
		int count = minHuiChang(start, end, label, n);
		System.out.println();
		System.out.println(count);//输出会场数
	}
}
