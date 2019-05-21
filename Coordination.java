public class Coordination {
	private volatile boolean ready;
	
	public synchronized void orderFood() {
		System.out.println("Ordering food");
		while(!ready) {
			System.out.println("Waiting for food");
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Food is here");
	}
	
	public synchronized void prepareFood() {
		System.out.println("Preparing food");
		try {
			Thread.sleep(1000);
			ready = true;
			notifyAll();
		} catch (InterruptedException e) {
		}
	}
	public static void main(String[] args) {
		Coordination coordination = new Coordination();
		Thread t1 = new Thread(() -> {
			coordination.orderFood();
		});
		Thread t2 = new Thread(() -> {
			coordination.prepareFood();
		});
		
		t1.start();
		
		t2.start();
	}
}
