package esercizio2;

	import java.util.Arrays;
import java.util.Random;
	public class esercizio2 {

	    public static void main(String[] args) {
	        
	        int[] numbers = new int[3000];
	        Random rand = new Random();
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = rand.nextInt(1000);
	        }
	        
	       
	        Thread t1 = new Thread(new MyThread(numbers, 0, 1000));
	        Thread t2 = new Thread(new MyThread(numbers, 1000, 2000));
	        Thread t3 = new Thread(new MyThread(numbers, 2000, 3000));
	        	    
	        t1.start();	        
	        t2.start();
	        t3.start();
	        
	       
	        try {
	            t1.join();
	            System.out.println(Arrays.toString(MyThread.partialSums));
	            t2.join();
	            System.out.println(Arrays.toString(MyThread.partialSums));
	            t3.join();  
	            System.out.println(Arrays.toString(MyThread.partialSums));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        

	        int sum = 0;
	        for (int i = 0; i < MyThread.partialSums.length; i++) {
	            sum += MyThread.partialSums[i];
	        }
	        System.out.println("La somma di tutti i valori è: " + sum);
	    }
	    
	}