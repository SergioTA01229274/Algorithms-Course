
public class FirstParallel {
	
	public static void main(String[] args) {
		
		Thread numbers = new Thread() {
			
			public void run() {
				for(int i = 0;i < 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(100); 
						/*El metodo sleep pausa la ejecucion del thread por ciertos milisegundos 
						para que se ejecute un thread diferente.*/ 
					} catch (InterruptedException e) {
						//Por ahora el interior de esta excepción es despreciable
					}
				}
			}
		};
		
		Thread letters = new Thread() {
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println((char) (i + 64));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						//Por ahora el interior de esta excepción es despreciable
					}
				}
			}
		};
		
		/*
		 numbers.run();
	     La diferencia entre run y start es que run es un metodo estatico cualquiera y
		 start genera el thread real para lograr paralelismo en los algoritmos. 
		*/
		
		numbers.start();
		
		try {
			numbers.join();
		}catch (InterruptedException ex) {
		}
		
		letters.start();
	}

}
