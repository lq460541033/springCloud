package com.cjs.example.price.controller.test.Thread;

public class TestJoin {

    public static void main(String[] args)
    {
        Thread t1 = new MyThread("线程1");
        Thread t2 = new MyThread("线程2");
        Thread t3 = new MyThread("线程3");

        try
        {
            //t1先启动
            t1.start();
            t1.join();
            //t2
            t2.start();
            t2.join();
            //t3
            t3.start();
            t3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
