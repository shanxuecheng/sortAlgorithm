package com.sxc.sortAlgorithm;

import java.util.List;

public class BubbleSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {
	public void sort(List<T> list) {
		bubbleSort(list);
	}
	
	private void bubbleSort(List<T> list){
		boolean exchange = false;//交换标志
		final int L = list.size();
		for(int i=1; i<L; i++){
			exchange = false;
			for(int j=L-1; j>=i; j--)
				if(list.get(j).compareTo(list.get(j-1)) < 0){
					T temp = list.get(j-1);
					list.set(j-1, list.get(j));
					list.set(j, temp);
					exchange = true;
				}
			if(!exchange)
				return;
		}
	}
	
	public void bubbleSort(int[] A){
		boolean exchange = false;
		int n = A.length;	
		for(int i=1;i<n;i++){
			exchange = false;
			for(int j = n-1;j>=i;j--)
				if(A[j-1]>A[j]){	
					int temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
					exchange = true;
				}
			if(exchange == false)
				return;
		}
	}
}
