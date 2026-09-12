package org.citykarat_new.oddeventhreads;

import java.util.concurrent.Semaphore;

public class OddEvenArrayPrinter {

    private final int[] numbers;
    private final Object lock = new Object();
    private int index = 0;

    public OddEvenArrayPrinter(int[] numbers) {
        this.numbers = numbers;
    }

    public void printInOriginalOrder() throws InterruptedException {
        Thread oddThread = new Thread(() -> printOddNumbers1(), "odd-thread");
        Thread evenThread = new Thread(() -> printEvenNumbers1(), "even-thread");

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }







    private void printOddNumbers1(){
        while(index< numbers.length) {
            synchronized (lock) {
                if(index < numbers.length && numbers[index]/2 !=0 ){
                    System.out.println(numbers[index]);
                    index++;
                    lock.notifyAll();
                } else {
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

        }
    }

    private void printEvenNumbers1(){
        while(index< numbers.length) {
            synchronized (lock) {
                if(index < numbers.length && numbers[index]/2 ==0) {
                    System.out.println(numbers[index]);
                    index++;
                    lock.notifyAll();
                } else {
                    try{
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }







    private void printOddNumbers() {
        while (index < numbers.length) {
            synchronized (lock) {
                if (index < numbers.length && isOdd(numbers[index])) {
                    System.out.println(numbers[index]);
                    index++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }

    private void printEvenNumbers() {
        while (index < numbers.length) {
            synchronized (lock) {
                if (index < numbers.length && !isOdd(numbers[index])) {
                    System.out.println(numbers[index]);
                    index++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }
    }


    /*
     * TASK:
     * Use exactly two worker threads:
     *
     * Odd thread:
     *      prints odd numbers
     *
     * Even thread:
     *      prints even numbers
     *
     * Requirement:
     * Output must preserve the original array order.
     *
     * Example:
     * input  = {1, 2, 3, 4, 5, 6}
     * output = 1 2 3 4 5 6
     *
     * Thread ownership:
     * 1,3,5 -> odd thread
     * 2,4,6 -> even thread
     *
     * Do not solve by using one thread to print everything.
     *
     * Be prepared to explain:
     * - shared index
     * - synchronized
     * - wait()
     * - notify()/notifyAll()
     * - why wait is normally checked in a while loop
     * - what happens if the even thread starts first
     */

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /*
     * OPTIONAL IMPROVEMENT:
     * Implement the same behavior using ReentrantLock + Condition
     * or Semaphore.
     */
    public void printUsingAlternativeSynchronization() throws InterruptedException {
        Semaphore oddSemaphore = new Semaphore(0);
        Semaphore evenSemaphore = new Semaphore(0);
        int[] index = {0};

        if (numbers.length == 0) {
            return;
        }

        if (isOdd(numbers[0])) {
            oddSemaphore.release();
        } else {
            evenSemaphore.release();
        }

        Thread oddThread = new Thread(() ->
                printByParityUsingSemaphore(index, true, oddSemaphore, evenSemaphore), "odd-thread");

        Thread evenThread = new Thread(() ->
                printByParityUsingSemaphore(index, false, evenSemaphore, oddSemaphore), "even-thread");

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }

    private void printByParityUsingSemaphore(
            int[] index,
            boolean oddThread,
            Semaphore currentSemaphore,
            Semaphore otherSemaphore
    ) {
        while (true) {
            try {
                currentSemaphore.acquire();

                if (index[0] >= numbers.length) {
                    otherSemaphore.release();
                    return;
                }

                if (isOdd(numbers[index[0]]) == oddThread) {
                    System.out.println(numbers[index[0]]);
                    index[0]++;
                }

                if (index[0] >= numbers.length) {
                    otherSemaphore.release();
                    return;
                }

                if (isOdd(numbers[index[0]]) == oddThread) {
                    currentSemaphore.release();
                } else {
                    otherSemaphore.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                otherSemaphore.release();
                return;
            }
        }
    }

    public int[] getNumbers() {
        return numbers;
    }
}
