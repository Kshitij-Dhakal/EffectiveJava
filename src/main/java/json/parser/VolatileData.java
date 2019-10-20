/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.parser;

/**
 *
 * @author dhaka
 */
public class VolatileData {

    public static class Counter {

        int counter = 10;

        public int getCounter() {
            return counter;
        }

        public void decrement() {
            --counter;
        }

    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (counter) {
                    try {
                        counter.wait();
                    } catch (InterruptedException ex) {
                    }
                    System.out.println("Wait Complted");
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (counter) {
                    while (counter.getCounter() != 0) {
                        counter.decrement();
                        try {
                            System.out.println("Decrement Counter");
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                        }
                    }
                    counter.notify();
                }
            }

        };
        t1.start();
        t2.start();
    }
}
