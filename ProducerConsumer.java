//Sergio Iván Tostado Nieto A01229274
//Edgar Manuel Perez Villa A00344473


import java.util.Random;

public class ProducerConsumer {
	private int container = 0;
	
	public synchronized void PemexProduce() {
		int LtsProduced = new Random().nextInt(6) + 5;
		this.container += LtsProduced;
		
		System.out.println();
		System.out.println("Pemex produced: " + LtsProduced + " Lts");
		System.out.println();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		notifyAll();
	}
	
	public int getContainer() {
		return this.container;
	}
	
	public synchronized void Consume(int LtsExpected, String consumer) {
		try {
			wait();
		} catch (InterruptedException e) {
		}
		
		if(this.container - LtsExpected >= 0) {
			this.container -= LtsExpected; // Consumer got spected quantity of Lts
			System.out.println(consumer + " consumed: " + LtsExpected + " Lts, " + this.getContainer() + " avialables in container.");
		}else {
			LtsExpected -= 1;
			while(this.container - LtsExpected < 0 && LtsExpected != 0) {
				LtsExpected -= 1;
			}
			this.container -= LtsExpected;
			System.out.println(consumer + " consumed: " + LtsExpected + " Lts, " + this.getContainer() + " avialables in container.");
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer PConsumer = new ProducerConsumer();
		
		Thread Producer = new Thread(() -> {
			while(true) {
				PConsumer.PemexProduce(); 
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		Thread PemexConsumer = new Thread(() -> {
			String name1 = "Pemex";
			while(true) {
				PConsumer.Consume(2, name1);
			}
		});
		Thread OxxoGasConsumer = new Thread(() -> {
			String name2 = "Oxxo";
			while(true) {
				PConsumer.Consume(2, name2);
			}
		});
		Thread Petro7Consumer = new Thread(() -> {
			String name3 = "Petro7";
			while(true) {
				PConsumer.Consume(2, name3);
			}
			

		});
		Thread BlueCorporation = new Thread(() -> {
			String name4 = "BlueCorp";
			while(true) {
				PConsumer.Consume(3, name4);
			}
		});
		
		
		PemexConsumer.start();
		OxxoGasConsumer.start();
		Petro7Consumer.start();
		BlueCorporation.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}
		Producer.start();
	}
}
