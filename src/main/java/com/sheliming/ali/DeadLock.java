package com.sheliming.ali;

public class DeadLock {
    public static String s1 = "s1";
    public static String s2 = "s2";

    public static void main(String[] args) {
        Thread t1 = new Thread(new Lock1());
        Thread t2 = new Thread(new Lock2());
        t1.start();
        t2.start();
    }

    static class Lock1 implements Runnable {

        public void run() {
            synchronized (s1) {
                System.out.println("获得s1，等s2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s2) {
                    System.out.println("完成");
                }
            }
        }
    }

    static class Lock2 implements Runnable {

        public void run() {
            synchronized (s2) {
                System.out.println("获得s2，等s1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1) {
                    System.out.println("完成");
                }
            }
        }
    }
}
