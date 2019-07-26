package com.l2.test1;

public class BagTwo {
	public static void main(String[] args) {
		int[] v = {3,4,5,6};  //价值
		int[] w = {2,4,4,5};  //重量
		int[] b = {1,2,3,4};  //体积
		int c = 6;  //背包容量
		int d = 5;  //背包容积
		
		int[] x = new int[v.length];
		int[][][] m = new int[v.length][c+1][d+1];
		
		knapsack(v,w,b,c,d,m);
		traceback(m,w,c,d,x);
	}
	
	public static void knapsack(int[] v,int[] w,int[] b,int c,int d,int[][][] m) {
		int n = v.length-1;
		//填满第n行
		int jMax = Math.min(w[n]-1,c);
		int kMax = Math.min(b[n], d);
		for(int j=0;j<=jMax;j++)
			for(int k=0;k<=kMax;k++)
				m[n][j][k] = 0;
		for(int j=w[n];j<=c;j++)
			for(int k=b[n];k<=d;k++)
				m[n][j][k] = v[n];
		
		//填满1~n-1行
		for(int i=n-1;i>0;i--) {
			jMax = Math.min(w[i]-1, c);
			kMax = Math.min(b[i]-1, d);
			for(int j=0;j<=jMax;j++)
				for(int k=0;k<=kMax;k++)
					m[i][j][k] = m[i+1][j][k];
			for(int j=w[i];j<=c;j++)
				for(int k=b[i];k<=d;k++)
					m[i][j][k] = Math.max(m[i+1][j][k], m[i+1][j-w[i]][k-b[i]]+v[i]);
		}
		
		//填第0行
		if(c>=w[0] && d>=b[0]){
			jMax = Math.min(w[0]-1, c);
			kMax = Math.min(b[0]-1, d);
			for(int j=0;j<=jMax;j++)
				for(int k=0;k<=kMax;k++)
					m[0][j][k] = m[1][j][k];
			for(int j=w[0];j<=c;j++)
				for(int k=b[n];k<=d;k++)
					m[0][j][k] = Math.max(m[1][j][k], m[1][j-w[0]][k-b[0]]+v[0]);
		}
		
		//输出m数组
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=c;j++) {
				for(int k=0;k<=d;k++) {
				System.out.print(m[i][j][k] + "\t");
				}
				//System.out.println();
			}
			System.out.println();
		}
	}
	
	//输出哪个物品装入了背包
	public static void traceback(int[][][] m,int[] w,int c, int d,int[] x) {
		int n = w.length-1;
		for(int i=0;i<n;i++) {
			if(m[i][c][d]==m[i+1][c][d]) {x[i]=0;}  //未装入
			else {                                  //装入
				x[i]=1;
				c -= w[i];
			}
			x[n]=(m[n][c][d]>0)?1:0;		
		}
		for(int i=0;i<=n;i++) {
			System.out.print(x[i]+" ");
		}
	}

}
