
public class RaceCondition {
	
	public static void main(String[] args){
	    for (int i = 0; i < 3; i++){
	      new Race(i).race();
	    }
	  }

	  static class Race {

	    private static final long LIMIT = Integer.MAX_VALUE * 3;

	    private long count = 0;
	    private final String name;

	    private Race(int lap){
	      this.name = "Lap " + lap + ": ";
	    }

	    public void race(){
	    	
	      Thread increase = new Thread() {
	        public void run(){
	          print("Increase started");
	          for (long i = 0; i < LIMIT; i++){
	            count += 1;
	          }
	          print("Increase finised");
	        }
	      };

	      Thread decrease = new Thread() {
	        public void run(){
	          print("Decrease started");
	          for (long i = 0; i < LIMIT; i++){
	            count -= 1;
	          }
	          
	          print("Decrease finised");
	        }
	      };

	      increase.start();
	      decrease.start();

	      try {
	        print("Increase join");
	        increase.join();
	        print("Decrease join");
	        decrease.join();
	      }
	      catch (InterruptedException ex) {
	      }

	      System.out.println(count);
	    }

	    private void print(String message){
	      System.out.println(name + message);
	    }
	   }
}
