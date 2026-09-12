package org.citykarat_new.oddeventhreads;

public class OddEvenArrayPrinterTest {

    public static void main(String[] args) throws InterruptedException {
        /*
         * This is intentionally a manual-output exercise because interviewers
         * commonly ask you to write and explain the thread coordination live.
         *
         * Expected order:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         */
        OddEvenArrayPrinter printer =
                new OddEvenArrayPrinter(new int[]{1, 2, 3, 4, 5, 6});

        printer.printInOriginalOrder();
    }
}
