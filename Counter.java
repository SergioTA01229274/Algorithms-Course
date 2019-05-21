
public class Counter {
	
	private int count;
	private int count2;
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	public void increment() { 
		//La palabra reservada synchronized ocaciona que solo un thread a la vez pueda acceder a un metodo
		synchronized(lock1) { 
			this.count++;
		}
	}
	
	public void decrement() {
		synchronized(lock1) { 
			this.count--;
		}
	}
	
	public synchronized int getCount() {
		synchronized(lock1) { 
			return this.count;
		}
	}
	public void increment2() { 
		synchronized(lock2) { 
			this.count2++;
		}
	}
	
	public void decrement2() {
		synchronized(lock2) { 
			this.count2--;
		}
	}
	
	public int getCount2() {
		synchronized(lock2) { 
			return this.count2;
		}
	}
	
	public void race(){
		long limit = Integer.MAX_VALUE / 10;
		
		Thread increase = new Thread() {
			public void run(){
				for (long i = 0; i < limit; i++){
					increment();
				}
		    }
		};
		
	    Thread decrease = new Thread() {
	    	public void run(){
	    		for (long i = 0; i < limit; i++){
	    			increment2();
	    		}
	    	}
	    };

	    
	    increase.start();
	    decrease.start();
	    

	    try {
	    	increase.join();
	        decrease.join();
	    }
	    catch (InterruptedException ex) {
	    }
	    
	    System.out.println("Counter: " + this.getCount() + " Counter2: " + this.getCount2());
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Counter().race();
		}
	}
}
