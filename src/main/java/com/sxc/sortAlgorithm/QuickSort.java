package com.sxc.sortAlgorithm;

import java.util.List;

public class QuickSort <T extends Comparable<? super T>> implements SortAlgorithm<T> {
	public void sort(List<T> list) {
		quickSort(list,0,list.size()-1);
	}
	
	private void quickSort(List<T> list, int left, int right){
		if(left < right){
			int pivotPosition = partition(list, left, right);
			quickSort(list,left,pivotPosition-1);
			quickSort(list,pivotPosition+1,right);
		}
	}
	
	private int partition(List<T> list, int low, int high){
		int pivotPosition = low;
		T pivot = list.get(low);
		for(int i=low+1; i<=high; i++){
			if(list.get(i).compareTo(pivot) < 0){
				pivotPosition ++;
				if(pivotPosition != i){
					T temp = list.get(pivotPosition);
					list.set(pivotPosition, list.get(i));
					list.set(i, temp);
				}
			}
		}
		list.set(low, list.get(pivotPosition));
		list.set(pivotPosition, pivot);
		return pivotPosition;
	}
	
	public static void quickSort(int[] A,int left,int right){
		if(left < right){
			int pivotpos = partition(A,left,right);
			quickSort(A,left,pivotpos-1);
			quickSort(A,pivotpos+1,right);
		}
	}
	
	public static int partition(int[] A,int low,int high){
		int pivotpos = low;
		int pivot = A[low];
		for(int i=low+1;i<=high;i++){
			if(A[i] < pivot){
				pivotpos++;
				if(pivotpos != i){
					int temp = A[pivotpos];
					A[pivotpos] = A[i];
					A[i] = temp;
				}
			}
		}
		A[low] = A[pivotpos];
		A[pivotpos] = pivot;
		return pivotpos;
	}
}