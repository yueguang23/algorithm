package com.l1.test1;

import java.util.Scanner;

public class ZhengShuYinZi {
	private int total = 0;
	
	/**
	 * ������˼���Ǵ��������С�����ַֽ�ģ�С���������ɸ�С�����ַֽ�ģ�����ֻҪ���ÿ�����ӵ����Ӹ����Ϳ����ˣ�����һ���ݹ�˼��
	 * �ֽ⵽�����ٷֵ�ʱ��Ϊ1
	 * ���磬2��Ϊ1,3��Ϊ1,6�İ���3������2��Ϊ1+1���ټ����Լ�����1+1+1
	 * 
	 * @param n
	 */
	public void Solve(int n) {
		if(n==1) {//�ֽ⵽���
			total++;//������
		}else {
			for(int i = 2;i <= n;i++) {//��2��ʼ�ǲ������ظ��ļ�����6��ʱ������һ�������
									   //���������1��ʼ�Ļ�������ĵݹ��һֱ��ԭ��������
									   //���磬2����1����ʼ�Ļ�����ô�����n/1����2����ôһֱ����2��
				if(n%i == 0)//�����ӣ�
				Solve(n/i);//���ӵ����Ӹ���
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
