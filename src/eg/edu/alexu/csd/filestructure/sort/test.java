package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main (String[] args){
        /** testing the different runtime performance between sorting
         * methods
         */
        Sort sort = new Sort();
        ArrayList ordered = new ArrayList();
        Random rInt = new Random();
        //Small Array length n = 100
        ArrayList trial1 = new ArrayList();
        for(int j = 0; j < 100; j++) {
            int val = rInt.nextInt(2147483647);
            trial1.add(val);
        }
        ordered = trial1;
        long slowStart1 = System.nanoTime();
        sort.sortSlow(ordered);
        long slowEnd1 = System.nanoTime();
        long slowTime1 = slowEnd1-slowStart1;

        ordered = trial1;
        long fastStart1 = System.nanoTime();
        sort.sortFast(ordered);
        long fastEnd1 = System.nanoTime();
        long fastTime1 = fastEnd1-fastStart1;

        ordered = trial1;
        long heapStart1 = System.nanoTime();
        sort.heapSort(ordered);
        long heapEnd1 = System.nanoTime();
        long heapTime1 = heapEnd1-heapStart1;

        System.out.println("\nN = 100: \nSlow: " + slowTime1+"\nFast: "+fastTime1+"\nHeap: "+heapTime1);

        //Small Array length n = 1000
        ArrayList trial2 = new ArrayList();
        for(int j = 0; j < 1000; j++) {
            int val = rInt.nextInt(2147483647);
            trial2.add(val);
        }
        ordered = trial2;
        long slowStart2 = System.nanoTime();
        sort.sortSlow(ordered);
        long slowEnd2 = System.nanoTime();
        long slowTime2 = slowEnd2-slowStart2;

        ordered = trial2;
        long fastStart2 = System.nanoTime();
        sort.sortFast(ordered);
        long fastEnd2 = System.nanoTime();
        long fastTime2 = fastEnd2-fastStart2;

        ordered = trial2;
        long heapStart2 = System.nanoTime();
        sort.heapSort(ordered);
        long heapEnd2 = System.nanoTime();
        long heapTime2 = heapEnd2-heapStart2;

        System.out.println("\nN = 1,000: \nSlow: " + slowTime2+"\nFast: "+fastTime2+"\nHeap: "+heapTime2);

        //Small Array length n = 100000
        ArrayList trial3 = new ArrayList();
        for(int j = 0; j < 100000; j++) {
            int val = rInt.nextInt(2147483647);
            trial3.add(val);
        }
        ordered = trial3;
        long slowStart3 = System.nanoTime();
        sort.sortSlow(ordered);
        long slowEnd3 = System.nanoTime();
        long slowTime3 = slowEnd3-slowStart3;

        ordered = trial3;
        long fastStart3 = System.nanoTime();
        sort.sortFast(ordered);
        long fastEnd3 = System.nanoTime();
        long fastTime3 = fastEnd3-fastStart3;

        ordered = trial3;
        long heapStart3 = System.nanoTime();
        sort.heapSort(ordered);
        long heapEnd3 = System.nanoTime();
        long heapTime3 = heapEnd3-heapStart3;

        System.out.println("\nN = 100,000: \nSlow: " + slowTime3+"\nFast: "+fastTime3+"\nHeap: "+heapTime3);



    }
}
