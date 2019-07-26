package com.l3.test1;

import java.util.Scanner;

public class HuiChangN1 {
	/*
	 * ���Ƚ����еĿ�ʼ�ͽ���ʱ�䶼�ŵ�a�����У�Ȼ��ͬʱ��Ӧb�����¼ʱ���ǿ�ʼ�Ļ��ǽ�����
	 * Ȼ���a���������������b������ʱ��ȻҪ��¼��Ӧ���ǿ�ʼ���ǽ����ģ��������a������ôbһ��ҲҪ����
	 * Ȼ��õ�һ���ź��������a��һ����Ӧ��¼�ǿ�ʼ���ǽ���������b
	 * Ȼ����һ��������c����������a������ǿ�ʼʱ��count++�����Ҽ�¼��c
	 * ����ǽ���ʱ����ôcount--����¼��c���ҵ�c�������Ǹ����ľ��Ƕ�Ӧ�Ļ᳡��count��
	 * 
	 */
	
	//���ֵ
	private static int Max(int c[]) {
		
		int max = c[1];
		
		for(int i = 1;i < c.length;i++) {
			if(c[i] > max) {
				max = c [i];
			}
		}
		
		return max;
	}
	
	//����
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
	//�һ᳡��Ŀ
	private static int minHuiChang(int start[],int end[],int label[],int n) {
		
		int count = 0;
		
		int a[] = new int [2 * n + 1];//�����е�ʱ��ŵ���������
		int b[] = new int [2 * n + 1];//����start����end�����0��ʾstart��1��ʾend
		
		for(int i = 1;i <= n;i++) {//����ʼ�ͽ������鸳��a
			a[i] = start[i];
			b[i] = 0;
			a[i + n] = end[i];
			b[i + n] = 1;
		}
		
		for(int i = 1;i < a.length;i++) {//���δ���������a,b
			System.out.print(a[i] + " ");
			System.out.print(b[i] + " ");
		}
		
		a = Paixu(a,b);//����
		
		System.out.println();
		for(int i = 1;i < a.length;i++) {//����ź����a,b
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
		System.out.println(count);//����᳡��
	}
}
