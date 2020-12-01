package com.cjs.example.price.controller.test.Thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JoinTest2 {
    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        //创建3个写线程
        for (int i=0;i<3;i++){
            ThreadWrite write = new ThreadWrite(readWrite,new Random().nextInt(100));
            write.setName("write"+i+":");
            write.start();
        }
        //创建3个读线程
        for (int i=0;i<3;i++){
            ThreadRead read = new ThreadRead(readWrite);
            read.setName("read"+i+":");
            read.start();
        }

    }
}

class ReadWrite{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Object data=null;
    public void read(){
        try{
            lock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"is ready to read");
                Thread.sleep(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName()+"have read date "+data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally{
            lock.readLock().unlock();
        }
    }

    public void write(Object data){
        try{
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName()+"is ready to write");
                this.data = data;
                Thread.sleep(new Random().nextInt(100));
                System.out.println(Thread.currentThread().getName()+"have write date "+data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally{
            lock.writeLock().unlock();
        }
    }
}

class ThreadRead extends Thread{
    private ReadWrite readWrite;

    public ThreadRead(ReadWrite readWrite){
        this.readWrite = readWrite;
    }

    @Override
    public void run() {
        super.run();
        //while(true){
        readWrite.read();
        //}

    }
}

class ThreadWrite extends Thread{
    private ReadWrite readWrite;
    private Object data;


    public ThreadWrite(ReadWrite readWrite,Object data){
        this.readWrite = readWrite;
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        //while(true){
        readWrite.write(data);
        //}
    }
}
