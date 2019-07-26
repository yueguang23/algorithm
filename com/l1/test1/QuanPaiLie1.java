package com.l1.test1;

public class QuanPaiLie1 {
	public static void permutation(char[]ss,int i){  
        if(ss==null||i<0 ||i>ss.length){//1  
            return;  
        }
        
        if(i==ss.length-1){//2  
            System.out.println(new String(ss));  
        }else{  
            for(int j=i;j<ss.length;j++){//3  
            	swap(ss,i,j);
                permutation(ss,i+1);//4  
                swap(ss,i,j);
            }   
        }  
    }  
	
	 private static void swap(char[] arr, int i, int j) {
	        char tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp;
	    }
    public static void main(String args[]){
    	permutation(new char[]{'a','b','c'},0);
    }
}
