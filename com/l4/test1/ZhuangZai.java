package com.l4.test1;

import java.util.Scanner;

public class ZhuangZai {
	
	private static int bestw = 0;//最优的装载量
	private static int bestx[] = new int [1000];//最优装载结果
	private static int cw;//当前装载量
	private static int cx[] = new int [1000];//当前装载结果
	private static int w[] = new int [100];//物品重量
	private static int n;//物品个数
	private static int b[] = new int [3];//船最大载重
	private static int c[] = new int[3];// c[i]第i个船的目前载重
	
	private static void backtrack(int t) {
		if(t>n) {
			if(cw > bestw) {
				for(int i = 1;i<=n;i++) {
					bestx[i] = cx[i];
				}
				bestw = cw;
			}
		}else {
			/*
			 * 相当于子集树的两路分支，只是把上两个船的单独列了出来。i=1就是指上第一艘船，
			 * 这时候要判断第i艘船是不是可以承受，如果可以那么给第i艘船加上物体的重量
			 * 给总的记录最大载重量的加上物体的重量，然后继续看第二个物品
			 */
			for(int i = 1;i<=2;i++) {
				if(c[i] + w[t] <= b[i]) {
					cw = cw + w[t];
					cx[t] = i;
					c[i] = c[i] + w[t];
					backtrack(t+1);
					cw = cw - w[t];
					c[i] = c[i] - w[t];
				}
				cx[t] = 0;
				backtrack(t+1);
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 测试数据：结果是11  0 2 0 2 1 代表一号船装了5号商品，2号船装了2号和4号商品
		 * 5 6
		 * 5
		 * 1 2 3 4 5
		 */
		Scanner input = new Scanner(System.in);
		b[1] = input.nextInt();//第一艘船最大载重
		b[2] = input.nextInt();//第二艘船最大载重
		
		n = input.nextInt();//n个物品
		for(int i = 1;i<=n;i++) {
			w[i] = input.nextInt();//每个物品的重量
		}
		backtrack(1);
		System.out.println(bestw);
		for(int i = 1;i<=n;i++) {
			System.out.print(bestx[i] + " ");
		}
	}
}
