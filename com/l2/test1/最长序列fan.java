package com.l2.test1;

public class �����fan {
	 public static void main(String[] args) { 
	  int[] arr = {3,1,2,4,5};
	  int max = 0;
	  int maxLen = arr.length;
	  // �Ӻ���ǰ�������飬�ֱ������arr[i]��β��ʱ���������г���
	  for (int i = arr.length - 1; i > 0; i--) {
	   int[] newArr = new int[i];
	   System.arraycopy(arr, 0, newArr, 0, i);
	   int currentLength = 1 + dp(newArr, arr[i]);
	   if (currentLength  > max)
	    max = currentLength;
	   // ������еĳ����Ϊԭʼ����ĳ��ȣ�
	   if (max == maxLen)
	    break;
	  }
	  System.out.println(max);
	 }

	 public static int dp(int[] arr, int end) {
	  // �ݹ��������
	  if (arr.length == 1) {
	   // С��end��������������У������г���+1
	   if (arr[0] <= end)
	    return 1;
	   else
	    return 0;
	  }
	  // �������飬�ҵ����end�Ĳ���<=end��Ԫ��λ��i
	  for (int i = arr.length - 1; i >= 0; i--) {
	   if (arr[i] <= end) {
	    // ��i���ض����飬��arr[0]��arr[i-1]�������������ݹ��󳤶�
	    int[] newArr = new int[i];
	    System.arraycopy(arr, 0, newArr, 0, i);
	    // �ֱ�������arr[i]ʱ��������кͲ�����arr[i]ʱ��������У�ȡ���ֵ
	    return dp(newArr, arr[i]) + 1 > dp(newArr, end) ? dp(newArr, arr[i]) + 1 : dp(newArr, end);
	   }
	  }// ���û�ҵ���end��С�ģ����س���Ϊ0
	  return 0;
	 }
}
