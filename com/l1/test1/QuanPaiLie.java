package com.l1.test1;
public class QuanPaiLie {
	/*
	 * 第一个与后面每一个进行交换
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
		if(start == end) {//交换到最后一个自己跟自己进行全排列，也就是缩小到一个元素
			print(a,a.length);
			return;
		}else {
			for(int i = start;i <= end;i++) {
			swap(a,start,i);
			perm(a,start+1,end);//逐步减小数组的全排列
			swap(a,start,i);//变回原来的样子，防止混乱出现重复，
		    }
		}
	}
	
    public static void main(String[] args) {
       char a[] = new char[]{'a','b','c'};
       perm(a,0,a.length-1);
    }


}