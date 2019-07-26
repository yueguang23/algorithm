package com.l3.test1;

import java.util.Scanner;

public class HuiChangN2 {
	/*
	 * 给每一个会场尽可能安排多的会议
	 */
	private static int minHuiChang(int start[],int end[],int label[],int n) {
		int count = 0;
		
		for(int i = 1;i <= n;i++) {
			
			if(label[i] == 1) {
				continue;
			}
//			for(int k = 1;k<=n;k++) {
//				System.out.print("..." + label[i]);
//			}
//			System.out.println("ppp");
//			label[i] = 1;
//			System.out.println("lll" + label[i]);
//			System.out.println("lll" + i);
//			for(int j = i+1;j<=n;j++) {
//				int a = i;
//				int b = j;
//				if(label[b] != 1 && start[b] >= end[a]) {
//					label[b] = 1;
//					a = b;
//					b = b+1;
//					System.out.println(j);
//					System.out.println(label[j]);
//					
//				}
//			}
//			count++;
			/*
			 * 给每一个会场安排尽可能多的会议
			 * 即第一个时间安排进去之后看第二个时间，如果不冲突那么第二个安排进去
			 * 这是下一个就要跟第二个来比较是否时间冲突
			 * 是否冲突的判断：start[b] >= end[a]
			 * 并且还有考虑这个会议是否已经有会场安排了label[b] !=1
			 */
			label[i] = 1;
			int a = i;
			int b = i+1;
			while(b<=n) {
				if(start[b] >= end[a]&&label[b] !=1) {
					label[b] = 1;
					a=b;
					b = b+1;
				}
				else {
					b++;
				}
			}
			
			count++;
			//每循环一次即是前一次的会场安排完了，所以要换一个会场
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		n = input.nextInt();
		
		int start[] = new int[n+1];
		int end[] = new int[n+1];
		int label[] = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			start[i] = input.nextInt();
			end[i] = input.nextInt();
			label[i] = 0;
		}
		int count = minHuiChang(start, end, label, n);
		System.out.println(count);
	}
}
