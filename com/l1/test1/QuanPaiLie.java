package com.l1.test1;
public class QuanPaiLie {
	/*
	 * ��һ�������ÿһ�����н���
	 * */
	
	
	
	
	public static void swap(char a[],int p,int q) {
		char temp = a[p];
		a[p] = a[q];
		a[q] = temp;
	}
	
	public static void print(char a[],int n) {
		for(int i = 0;i < n;i++) {
			System.out.print(a[i]+" ");
		}
		
		System.out.println();
	}
	
	
	public static void perm(char a[],int start,int end) {
		if(start == end) {//���������һ���Լ����Լ�����ȫ���У�Ҳ������С��һ��Ԫ��
			print(a,a.length);
			return;
		}else {
			for(int i = start;i <= end;i++) {
			swap(a,start,i);
			perm(a,start+1,end);//�𲽼�С�����ȫ����
			swap(a,start,i);//���ԭ�������ӣ���ֹ���ҳ����ظ���
		    }
		}
	}
	
    public static void main(String[] args) {
       char a[] = new char[]{'a','b','c'};
       perm(a,0,a.length-1);
    }


}