package com.sxc.sortAlgorithm;

import java.util.List;

public class InsertSort <T extends Comparable<? super T>> implements SortAlgorithm<T> {
	public void sort(List<T> list) {
		insertSort(list);
	}
	
	private void insertSort(List<T> list){
		final int L = list.size();
		for(int j=1; j<L; j++){
			T key = list.get(j);
			int i = j-1;
			while(i>=0 && list.get(i).compareTo(key) > 0){
				list.set(i+1, list.get(i));
				i--;
			}
			list.set(i+1, key);
		}
	}
	
	public static void insertSort(int[] A){
		int n = A.length;
		for(int j=1;j<n;j++){
			int key = A[j]; 
			int i = j-1;
			while(i>=0 && A[i] > key){
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
}
