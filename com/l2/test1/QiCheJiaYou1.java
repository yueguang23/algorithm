package com.l2.test1;
import java.util.Scanner;
public class QiCheJiaYou1 {
	

	    
	    private static int[][][] f = new int[50][50][2];
	    

	    private static int[][] a = new int[50][50];  //方形网络

	    private static int MAX = 100000;
	    private static int leastFee;

	    public static void main(String[] args){

	    	
	    	
	    	int N;  //方形网络规模
		    int A;  //汽车在行驶过程中遇到油库应加满油并付加油费A
		    int C;  //在需要时可在网格点处增设油库，并付增设油库费用C（不含加油费A）
		    int B;  //当汽车行驶经过一条网格边时，如果其x坐标或y坐标减少，应付费用B
		    int K;  //装满油后，能行驶K条边

	        /*
	        f[i][j][0]表示汽车从网格点(1,1)行驶至网格点(i,j)所需的最少费用
	        f[i][j][1]表示汽车行驶至网格点(i,j)后还能行驶的网格边数

	        
	        f[i][j][0] = min{f[ i+s[k][0] ] [ [j+s[k][1] ][0] + s[k][2]}
	        f[i][j][1] = f[ i+s[k][0] ][ [j+s[k][1] ][1] - 1

	        f[1][1][0] = 0
	        f[1][1][1] = K
	        f[i][j][0] = f[i][j][0] + A , f[i][j][1] = K   如果(i, j)是油库
	        f[i][j][0] = f[i][j][0] + C + A, f[i][j][1] = K  (i, j)不是油库，且f[i][j][1] = 0
	        */

	        /*
	        input data:
	        9 3 2 3 6
	        0 0 0 0 1 0 0 0 0
	        0 0 0 1 0 1 1 0 0
	        1 0 1 0 0 0 0 1 0
	        0 0 0 0 0 1 0 0 1
	        1 0 0 1 0 0 1 0 0
	        0 1 0 0 0 0 0 1 0
	        0 0 0 0 1 0 0 0 1
	        1 0 0 1 0 0 0 1 0
	        0 1 0 0 0 0 0 0 0
	        */
	        Scanner input = new Scanner(System.in);
	        
	        N = input.nextInt();//方格规模
	        K = input.nextInt();//装满油后能行驶的网格边数
	        A = input.nextInt();//加油费
	        B = input.nextInt();//坐标减少时应付的费用
	        C = input.nextInt();//增设油库费用
	        
	        for(int i=1; i<=N; i++){//输入方形网络
	            for(int j=1; j<=N; j++){
	                a[i][j] = input.nextInt();
	            }
	        }

	        leastFee = dynamic(N,K,A,B,C);
	        System.out.println(leastFee);//最优行驶路线所需的费用，即最小费用
	    }

	    private static int dynamic(int N,int K,int A,int B,int C){
	    	
//	    	s[i][0]表示x轴方向
//	        s[i][1]表示y轴方向
//	        s[i][2]表示行驶费用

		  //int[][] s = {{-1,0,B},{0,-1,B},{1,0,0},{0,1,0}};
	    	int[][] s= {{-1,0,0},{0,-1,0},{1,0,B},{0,1,B}};
	        int i, j, k;
	        for (i=1;i<=N;i++){
	            for (j=1;j<=N;j++){
	                f[i][j][0]=MAX;
	                f[i][j][1]=K;
	            }
	        }

	        f[1][1][0] = 0;
	        f[1][1][1] = K;

	        boolean finish = false;
	        int tx, ty;
	        while(!finish){
	            finish = true;
	            for(i=1; i<=N; i++){
	                for(j=1; j<=N; j++){
	                    if(i==1 && j==1)
	                        continue;
	                    int minFee = MAX;
	                    int driveEdges = MAX;
	                    int fee, canDriveEdges;
	                    for(k=0; k<4; k++){ //可走的四个方向
	                        tx = i + s[k][0];
	                        ty = j + s[k][1];
	                       System.out.println(i + " " + j+" " + s[k][2]);
	                        if(tx<1 || ty<1 || tx>N || ty>N)  //如果出界
	                            continue;

	                        fee = f[tx][ty][0] + s[k][2];
	                        System.out.println(s[k][2]);
	                        System.out.println(tx+" " + ty + " " + fee);
	                        canDriveEdges = f[tx][ty][1] - 1;
	                        if(a[i][j] == 1){  //如果是油库
	                            fee += A;
	                            canDriveEdges = K;
	                        }
	                        if(a[i][j]==0 && canDriveEdges == 0 && (i!=N||j!=N)){  //如果不是油库,且油已经用完
	                            fee += A + C;
	                            canDriveEdges = K;
	                        }
	                        if(fee < minFee){  //记录更少费用
	                            minFee = fee;
	                            driveEdges = canDriveEdges;
	                        }
	                    }

	                    if(f[i][j][0] > minFee){  //如果有更优解
	                        finish = false;
	                        f[i][j][0] = minFee;
	                        f[i][j][1] = driveEdges;
	                    }
	                }
	            }
	        }
	        return f[N][N][0];//汽车从网格点(1,1)行驶至网格点(N,N)所需的最少费用（亦即从起点到终点），此为所求
	    }
	}


