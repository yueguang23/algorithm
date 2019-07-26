package com.l1.test1;

import java.util.Scanner;

public class ZhengShuYinZi {
	private int total = 0;
	
	/**
	 * 方法的思想是大的数是由小的数字分解的，小的数字是由更小的数字分解的，这样只要算出每个因子的因子个数就可以了，即是一个递归思想
	 * 分解到不能再分的时候为1
	 * 例如，2的为1,3的为1,6的包含3，包含2，为1+1，再加上自己就是1+1+1
	 * 
	 * @param n
	 */
	public void Solve(int n) {
		if(n==1) {//分解到最简
			total++;//计数器
		}else {
			for(int i = 2;i <= n;i++) {//从2开始是不会算重复的即计算6的时候本身是一种情况，
									   //并且如果从1开始的话，下面的递归会一直是原来的数，
									   //比如，2，从1，开始的话，那么下面的n/1就是2，那么一直就是2了
				if(n%i == 0)//找因子，
				Solve(n/i);//因子的因子个数
			}
		}
	}
	

	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n;
		ZhengShuYinZi yinZi = new ZhengShuYinZi();
		n = input.nextInt();
		yinZi.Solve(n);
		System.out.println(yinZi.total);
		
		
}
}
