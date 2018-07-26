package Heaps;
import java.util.*;

public class FindMedianStreamOfIntegers {
	
	public static double[] getmedian(int[] array) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(new Comparator<Integer>(){
			
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		
		double[] median = new double[array.length];
		
		for(int i = 0; i < array.length ; i++) {
			int number = array[i];
			addNumber(number, maxheap, minHeap);
			rebalance(maxheap,minHeap);
			median[i] = medianIs(maxheap,minHeap);
		}
		return median;
	}
	
	private static void rebalance(PriorityQueue<Integer> maxheap, PriorityQueue<Integer> minHeap) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> bigger = (maxheap.size()>minHeap.size())? maxheap:minHeap;
		PriorityQueue<Integer> smaller = (maxheap.size()<minHeap.size())? maxheap:minHeap;
		
		if(bigger.size() - smaller.size() >= 2 ) {
			smaller.add(bigger.poll());
		}
	}
	
	

	private static double medianIs(PriorityQueue<Integer> maxheap, PriorityQueue<Integer> minHeap) {
		PriorityQueue<Integer> bigger = (maxheap.size()>minHeap.size())? maxheap:minHeap;
		PriorityQueue<Integer> smaller = (maxheap.size()<minHeap.size())? maxheap:minHeap;
		
		if(bigger.size() == smaller.size()) return (double)(maxheap.peek()+minHeap.peek())/2;
		
		else return bigger.peek();
	}

	public static void addNumber(int number,PriorityQueue<Integer> maxheap,PriorityQueue<Integer> minHeap) {
		if(maxheap.size() == 0 || number < maxheap.peek()) {
			maxheap.add(number);
		}else {
			minHeap.add(number);
		}
	} 
	
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		double out[] = getmedian(arr);
		for(Double d: out) System.out.println(d+" ");
		
	}
	
}
