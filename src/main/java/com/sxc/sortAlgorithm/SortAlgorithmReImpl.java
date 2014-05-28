package com.sxc.sortAlgorithm;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class SortAlgorithmReImpl {
	
	@Test
	public void reimpl() {
		//bubble
		Integer a[] = {3, 5, 2, 1, 4};
		int al = a.length;
		boolean exchange = false;
		for(int i=1; i<al; i++) {
			for(int j=al-1; j>=i; j--) {
				if(a[j-1] > a[j]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					exchange = true;
				}
			}
			if(!exchange)
				break;
		}
		System.out.println(Arrays.asList(a));
		
		//insert
		Integer b[] = {3, 5, 2, 1, 4};
		int bl = b.length;
		for(int i=1; i<bl; i++) {
			int key = b[i];
			int j=i-1;
			while(j >= 0 && b[j] > key) {
				b[j+1] = b[j];
				j--;
			}
			b[j+1] = key;
		}
		System.out.println(Arrays.asList(b));
		
		//select
		Integer c[] = {3, 5, 2, 1, 4};
		int cl = c.length;
		for(int i=0; i<cl-1; i++) {
			int min = i;
			for(int j=i+1; j<cl; j++) {
				if(c[j] < c[min]) 
					min = j;
			}
			int temp = c[i];
			c[i] = c[min];
			c[min] = temp;
		}
		System.out.println(Arrays.asList(c));
		
		//quick1
		Integer d[] = {3, 2, 1, 5, 4};
		quickSort1(d, 0, 4);
		System.out.println(Arrays.asList(d));
		
		//quick2
		Integer e[] = {3, 2, 1, 5, 4};
		quickSort2(e, 0, 4);
		System.out.println(Arrays.asList(e));
		
		//merge
		Integer f[] = {3, 2, 1, 5, 4};
		int[] f1 = ArrayUtils.toPrimitive(f);
		mergeSort(f1, 0, 4);
		System.out.println(Arrays.asList(ArrayUtils.toObject(f1)));
	}
	
	public static void quickSort1(Integer[] a, int l, int r) {
		if(l < r) {
			int i = l, j = r, x = a[l];
			while(i < j) {
				while(i < j && a[j] >= x)
					j--;
				if(i < j)
					a[i++] = a[j];
				while(i < j && a[i] <= x)
					i++;
				if(i < j)
					a[j--] = a[i];
			}
			a[i] = x;
			quickSort1(a, l, i-1);
			quickSort1(a, i+1, r);
		}
	}
	
	public static void quickSort2(Integer[] a, int l, int r) {
		if(l < r) {
			int p = l, i = l+1, x = a[l];
			for(; i<=r; i++) {
				if(a[i] < x) {
					p++;
					if(p != i) {
						int temp = a[p];
						a[p] = a[i];
						a[i] = temp;
					}
				}
			}
			a[l] = a[p];
			a[p] = x;
			quickSort2(a, l, p-1);
			quickSort2(a, p+1, r);
		}
	}
	
	public static void mergeSort(int[] a, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			mergeSort(a, l, m);
			mergeSort(a, m+1, r);
			merge(a, l, m, r);
		}
	}
	
	private static void merge(int[] a, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		int[] a1 = Arrays.copyOfRange(a, l, m+1);
		int[] a2 = Arrays.copyOfRange(a, m+1, r+1);
		int i=0,j=0,k=l;
		while(i < n1 && j < n2) {
			if(a1[i] <= a2[j])
				a[k++] = a1[i++];
			else
				a[k++] = a2[j++];
		}
		while(i < n1)
			a[k++] = a1[i++];
		while(j < n2)
			a[k++] = a2[j++];
	}

}
