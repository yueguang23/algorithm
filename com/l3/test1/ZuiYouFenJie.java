package com.l3.test1;

import java.util.Scanner;

public class ZuiYouFenJie {
	/*
	 * �ȷֽ�ɴ�2��ʼ��������Ȼ�������飬Ȼ���ٽ�ʣ�µ����ָ��ֽ���������ִӴ�С
	 * ��1�������ͻ�����������֤�˻����
	 * ���磺10 �ֽ�Ϊ2,3,4
	 * ʣ��1����ô1�ӵ�4�ϣ����ֽ�Ϊ2,3,5
	 * �˻����Ϊ2*3*5=30
	 * 
	 */
	public static int fenjie(int n) {
		
		int a[] = new int[100];
		int i = 2;//�ӿ�ʼ����������Ȼ��
		int sum = 0;//��¼�ֽ�����������Ƿ��Ѿ����ڻ��ߵ���n
		int count = 0;//��¼�ֽ������ֵĸ���
		
		//�ֽ����֣������
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
		
		
		
		int b = n-sum;//�����ʣ�µ������Ƕ���
//		for(int j = 0;j<count;j++) {
//			System.out.println(a[j]);
//		}
		while(b>0) {
			if(b<count) {//������ʣ�µ����ֱȷֽ�ĸ���С����ô�Ͱ��������������
				for(int j = count-1;j>count-b-1;j--) {
					a[j] = a[j] +1;
				}
			}else {//���ʣ�µĸ����ȷֽ�ĸ����࣬��ô�Ȱ��շֽ�ĸ����ӣ�Ȼ���ټ�ȥ���������Ƿ񻹴���
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
		int c = 1;//�˻�
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
