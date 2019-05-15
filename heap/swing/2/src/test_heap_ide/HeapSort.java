package test_heap_ide;

import java.util.Scanner;
import java.util.Arrays;


public class HeapSort {
	static Scanner sc;
	private static int n;
	public static void main(String args[]) {
		
		sc = new Scanner(System.in);
		
		System.out.println("Nhap so luong phan tu:");
		int n = sc.nextInt();
		System.out.println("Nhap cac phan tu cua mang: ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			}
			System.out.println("mang chua duoc sap xep la: ");
			System.out.println(Arrays.toString(arr));
			
			buildheap(arr);
			System.out.println("mang duoc vun la:");
			System.out.println(Arrays.toString(arr));
			
			heap(arr);
			System.out.println("mang da duoc sap xep la: ");
			System.out.println(Arrays.toString(arr));
			
		}
	//Hoán vị nút cha thứ i phải lớn hơn nút con
	static void heapify(int a[], int n, int i) { 
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)// nut trai
			if (a[child] > a[max])
				max = child;
		if (child + 1 < n) // nut phai
			if (a[child + 1] > a[max])
				max = child + 1;
		if (max != i) {//swap
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}
	//Tạo đống
	static void buildheap(int a[]) {
		//xét i=a.length/2 xuống i=0
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapify(a, a.length, i);
	}
	//sắp xếp theo heapsort
	static void heap(int a[]) {
		buildheap(a);//goi lai ham buildheap
		for (int i = a.length - 1; i >= 1; i--) {
			int temp = a[0];//swap
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i, 0);//tao dong
		}
	}
}
