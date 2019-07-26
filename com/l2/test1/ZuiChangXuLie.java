package com.l2.test1;

import java.util.Scanner;

public class ZuiChangXuLie {
/*
 * 想法：
 * 先从第一个元素开始      遍历找关于这第一个元素的递增序列，然后记录序列个数和对应的起始元素的下标，
 * 遍历之后找到最大的个数，并且从下标开始找递增序列就是最长递增序列
 */
	public static void main(String[] args) {
		int max = 0, count = 1,n = 7;
	    int b, c = 0;
	    int N = 0;
	    Scanner input = new Scanner(System.in);
	    N = input.nextInt();
	    int a[] = new int[N];
	    for(int i = 0 ;i < N;i++) {
	    	a[i] = input.nextInt();
	    }
	    
	    for (int i = 0; i < n; i++) {
	        b = a[i];
	        for (int j = i + 1; j < n; j++) {
	            if (b < a[j]) {
	                b = a[j];
	                count++;
	            }
	        }
	        if (max < count) {
	            max = count;
	            c = i;
	        }
	        count = 1;
	    }
	    System.out.println(a[c]);//输出第一个元素
	    //printf("%d ",a[c]);
	    b = a[c];
	    for (int i = c + 1; i < n; i++) {
	        if (b < a[i]) {
	            b = a[i];
	           // printf("%d ", b);
	            System.out.println(b);
	        }
	    }
	
	}

}
