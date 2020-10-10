package com.smilepy.javadance.designpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author peiyu
 */
class ProduceAndConsume {
    public volatile boolean flag=true;
    public static AtomicInteger atomicInteger=new AtomicInteger();
    public static final int MAX_COUNT=10;
    public static final List<Integer> pool=new ArrayList<>();

    public void produce(){
        while(flag){
            synchronized(pool){
                while(pool.size()==MAX_COUNT){
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                pool.add(atomicInteger.incrementAndGet());
                System.out.println("produce number:" + atomicInteger.get() + "\t" + "current size of pool:" + pool.size());
                pool.notifyAll();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume(){
        while(flag){
            synchronized(pool){
                while(pool.size()==0){
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer curInteger=pool.remove(0);
                System.out.println("consume number:" + curInteger + "\t" + "current size of pool:" + pool.size());
                pool.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        flag=false;
    }
}

public class ProducerAndConsumer{
    public static void main(String[] agrs){
        ProduceAndConsume produceAndConsume=new ProduceAndConsume();
        new Thread(()->{produceAndConsume.produce();},"A").start();
        new Thread(()->{produceAndConsume.produce();},"B").start();
        new Thread(()->{produceAndConsume.consume();},"C").start();
        new Thread(()->{produceAndConsume.consume();},"D").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        produceAndConsume.stop();
    }
}
