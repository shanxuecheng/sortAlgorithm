package com.sxc.sortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class TestSortAlgorithm extends TestCase {
	private static List<Character> list = new ArrayList<Character>();
	
	static{
		list.add('g');
		list.add('c');
		list.add('e');
		list.add('d');
		list.add('f');
		list.add('b');
		list.add('a');
	}
	public void testBubbleSort(){
		SortAlgorithms.sort(SortType.BUBBLE_SORT, list);
		printResult();
	}
	
	public void testSelectSort(){
		SortAlgorithms.sort(SortType.SELECT_SORT, list);
		printResult();
	}
	
	public void testInsertSort(){
		SortAlgorithms.sort(SortType.INSERT_SORT, list);
		printResult();
	}
	
	public void testQuickSort(){
		SortAlgorithms.sort(SortType.QUICK_SORT, list);
		SortAlgorithms.sort(SortType.QUICK_SORT, Arrays.asList(3, 2 , 1, 5, 4));
		printResult();
	}
	
	public void testMergeSort(){
		SortAlgorithms.sort(SortType.MERGE_SORT, list);
		printResult();
	}
	
	private void printResult(){
		for(Object obj : list){
			System.out.println(obj);
		}
	}
}
