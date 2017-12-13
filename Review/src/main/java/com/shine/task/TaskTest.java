package com.shine.task;

import java.util.concurrent.*;

public class TaskTest {

    public void threadStart() {
        Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run run run !~");
            }
        }, 0, 10, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {

    }
}
