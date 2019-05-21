import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Fibonacci {
	
	public static class Sequential{
		public long calculate(long n) {
			if(n <= 1) {
				return n;
			}else {
				return calculate(n - 1) + calculate(n - 2);
			}
		}
	}
	public static class Parallel extends RecursiveTask<Long>{
		
		//Recursive actions es para procesos que no regresan valores
		
		private long n;
		
		public Parallel(long n) {
			this.n = n;
		}
		
		@Override
		protected Long compute() {
			if(n <= 1) {
				return n;
			}else {
				Parallel fib1 = new Parallel(n-1);
				Parallel fib2 = new Parallel(n-2);
				
				ForkJoinTask.invokeAll(fib1, fib2); 
				
				/*ForkJoinTask es un framework de concurrencia que nos permite paralelizar el 
				algoritmo sin tener que generar los threads*/
			
				return fib1.getRawResult() + fib2.getRawResult();
			}
		}
	}
	
	public static void main(String[] args) {
		
		long[] numbers = {10, 30, 35, 40, 45};
		
		for (int i = 0; i < numbers.length; i++) {
			long number = numbers[i];
			
			/*
			long number = numbers[i];
			long fib = new Sequential().calculate(number);
			System.out.println(fib);*/
			
			/*Como usamos el framework ForkJoin en la clase Parallel debemos usarlo aqui para 
			calcuar nuestros resultados*/
			
			ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
			long fibPar = pool.invoke(new Parallel(number));
			System.out.println(fibPar);
		}
		
	}
}
