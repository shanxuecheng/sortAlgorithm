package com.sxc.sortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort <T extends Comparable<? super T>> implements SortAlgorithm<T>{
	public void sort(List<T> list) {
		mergeSort(list, 0, list.size()-1);
	}
	
	private void mergeSort(List<T> list, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			mergeSort(list, left, mid);
			mergeSort(list, mid+1, right);
			merge(list, left, mid, right);
		}
	}
	
	private void merge(List<T> list, int left, int mid, int right){
		int i,j;
		int N1 = mid - left + 1;
		int N2 = right - mid;
		ArrayList<T> leftList = new ArrayList<T>();
		ArrayList<T> rightList = new ArrayList<T>();
		for(i=0; i<N1; i++)
			leftList.add(i, list.get(i+left));
		for(j=0; j<N2; j++)
			rightList.add(j, list.get(mid+j+1));
		
		i = 0; j = 0;
		for(int k=left; k<=right; k++){
			if(i >= leftList.size()){
				list.set(k, rightList.get(j));
				j++;
			}else if(j >= rightList.size()){
				list.set(k, leftList.get(i));
				i++;
			}else if(leftList.get(i).compareTo(rightList.get(j)) < 0){
				list.set(k, leftList.get(i));
				i++;
			}else{
				list.set(k, rightList.get(j));
				j++;
			}
		}
	}
	
	final int MAX_VALUE =  Integer.MAX_VALUE;
	public void mergeSort(int[] A,int left,int right){
		if(left < right){
			int mid = (left + right)/2;
			mergeSort(A,left,mid);
			mergeSort(A,mid+1,right);
			merge(A,left,mid,right);
		}
	}
	public void merge(int[] A,int left,int mid,int right){
		int i,j;
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int L[] = new int[n1+1];
		int R[] = new int[n2+1];
		for(i = 0;i < n1;i++)
			L[i] = A[i+left];
		for(j = 0;j < n2;j++)
			R[j] = A[mid+j+1];
		L[n1] = MAX_VALUE;
		R[n2] = MAX_VALUE;
		i = 0;j = 0;
		for(int k = left;k <= right;k++){
			if(L[i] <= R[j]){
				A[k] = L[i];
				i++;
			}else{
				A[k] = R[j];
				j++;
			}
		}
	}
	public static void main(String[] agrs){
		int[] A = {1,2,3,4};
		int length = A.length;
		MergeSort<Integer> m = new MergeSort<Integer>();
		m.mergeSort(A,0,length-1);
		StringBuffer result = new StringBuffer();
		for(int i = 0;i < length;i++)
			result.append(A[i] + ",");
		System.out.println(result.subSequence(0, result.lastIndexOf(",")));
	}
}
