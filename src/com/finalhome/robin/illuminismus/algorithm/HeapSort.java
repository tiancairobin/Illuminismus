package com.finalhome.robin.illuminismus.algorithm;

public class HeapSort {
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public String printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i=0;i<arr.length;i++) {
			if (i == arr.length-1) {
				sb.append(arr[i]).append("}");
			} else {
				sb.append(arr[i]).append(",");
			}
		}
		return sb.toString();
	}

	public void reheap(int[] arr, int i, int size) {
		int max = i;	// set max to root
		
		// left is bigger than root
		if (2*i+1 < size && arr[2*i+1] > arr[i]) {
			max = 2*i+1;
		}
		
		// right is bigger than current max
		if (2*i+2 < size && arr[2*i+2] > arr[max]) {
			max = 2*i+2;
		}
		
		if (max != i) {
			swap(arr,max,i);
			reheap(arr,max,size);
		}
	}
	
	public void heapSort(int[] arr) {
		for(int i=(arr.length-1)/2;i>=0;i--) {
			reheap(arr,i,arr.length-1);
		}
		
		for(int i=arr.length-1;i>=0;i--) {
			swap(arr,0,i);
			reheap(arr,0,i);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{24,45,482,237,349,78,34,99,122,762,843,65,752,272,58};
		HeapSort heapSort = new HeapSort();
		System.out.println(heapSort.printArray(arr));
		heapSort.heapSort(arr);
		System.out.println(heapSort.printArray(arr));
	}
}
