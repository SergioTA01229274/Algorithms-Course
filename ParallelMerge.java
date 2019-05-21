/*Autores: Sergio Tostado
 * 		   Edgar Manuel Perez Villa
 * 		   Diego Solorzano Ortiz
 * 
 * */

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class  ParallelMerge <E extends Comparable<E>> extends RecursiveAction{
	
	private E[] elements;
	private int min, max, med;
	
	public ParallelMerge(E[] elements, int min, int max) {
		this.elements = elements;
		this.min = min;
		this.max = max;
	}
	
	@Override
	protected void compute() {
		if(this.min < this.max) {
			this.med = (this.min + this.max)/2;
			ParallelMerge<E> m1 = new ParallelMerge<>(this.elements, this.min, this.med);
			ParallelMerge<E> m2 = new ParallelMerge<>(this.elements, this.med + 1, this.max);
			ForkJoinTask.invokeAll(m1, m2);
			merge(this.elements, this.min, this.max);
			
		}
	}
	
	private static <E extends Comparable<E>> void merge(E[] elements, int first, int last) {
		E[] tempArray = (E[]) new Comparable[elements.length];
		
		for(int i = first; i <= last;i++) {
			tempArray[i] = elements[i];
		}

		int punt1 = first;
		int punt2 = ((first + last)/2) + 1;
		int punt3 = first; 
	
		while(punt1 <= ((first + last)/2) && punt2 <= last) {
			if(tempArray[punt1].compareTo(tempArray[punt2]) <= 0){
				elements[punt3] = tempArray[punt1];
				punt1++;
			}else {
				elements[punt3] = tempArray[punt2];
				punt2++;
			}
			punt3++;
		}
		while(punt1 <= ((first + last)/2)) {
			elements[punt3] = tempArray[punt1];
			punt1++;
			punt3++;
		}
	}
	
	public static void main(String[] args) {
		//Integer[] numbers = {7, 3, 5, 1, 6, 8, 24, 32, 13, 89, 0, 65, 44, 31, 15};
		Integer[] numbers2 = new Integer[4000];
		//Integer[] numbers3 = new Integer[10000];
		//Integer[] numbers4 = new Integer[100000];
		Integer[] numbers5 = new Integer[1000000];
		Random rn = new Random();
		
		/*
		
		for(int i = 0; i < numbers3.length; i++) {
			numbers3[i] = new Integer(rn.nextInt(10000));
		}
		for(int i = 0; i < numbers4.length; i++) {
			numbers4[i] = new Integer(rn.nextInt(100000));
		}
		for(int i = 0; i < numbers5.length; i++) {
			numbers5[i] = new Integer(rn.nextInt(1000000));
		}*/
		for(int i = 0; i < numbers2.length; i++) {
			numbers2[i] = new Integer(rn.nextInt(4000));
		}
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		//pool.invoke(new ParallelMerge(numbers, 0, numbers.length - 1));
		pool.invoke(new ParallelMerge(numbers2, 0, numbers2.length - 1));
		//pool.invoke(new ParallelMerge(numbers3, 0, numbers3.length - 1));
		//pool.invoke(new ParallelMerge(numbers4, 0, numbers4.length - 1));
		//pool.invoke(new ParallelMerge(numbers5, 0, numbers5.length - 1));
		
		
		for(int i = 0; i < numbers2.length; i++) {
			System.out.print(numbers2[i] + ", ");
		}
		/*
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		
		for(int i = 0; i < numbers3.length; i++) {
			System.out.print(numbers3[i] + ", ");
		}
		for(int i = 0; i < numbers4.length; i++) {
			System.out.print(numbers4[i] + ", ");
		}*/
		
		/*
		for(int i = 0; i < numbers5.length; i++) {
			System.out.print(numbers5[i] + ", ");
		}*/
	}
}
