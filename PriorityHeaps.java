package Heaps;

import java.util.*;

public class PriorityHeaps {
	
	private static int[] array;
	private static int heap_size;
	
	public PriorityHeaps(int arr[]) {
		PriorityHeaps.array = arr;
		PriorityHeaps.heap_size = arr.length;
		
	}
	
	 
	
	public static int left(int i) {
		return 2*i;
	}
	
	public static int right(int i) {
		return 2*i+1;
	}
	
	public static int parent(int i) {
		return (int)Math.floor(i/2);
	}
	
	public static int[] build_max_heaps(int arr[]) {
		array = arr;
		heap_size = arr.length;
		
		
		for(int i=heap_size/2-1;i>=0;i--)
			max_heapify(i);
		
		for(Integer c: array) System.out.print(c+" ");
		return array;
	}
	
	public static int[] build_max_heaps() {
		
		
		for(int i=heap_size/2-1;i>=0;i--)
			max_heapify(i);
		
		//for(Integer c: array) System.out.print(c+" ");
		return array;
	}
	
	public static int extract_max() throws Exception {
		if(heap_size<=0) throw new NullPointerException();
		
		build_max_heaps();
		
		int min = array[0]; 
		
		array[0] = array[heap_size-1];
		heap_size--;
		max_heapify(0);
		
		return min;
	}
	
	
	public static void heapSort() {
		
		for(int i=array.length-1;i>0;i--) {
			int temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			heap_size--;
			max_heapify(0);
		}
		
		
	}
	
	
	
	public static void max_heapify(int i) {
		
		int l = left(i);
		int r = right(i);
		int largest =i;
		if(l<heap_size && array[l]>array[i])
			largest = l;
		else largest = i;
		if(r<heap_size && array[r]>array[largest])
			largest = r;
		if(largest!=i) {
			
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			max_heapify(largest);
		}
	}
	
	public static void insert(int key) {
		heap_size++;
		array[heap_size-1] = Integer.MIN_VALUE;
		try {
		increase_key(key,heap_size-1);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void increase_key(int key, int i) throws  Exception {
		if(key< array[i]) {
			System.out.println("Key is less than the current value");
			throw new Exception();
		}
		array[i] = key;
		
		while(i>0 && array[parent(i)]<array[i]) {
			int temp = array[parent(i)];
			array[parent(i)] = array[i];
			array[i] = temp;
			i = parent(i);
		}
			
	}
	
	
	public static void main(String[] args) throws Exception {
		int []arr = {1,35,799,12,32,36,89,22,1,41,2,2,-1};
		PriorityHeaps obj = new PriorityHeaps(arr);
		build_max_heaps();
		System.out.println(extract_max());
		insert(800);
		System.out.println();
		System.out.println(extract_max());
		increase_key(809,0);
		System.out.println(extract_max());
	}


}
