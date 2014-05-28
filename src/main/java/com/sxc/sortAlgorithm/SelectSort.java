package com.sxc.sortAlgorithm;

import java.util.List;

public class SelectSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {
	public void sort(List<T> list) {
		selectSort(list);
	}

	private void selectSort(List<T> list){
		final int L = list.size();
		for(int i=0; i<L-1; i++){
			int k = i;
			for(int j=i+1; j<L; j++)
				if(list.get(j).compareTo(list.get(k)) < 0)
					k = j;
			if(k != i){
				T temp = list.get(i);
				list.set(i, list.get(k));
				list.set(k, temp);
			}
		}
	}
	
	public static void selectSort(int[] A){
		int n = A.length;	
		for(int i=0;i<n-1;i++){ 
			int k = i;
			for(int j=i+1;j<n;j++)
				if(A[j] < A[k]) k = j;
			if(k != i){
				int temp = A[i];
				A[i] = A[k];
				A[k] = temp;
			}
		}
	}
}
