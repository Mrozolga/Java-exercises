package com.company;

import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Mean {
    static double[] array;
    static void initArray(int size){
        array = new double[size];
        for(int i=0;i<size;i++){
            array[i]= Math.random()*size/(i+1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        initArray(128000000);
        for(int cnt:new int[]{1,2,4,8,16,32,64,128}){
            parallelMean(cnt);
        }
    }

    static class MeanCalc extends Thread{
        private final int start;
        private final int end;
        double mean = 0;

        MeanCalc(int start, int end){
            this.start = start;
            this.end=end;
        }
        public void run(){
            double suma=0;
            for (int i=start; i<end;i++)
            {
                suma=suma+array[i];
            }
            mean=suma/(end-start);
            try {
                results.put(mean);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(Locale.US,"%d-%d mean=%f\n",start,end,mean);
        }

    }
    static void parallelMean(int cnt) throws InterruptedException {
        // utwórz tablicę wątków
        MeanCalc threads[]=new MeanCalc[cnt];
        int l = array.length;
        int ile = l/cnt;
        for (int i=0; i<cnt; i++)
        {
            threads[i]= new MeanCalc(i*ile,(i+1)*ile);
        }
        double t1 = System.nanoTime()/1e6;
        for(MeanCalc mc:threads) {
            mc.start();
        }

        double t2 = System.nanoTime()/1e6;
        // czekaj na ich zakończenie używając metody ''join''
        //for(MeanCalc mc:threads) {
            //mc.join();

        //}
        double mean=0;
        for(MeanCalc mc:threads) {
            mean+=results.take();
        }
        double t3 = System.nanoTime()/1e6;
        System.out.printf(Locale.US,"size = %d cnt=%d >  t2-t1=%f t3-t1=%f mean=%f\n",
                array.length,
                cnt,
                t2-t1,
                t3-t1,
                mean);
    }
    static BlockingQueue<Double> results = new ArrayBlockingQueue<Double>(100);
}

