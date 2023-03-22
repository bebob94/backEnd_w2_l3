package esercizio2;

import java.util.Arrays;

public class MyThread implements Runnable {
        private int[] numbers;
        private int start;
        private int end;	        
   
        public static int[] partialSums = new int[3];
        
        public MyThread(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }	        
        @Override
        public void run() {
     
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
//            synchronized(partialSums) {
             switch (start) {
                case 0:
                    partialSums[0] = sum;
                    break;
                case 1000:
                    partialSums[1] = sum;
                    break;
                case 2000:
                    partialSums[2] = sum;
                    break;
                }
//            }	
            
        }	           
    }

