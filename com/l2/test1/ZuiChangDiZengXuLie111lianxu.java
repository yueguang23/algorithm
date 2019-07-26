package com.l2.test1;

/*求每个小的数组的起始位置，用temp记载，求每个小数组的长度用b来记载，
 * 最长的递增序列的长度就是b里面最大值
 * b是根据temp来求的，是用前一个减去后一个的值，因此b的每一个元素位置对应temp的减数的位置
 * 即对应在a中的最长递增数列的起始位置，这样最长数列起始值和长度知道，最长递增数列也就知道了
*/


public class ZuiChangDiZengXuLie111lianxu {
	static int a[] ={5,6,7,5,9,6,7,5,6,7,8,10};
	static int temp[] = new int[a.length];
	static int flag = 0;
	public static void main(String[] args) {
		//System.out.println(a.length);
		int b[] = getLongest(a,temp,flag);
		//System.out.println(b.length);
//		for(int i =0 ;i<b.length;i++) {
//			System.out.println(b[i]);
//		}
		
		int max=b[0],maxi = 0;
		for(int i = 0;i<b.length;i++) {
			if(max<b[i]) {
				max=b[i];
				maxi = i;
			}
		}
		
		System.out.println("最大递增序列长度是：" +max);
		System.out.println("最大递增序列是：");
		for(int i = temp[maxi];i<temp[maxi]+max;i++) {
			System.out.print(a[i]+" ");
		}

	}

	//求每个小的数组的起始位置，用temp记载，求每个小数组的长度用b来记载，
	public static int [] getLongest (int a[],int temp[],int flag) {
		temp[flag] = 0;
		flag++;
		for(int i = 0;i < a.length-1;i++) {
			if(a[i+1]<a[i]) {
				temp[flag] = i+1;
				flag++;
			}
		}
		//System.out.println(flag);
//		for(int i = 0;i< flag;i++) {
//			System.out.println(temp[i]);
//		}
		int b[] = new int [flag];
		int i;
		for(i = 0;i<b.length-1;i++) {
			b[i] = temp[i+1] - temp[i];
		}

		if(i < b.length) {
			b[i]=temp.length - temp[i];
		}
		return b;
	}
}
	
	
