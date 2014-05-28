package com.sxc.sortAlgorithm;

import java.util.List;

public interface SortAlgorithm <T extends Comparable<? super T>> {
	public void sort(List<T> list);
}	
