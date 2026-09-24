package org.heap_thread_dump;

import java.util.ArrayList;
import java.util.List;

public class HeapThreadDumpDemo {

    // Keeping this static means objects stay reachable
    // and will remain in the heap.
    private static final List<Customer> customers = new ArrayList<>();

    private static final Object LOCK = new Object();
    private static final Object WAIT_LOCK = new Object();

    public static void main(String[] args) throws Exception {

        long pid = ProcessHandle.current().pid();

        System.out.println("Application started");
        System.out.println("PID = " + pid);

        createHeapData();
        createThreads();

        System.out.println("Heap data created.");
        System.out.println("Take heap dump and thread dump now.");

        // Keep application alive
        Thread.currentThread().join();
    }

    private static void createHeapData() {

        // Roughly 100+ MB of data
        for (int i = 0; i < 50_000; i++) {

            Customer customer = new Customer(
                    i,
                    "Customer-" + i,
                    "customer" + i + "@example.com",
                    new byte[2048]
            );

            customers.add(customer);
        }

        System.out.println(
                "Customers created = " + customers.size()
        );
    }

    private static void createThreads() {

        // Thread 1 holds LOCK
        Thread lockHolder = new Thread(() -> {

            synchronized (LOCK) {

                System.out.println(
                        "LockHolder acquired LOCK"
                );

                try {
                    Thread.sleep(600_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }, "LockHolderThread");

        // Thread 2 tries to acquire same LOCK
        // It should become BLOCKED.
        Thread blockedThread = new Thread(() -> {

            synchronized (LOCK) {
                System.out.println(
                        "BlockedThread acquired LOCK"
                );
            }

        }, "BlockedThread");

        // Thread 3 stays WAITING
        Thread waitingThread = new Thread(() -> {

            synchronized (WAIT_LOCK) {

                try {
                    WAIT_LOCK.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }, "WaitingThread");

        lockHolder.start();

        // Give LockHolder time to acquire the lock
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        blockedThread.start();
        waitingThread.start();
    }

    static class Customer {

        private final int id;
        private final String name;
        private final String email;

        // Adds some noticeable heap usage
        private final byte[] profileData;

        Customer(
                int id,
                String name,
                String email,
                byte[] profileData) {

            this.id = id;
            this.name = name;
            this.email = email;
            this.profileData = profileData;
        }
    }
}