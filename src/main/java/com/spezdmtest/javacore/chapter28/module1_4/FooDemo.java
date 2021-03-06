package com.spezdmtest.javacore.chapter28.module1_4;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class FooDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Foo foo = new Foo();
        CompletableFuture<Void> printFirst = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(this::run);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> printSecond = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(this::run);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> printThird = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(this::run);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        printFirst.get();
        printSecond.get();
        printThird.get();
    }
}
class Foo {
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public Foo() {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);

        try {
            semaphore1.acquire();
            semaphore2.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void first(Runnable r) throws InterruptedException {
        print("first");
        semaphore1.release();
    }

    void second(Runnable r) throws InterruptedException {
        semaphore1.acquire();
        print("second");
        semaphore2.release();
    }

    void third(Runnable r) throws InterruptedException {
        semaphore2.acquire();
        print("third");
    }
    private void print(String str) {
        System.out.print(str);
    }
}

