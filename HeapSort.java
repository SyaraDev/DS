package com.syara.heaping;

import java.util.Scanner;

public class HeapSort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=scan.nextInt();
		}
		arr = heapify(arr,arr.length);
		print(arr);
		arr=heapSort(arr);
		System.out.println();
		print(arr);
	}
	
	static int[] heapify(int[]arr, int n) {
		
		for(int i=n-1; i>=0; i--) {
			int lc= 2*i;
			int rc= 2*i+1;
			if(lc<n-1 && rc<n-1) {
				if(arr[lc]>arr[i]) {
					int temp = arr[i];
					arr[i]=arr[lc];
					arr[lc]=temp;
				}
				if(arr[rc]>arr[i]) {
					int temp = arr[i];
					arr[i]=arr[rc];
					arr[rc]=temp;
				}
			}
			
		}
		
		
		
		return arr;
	}
	
	static int[] heapSort(int[]arr) {
		
		int n = arr.length;
		
		while(n>0) {
			int temp = arr[n-1];
			arr[n-1] =arr[0];
			arr[0]=temp;
			arr =heapify(arr,n);
			n--;
		}
		
		
		return arr;
	}
	
	static void print(int[]arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
