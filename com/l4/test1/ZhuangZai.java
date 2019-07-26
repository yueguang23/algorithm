package com.l4.test1;

import java.util.Scanner;

public class ZhuangZai {
	
	private static int bestw = 0;//���ŵ�װ����
	private static int bestx[] = new int [1000];//����װ�ؽ��
	private static int cw;//��ǰװ����
	private static int cx[] = new int [1000];//��ǰװ�ؽ��
	private static int w[] = new int [100];//��Ʒ����
	private static int n;//��Ʒ����
	private static int b[] = new int [3];//���������
	private static int c[] = new int[3];// c[i]��i������Ŀǰ����
	
	private static void backtrack(int t) {
		if(t>n) {
			if(cw > bestw) {
				for(int i = 1;i<=n;i++) {
					bestx[i] = cx[i];
				}
				bestw = cw;
			}
		}else {
			/*
			 * �൱���Ӽ�������·��֧��ֻ�ǰ����������ĵ������˳�����i=1����ָ�ϵ�һ�Ҵ���
			 * ��ʱ��Ҫ�жϵ�i�Ҵ��ǲ��ǿ��Գ��ܣ����������ô����i�Ҵ��������������
			 * ���ܵļ�¼����������ļ��������������Ȼ��������ڶ�����Ʒ
			 */
			for(int i = 1;i<=2;i++) {
				if(c[i] + w[t] <= b[i]) {
					cw = cw + w[t];
					cx[t] = i;
					c[i] = c[i] + w[t];
					backtrack(t+1);
					cw = cw - w[t];
					c[i] = c[i] - w[t];
				}
				cx[t] = 0;
				backtrack(t+1);
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		 * �������ݣ������11  0 2 0 2 1 ����һ�Ŵ�װ��5����Ʒ��2�Ŵ�װ��2�ź�4����Ʒ
		 * 5 6
		 * 5
		 * 1 2 3 4 5
		 */
		Scanner input = new Scanner(System.in);
		b[1] = input.nextInt();//��һ�Ҵ��������
		b[2] = input.nextInt();//�ڶ��Ҵ��������
		
		n = input.nextInt();//n����Ʒ
		for(int i = 1;i<=n;i++) {
			w[i] = input.nextInt();//ÿ����Ʒ������
		}
		backtrack(1);
		System.out.println(bestw);
		for(int i = 1;i<=n;i++) {
			System.out.print(bestx[i] + " ");
		}
	}
}
