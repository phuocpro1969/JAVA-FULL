package test_heap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main_heapsort {
	
	private static int n;
	
	public static void swap(ArrayList a, int l, int r)
	{
		int tmp;
		tmp = (int) a.get(l);
		a.set(l, a.get(r));
		a.set(r, tmp);
	}
	
	public static void heapify(ArrayList a, int n, int i) { 
		int max, l, r;
		l = 2 * i + 1;
		r = 2 * i + 2;
		max = i;
		if (l < n)// nut trai
			if ( (int) a.get(l) > (int) a.get(max))
				max = l;
		if (r < n) // nut phai
			if ( (int) a.get(r) > (int) a.get(max))
				max = r;
		if (max != i) {//swap
			swap(a, i, max);
			heapify(a, n, max);
		}
	}
	//Tạo đống
	public static void buildheap(ArrayList a) {
		 //xét i=a.length/2 xuống i=0
		for (int i = n/2 -1; i >= 0; i--)
			heapify(a, n, i);
	}

	public static void heap(ArrayList a) {
		n = a.size();
		buildheap(a);//goi lai ham buildheap
		for (int i = n-1; i >= 0; i--) {
			swap(a,0,i);
			heapify(a, i, 0);//tao dong
		}
	}
}
