package com.cjs.example.price.controller.test.Thread;


import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3); //缓冲区允许放3个数据

        for(int i = 0; i < 2; i ++) {
            new Thread() { //开启两个线程不停的往缓冲区存数据

                @Override
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep((long) (Math.random()*1000));
                            System.out.println(Thread.currentThread().getName() + "准备放数据"
                                    + (queue.size() == 3?"..队列已满，正在等待":"..."));
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName() + "存入数据，"
                                    + "队列目前有" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            }.start();
        }

        new Thread() { //开启一个线程不停的从缓冲区取数据

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "准备取数据"
                                + (queue.size() == 0?"..队列已空，正在等待":"..."));
                        queue.take();
                        System.out.println(Thread.currentThread().getName() + "取出数据，"
                                + "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}
