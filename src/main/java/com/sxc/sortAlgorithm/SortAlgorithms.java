package com.sxc.sortAlgorithm;

import java.util.List;

public class SortAlgorithms {
	public static <T extends Comparable<? super T>> void sort(SortType sortType, List<T> list){
		SortAlgorithm<T> sortAlgorithm = getSortAlgorithm(sortType);
		sortAlgorithm.sort(list);
	}
	
	private static <T extends Comparable<? super T>> SortAlgorithm<T> getSortAlgorithm(SortType sortType){
		SortAlgorithm<T> sortAlgorithm = null;
		switch(sortType){
			case BUBBLE_SORT:
				sortAlgorithm = new BubbleSort<T>();
				break;
			case SELECT_SORT:
				sortAlgorithm = new SelectSort<T>();
				break;
			case INSERT_SORT:
				sortAlgorithm = new InsertSort<T>();
				break;
			case QUICK_SORT:
				sortAlgorithm = new QuickSort<T>();
				break;
			case MERGE_SORT:
				sortAlgorithm = new MergeSort<T>();
				break;
		}
		return sortAlgorithm;
	}
}
