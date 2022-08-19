package com.fccpd.thread;

public class ThreadA {
    public static void main(String[] args) throws InterruptedException {

        runThread();

        System.out.println("Hello main");
    }

    private static void runThread() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {

                sleep(1000);

                System.out.println("Hello Thread");
            }

            private void sleep(int time) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
