package com.l3.test1;

import java.util.Scanner;
/*
 * ˼�룺
 * �������ǰ���ֵɾ����ʹ�����յ����о���Ϊ�����������У�����ǰ����ʣ������Ķ�Ӧ�ĸ��������
 * */
public class ShanShuWenTI {

	public static void main(String[] args) {
		String a = null;
		int n = -1;
		
		Scanner input = new Scanner(System.in);
		
		a = input.nextLine();
		n = input.nextInt();
		
		char a1[] = a.toCharArray();
		
		if(n == 0) {
			System.out.println(a);
		}
		
		if(a1.length < n) {
			System.out.println("�ַ������Ȳ���");
		}else if(a1.length == n) {
			System.out.println("ɾ����");
		}else {
			int t = n;
			int i = 0;
			while(t > 0&&i<a.length()-1) {
				if(a1[i]>a1[i+1]) {
					for(int j = i;j<a1.length-1;j++) {
						a1[j] = a1[j+1];	
					}
					i = -1;
					t--;
				}
			i++;

			}
			for(int j = 0;j < a1.length-n;j++) {
				
				System.out.print(a1[j]);
				
			}
		}

	}

}
