package com.l3.test1;

import java.util.Scanner;

public class HuiChangN2 {
	/*
	 * ��ÿһ���᳡�����ܰ��Ŷ�Ļ���
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
			 * ��ÿһ���᳡���ž����ܶ�Ļ���
			 * ����һ��ʱ�䰲�Ž�ȥ֮�󿴵ڶ���ʱ�䣬�������ͻ��ô�ڶ������Ž�ȥ
			 * ������һ����Ҫ���ڶ������Ƚ��Ƿ�ʱ���ͻ
			 * �Ƿ��ͻ���жϣ�start[b] >= end[a]
			 * ���һ��п�����������Ƿ��Ѿ��л᳡������label[b] !=1
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
			//ÿѭ��һ�μ���ǰһ�εĻ᳡�������ˣ�����Ҫ��һ���᳡
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
