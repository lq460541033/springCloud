package com.cjs.example.price.controller.test.Thread;

public class MyThread  extends Thread {
    public MyThread(String name){
        setName(name);
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println(Thread.currentThread().getName()+": "+i);
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
