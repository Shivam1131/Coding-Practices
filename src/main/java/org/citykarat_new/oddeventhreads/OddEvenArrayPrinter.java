package org.citykarat_new.oddeventhreads;

public class OddEvenArrayPrinter {

    private final int[] numbers;

    public OddEvenArrayPrinter(int[] numbers) {
        this.numbers = numbers;
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
    public void printInOriginalOrder() throws InterruptedException {
        throw new UnsupportedOperationException("TODO: implement printInOriginalOrder");
    }

    /*
     * OPTIONAL IMPROVEMENT:
     * Implement the same behavior using ReentrantLock + Condition
     * or Semaphore.
     */
    public void printUsingAlternativeSynchronization() throws InterruptedException {
        throw new UnsupportedOperationException(
                "TODO: implement alternative synchronization version");
    }

    public int[] getNumbers() {
        return numbers;
    }
}
