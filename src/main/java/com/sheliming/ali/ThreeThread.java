package com.sheliming.ali;

public class ThreeThread {
    private static Boolean flagA = true;
    private static Boolean flagB = false;
    private static Boolean flagC = false;

    public static void main(String[] args) {
        final Object lock = new Object();

        //打印A线程
        Thread aThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    synchronized (lock) {
                        if (flagA) {
                            System.out.print("A");
                            flagA = false;
                            flagB = true;
                            flagC = false;
                            lock.notifyAll();
                            i++;
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread bThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    synchronized (lock) {
                        if (flagB) {
                            System.out.print("B");
                            flagA = false;
                            flagB = false;
                            flagC = true;
                            lock.notifyAll();
                            i++;
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });


        Thread cThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; ) {
                    synchronized (lock) {
                        if (flagC) {
                            System.out.print("C");
                            flagA = true;
                            flagB = false;
                            flagC = false;
                            lock.notifyAll();
                            i++;
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        cThread.start();
        bThread.start();
        aThread.start();
    }
}
