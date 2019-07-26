package com.l1.test1;

public class HeBingZiRan1 {
	
	private static int t[] = new int [10];//��¼С�����ͷ
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
	    for(int i=0;i<flag;i++)//���С����
	    	{
	    	System.out.print(t[i] + " ");
	    	}
	    System.out.println();
	}
	 
	public static void MergePass(int x[],int y[],int s,int n){
	    int i=0;//i��ʾ�ڼ���
	    while(i<=flag-2*s){//ǰ���Σ�ʣ�µ����������2*s��Ҳ������s�Σ���������
	        int r=((i+2*s)<flag)?t[i+2*s]:n;//�ҵ����ұߵ�Ϊr-1
	        Merge(x,y,t[i],t[i+s]-1,r-1);//����������Ϊs�Ķκϲ���һ��
	        i=i+2*s;//��Ϊ��2�κϲ���������2*s
	    }
	    if(i+s<flag)Merge(x,y,t[i],t[i+s]-1,n-1);//ʣ�µ���2*s��
	    else{//ʣ�µ���s��
	        for(int j=t[i];j<=n-1;j++){
	            y[j]=x[j];
	        }
	    }
	}
	public static void MergeSort(int a[],int n){
	    int b[] = new int[10];
	    int s=1;//��ʱs��ʾ���Ƕεĸ���
	    while(s<flag){//���flag��
	        MergePass(a,b,s,n);//��a�ϲ���b��
	        //���Դ�����֮�����b���棬��������ٰ�b�����������ŵ�a��
	        s+=s;
	        MergePass(b,a,s,n);//��b�ϲ���a��
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
