package com.l3.test1;

import java.util.Scanner;

public class DuoChuZuiYouFuWu {
	/*
	 * �����еĴ�����Ĺ˿͵ķ���ʱ������Ȼ�����������ڸ��������
	 * �������ܱ�֤�Ǵ�С�����˳����ӣ����ұ�֤����ȴ��Ķ���ǰ����̵�ʱ��
	 * Ҳ���ǣ�С�����ּӵĴ����࣬������ּӵĴ�����
	 */
	
	
	//����
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
		
	
	//�ҵ���С�ȴ�ʱ���ֵ
	private static double greedy(int a[],int s) {
		
		int n = a.length;
		int st[] = new int[s];
		int su[] = new int[s];
		int j;
		for(int i = 0;i<n;i++) {
			j = i%s;//ȥ�ڼ���������
			st[j] = st[j] + a[i];//�����ʱ��
			su[j] = su[j] + st[j];//�ȴ���ʱ��
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
