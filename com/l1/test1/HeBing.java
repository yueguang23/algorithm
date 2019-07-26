package com.l1.test1;

public class HeBing {
	static int  a[]={10,20,5,9,35,58,78,54,32,15,28,79,30,50};
	static int b[]=new int[14];
	public static void main(String[] args) {
		mergeSort(0,13);
		for(int i=1;i<b.length;i++)
			System.out.print(a[i]+" ");
	}

	public static void mergeSort(int left,int right) {
		
		if(left<right){
			int mid=(left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left,mid,right);
			copy(a,b,left,right);
		}
	}
	
    private static void copy(int[] a2, int[] b2, int left, int right) {
		   for(int i=left;i<=right;i++)
			a[i]=b[i];
		
	}

	public static void merge(int left, int mid, int right) {
		// TODO Auto-generated method stub
		int start=left;
		int temp=mid+1;
		int index=left;
		while((start<=mid)&&(temp<=right)){//两段数组，一个从left到mid，一个从mid+1到right，每次把小的赋值给数组b
			if(a[start]<=a[temp]){
				b[index++]=a[start++];
			}
			else{
				b[index++]=a[temp++];
			}
		}
		if(start>mid){
			for(int i=temp;i<=right;i++)
				b[index++]=a[i];
		}else{
			for(int i=start;i<=mid;i++)
				b[index++]=a[i];
		}
		
		
	}

	
}