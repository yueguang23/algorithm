package com.l2.test1;
import java.util.Scanner;
public class QiCheJiaYou1 {
	

	    
	    private static int[][][] f = new int[50][50][2];
	    

	    private static int[][] a = new int[50][50];  //��������

	    private static int MAX = 100000;
	    private static int leastFee;

	    public static void main(String[] args){

	    	
	    	
	    	int N;  //���������ģ
		    int A;  //��������ʻ�����������Ϳ�Ӧ�����Ͳ������ͷ�A
		    int C;  //����Ҫʱ��������㴦�����Ϳ⣬���������Ϳ����C���������ͷ�A��
		    int B;  //��������ʻ����һ�������ʱ�������x�����y������٣�Ӧ������B
		    int K;  //װ���ͺ�����ʻK����

	        /*
	        f[i][j][0]��ʾ�����������(1,1)��ʻ�������(i,j)��������ٷ���
	        f[i][j][1]��ʾ������ʻ�������(i,j)������ʻ���������

	        
	        f[i][j][0] = min{f[ i+s[k][0] ] [ [j+s[k][1] ][0] + s[k][2]}
	        f[i][j][1] = f[ i+s[k][0] ][ [j+s[k][1] ][1] - 1

	        f[1][1][0] = 0
	        f[1][1][1] = K
	        f[i][j][0] = f[i][j][0] + A , f[i][j][1] = K   ���(i, j)���Ϳ�
	        f[i][j][0] = f[i][j][0] + C + A, f[i][j][1] = K  (i, j)�����Ϳ⣬��f[i][j][1] = 0
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
	        
	        N = input.nextInt();//�����ģ
	        K = input.nextInt();//װ���ͺ�����ʻ���������
	        A = input.nextInt();//���ͷ�
	        B = input.nextInt();//�������ʱӦ���ķ���
	        C = input.nextInt();//�����Ϳ����
	        
	        for(int i=1; i<=N; i++){//���뷽������
	            for(int j=1; j<=N; j++){
	                a[i][j] = input.nextInt();
	            }
	        }

	        leastFee = dynamic(N,K,A,B,C);
	        System.out.println(leastFee);//������ʻ·������ķ��ã�����С����
	    }

	    private static int dynamic(int N,int K,int A,int B,int C){
	    	
//	    	s[i][0]��ʾx�᷽��
//	        s[i][1]��ʾy�᷽��
//	        s[i][2]��ʾ��ʻ����

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
	                    for(k=0; k<4; k++){ //���ߵ��ĸ�����
	                        tx = i + s[k][0];
	                        ty = j + s[k][1];
	                       System.out.println(i + " " + j+" " + s[k][2]);
	                        if(tx<1 || ty<1 || tx>N || ty>N)  //�������
	                            continue;

	                        fee = f[tx][ty][0] + s[k][2];
	                        System.out.println(s[k][2]);
	                        System.out.println(tx+" " + ty + " " + fee);
	                        canDriveEdges = f[tx][ty][1] - 1;
	                        if(a[i][j] == 1){  //������Ϳ�
	                            fee += A;
	                            canDriveEdges = K;
	                        }
	                        if(a[i][j]==0 && canDriveEdges == 0 && (i!=N||j!=N)){  //��������Ϳ�,�����Ѿ�����
	                            fee += A + C;
	                            canDriveEdges = K;
	                        }
	                        if(fee < minFee){  //��¼���ٷ���
	                            minFee = fee;
	                            driveEdges = canDriveEdges;
	                        }
	                    }

	                    if(f[i][j][0] > minFee){  //����и��Ž�
	                        finish = false;
	                        f[i][j][0] = minFee;
	                        f[i][j][1] = driveEdges;
	                    }
	                }
	            }
	        }
	        return f[N][N][0];//�����������(1,1)��ʻ�������(N,N)��������ٷ��ã��༴����㵽�յ㣩����Ϊ����
	    }
	}


