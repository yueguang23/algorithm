package com.l3.test1;

import java.util.Scanner;

public class DuoChuZuiYouFuWu {
	/*
	 * 将所有的待服务的顾客的服务时间排序，然后依次排列在各个服务点
	 * 这样就能保证是从小到大的顺序相加，并且保证后面等待的都是前面最短的时间
	 * 也就是，小的数字加的次数多，大的数字加的次数少
	 */
	
	
	//排序
		private static int[] Paixu(int a[]) {
			
			for(int i = 0;i < a.length-1;i++) {
				for(int j = 0;j < a.length-i-1;j++) {
					if(a[j] > a[j + 1]) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				}
			}
			
			return a;
		}
		
	
	//找到最小等待时间的值
	private static double greedy(int a[],int s) {
		
		int n = a.length;
		int st[] = new int[s];
		int su[] = new int[s];
		int j;
		for(int i = 0;i<n;i++) {
			j = i%s;//去第几个服务区
			st[j] = st[j] + a[i];//服务的时间
			su[j] = su[j] + st[j];//等待的时间
		}
		int sum = 0;
		for(int i = 0;i<s;i++) {
			sum+=su[i];
		}
		
		double t = sum/n*1.0;
		
		return t;
	}
	
	public static void main(String[] args) {
		
		Scanner input  = new Scanner(System.in);
		
		int n,s;
		n = input.nextInt();
		s = input.nextInt();
		int a[] = new int[n];
		for(int i = 0;i < n;i++) {
			a[i] = input.nextInt();
		}
		int b[] = Paixu(a);
		for(int i = 0;i<b.length;i++) {
			System.out.println(a[i]);
		}

		double t = greedy(b, s);
		System.out.println(t);

	}

}
