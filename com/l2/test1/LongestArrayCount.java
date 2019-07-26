package com.l2.test1;

import java.util.Scanner;

public class LongestArrayCount {

	private static int MAX = 100;
	private static int Find(int a[],int n ) {
		int Longest[] = new int[MAX];
		
		for(int i = 0;i<n;i++) {
			Longest[i] = 1;
		}
		
		for(int i = 1;i < n;i++) {
			for(int j = 0;j < i;j++) {
				if(a[i] > a[j] && Longest[i] < Longest[j] +1) {
					Longest[i] = Longest[j] +1;
				}
			}
		}
		
		
		int max;
		max = Longest[0];
		for(int i = 0;i < n;i++) {
			if(Longest[i] > max) {
				max = Longest[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		
		int n;

		int a [] = new int[MAX];
		
		n = input.nextInt();
		
		for(int i = 0; i< n;i ++) {
			a[i] = input.nextInt();
		}
		
		int max = Find(a,n);
		System.out.println(max);
	}

}
