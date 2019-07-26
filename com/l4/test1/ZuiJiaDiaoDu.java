package com.l4.test1;

import java.util.Scanner;

public class ZuiJiaDiaoDu {
	
	public static int n;//等待的服务个数
	public static int bestx = 99999;//最初的最优值
	public static int MAX(int s[]) {
		int max = s[0];
		for (int i = 1;i <= s.length-1;i++) {
			if(s[i]>max) {
				max = s[i];
			}
		}
		return max;
	}
	
	public static int BackTrack(int t,int s[],int x[]) {
		if(t>n) {
			int cx = MAX(s);
			if(cx < bestx) {
				bestx = cx;
			}
		}else {
			for(int i = 1;i <=s.length-1;i++) {
				s[i] = s[i] + x[t];
				BackTrack(t+1, s, x);
				s[i] = s[i] - x[t];
			}
			
		}
		
		return bestx;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();//任务
		int s1 = input.nextInt();//机器个数
		int s[] = new int [s1+1];//每个机器完成的时间的数组
		int x[] = new int [n+1];//完成n个人任务的时间的数组
		for(int i = 1;i<=n;i++) {
			x[i] = input.nextInt();
		}
		int t = BackTrack(1, s, x);
		System.out.println(t);
	}
}
