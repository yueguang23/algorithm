package com.l2.test1;

/*��ÿ��С���������ʼλ�ã���temp���أ���ÿ��С����ĳ�����b�����أ�
 * ��ĵ������еĳ��Ⱦ���b�������ֵ
 * b�Ǹ���temp����ģ�����ǰһ����ȥ��һ����ֵ�����b��ÿһ��Ԫ��λ�ö�Ӧtemp�ļ�����λ��
 * ����Ӧ��a�е���������е���ʼλ�ã������������ʼֵ�ͳ���֪�������������Ҳ��֪����
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
		
		System.out.println("���������г����ǣ�" +max);
		System.out.println("�����������ǣ�");
		for(int i = temp[maxi];i<temp[maxi]+max;i++) {
			System.out.print(a[i]+" ");
		}

	}

	//��ÿ��С���������ʼλ�ã���temp���أ���ÿ��С����ĳ�����b�����أ�
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
	
	
