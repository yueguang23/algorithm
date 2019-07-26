package com.l1.test1;

public class HeBingZiRan1 {
	
	private static int t[] = new int [10];//记录小数组的头
	private static int flag=0;
	 
	public static void Merge(int a[],int b[],int l,int m,int r){
	    int i=l,j=m+1,k=l;
	    while(i<=m&&j<=r){
	        if(a[i]<a[j])b[k++]=a[i++];
	        else b[k++]=a[j++];
	    }
	    while(i<=m)b[k++]=a[i++];
	    while(j<=r)b[k++]=a[j++];
	}
	 
	public static void getPos(int a[],int t[],int n){
	    t[flag++]=0;
	    for(int i=0;i<n-1;i++){
	        if(a[i+1]<a[i]){
	        	t[flag++]=i+1;
	        	}
	    }
	    for(int i=0;i<flag;i++)//输出小数组
	    	{
	    	System.out.print(t[i] + " ");
	    	}
	    System.out.println();
	}
	 
	public static void MergePass(int x[],int y[],int s,int n){
	    int i=0;//i表示第几段
	    while(i<=flag-2*s){//前几段，剩下的数组可能是2*s段也可能是s段，单独讨论
	        int r=((i+2*s)<flag)?t[i+2*s]:n;//找到最右边的为r-1
	        Merge(x,y,t[i],t[i+s]-1,r-1);//把两个长度为s的段合并在一起
	        i=i+2*s;//因为是2段合并，所以用2*s
	    }
	    if(i+s<flag)Merge(x,y,t[i],t[i+s]-1,n-1);//剩下的是2*s段
	    else{//剩下的是s段
	        for(int j=t[i];j<=n-1;j++){
	            y[j]=x[j];
	        }
	    }
	}
	public static void MergeSort(int a[],int n){
	    int b[] = new int[10];
	    int s=1;//此时s表示的是段的个数
	    while(s<flag){//最多flag段
	        MergePass(a,b,s,n);//把a合并到b中
	        //此以次排序之后的在b里面，下面就是再把b里面的再排序放到a里
	        s+=s;
	        MergePass(b,a,s,n);//把b合并到a中
	        s+=s;
	    }
	}
	 
	public static void main(String[] args) {
		
	
	    int a[] = {4,8,3,7,1,5,6,2,9,0};
	    int n=10;
	    getPos(a,t,n);
	    MergeSort(a,n);
	    for(int i=0;i<n;i++){
	    	System.out.print(a[i]  + " ");
	    }
	   System.out.println();
	}
}
