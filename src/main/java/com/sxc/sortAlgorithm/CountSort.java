package com.sxc.sortAlgorithm;

public class CountSort {
	public static void countSort(int[] origin,int[] result,int scope){
		int[] count = new int[scope+1];
		for(int i=0;i<=scope;i++){
			count[i] = 0;
		}
		
		for(int j=0;j<origin.length;j++){
			count[origin[j]]++;
		}
		
		for(int i=1;i<=scope;i++){
			count[i] = count[i] + count[i-1];
		}
		
		for(int j=origin.length-1;j>=0;j--){
			result[count[origin[j]]-1] = origin[j];
			count[origin[j]]--;
		}
	}
	
	public static void main(String[] args) {
		int[] origin = {8,9,7,6,5,4,3,2,1,0};
		int scope = 9;
		int[] result = new int[origin.length];
		countSort(origin,result,scope);
		for(int i : result){
			System.out.println(i);
		}
	}
}
