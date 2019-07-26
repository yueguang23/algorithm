package com.l1.test1;

public class HeBingZiRan {

	static int t[] = new int[8];
	static int f = 0;
	static int sum = 1;
	public static void Merge(int a[],int b[],int left,int mid,int right) {
		int i = left,j = mid + 1,k = left;
		while((i<mid)&&(j<=right)) {
			if(a[i]<=a[j]) {
				b[k++] = a[i++];
			}else {
				b[k++] = a[j++];
			}
		}
		
		if(i>mid) {
			for(int q=j;q<=right;q++) {
				b[k++]=a[q];
			}
		}else {
			for(int q=i;q<=mid;q++) {
				b[k++]=a[q];
			}
		}
		
	}
	
	
	public static void getTop(int a[],int t[],int f) {
		sum = 0;
		t[f] = 0;
		f++;
		for(int i=0;i<a.length;i++) {
			if(a[i+1]<a[i]) {
				t[f] = i+1;
				f++;
				sum++;
			}
		}
	}
	
	public static void MergeSort(int a[]) {
		f = 0;
		int b[] = new int[8];
		getTop(a, b, f);
		while(sum>1) {
			
			Merge(a, b, t[f], t[f+1],t[f+2]-1 );
			f = f+2;
			if(f>t.length) {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int a[] = {4 ,8 ,3 ,7, 1 ,5 ,6 ,2};
		MergeSort(a);
		for(int i=0;i<a.length;i++){
	    	System.out.print(a[i]  + " ");
	    }
	}
}
