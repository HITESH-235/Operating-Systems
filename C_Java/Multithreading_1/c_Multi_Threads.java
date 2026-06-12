/*
This code primarily demonstrates how to identify and differentiate individual threads withing a multi threaded app

1. Retrieving Current Thread Information:
- it uses Thread.currentThread() to get a reference* to the thread that is currently executing the code 
- getName() is called to retrieve the thread's name (e.g. main, Thread-0, Thread-1)
- and the getId() is called to retrieve the thread's unique identifier (deprecated)

2. Identification of Main Thread:
- the first two println statements in the main thread will output the name and ID of main thread
  (which is the thread that starts the java application)*
*/

package C_Java.Multithreading_1;
public class c_Multi_Threads {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getId()); // since getId is deprecated this will be marked yellow

        Thread t1 = new Thread(() -> {
            System.out.println("Name of my thread is " + Thread.currentThread().getName());
            // System.out.println("Id of my thread is " + Thread.currentThread().getId());
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Name of my 2nd thread is " + Thread.currentThread().getName());
            // System.out.println("Id of my 2nd thread is " + Thread.currentThread().getId());
        });

        t1.start();
        t2.start();
    }
}