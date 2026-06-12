/*
Thread Creation using a Lambda Expression:

- in first part, a thread was defined by extending the Thread Class directly (class MyThread extends Thread)
- in demo2, (here), the main method creates a thread by passing a lambda expression
- this lambda expression is an inline concise implementation of the Runnable functional interfce's run() method
- it means you are providing the code to be run by the new thread directly at the point of Thread instantiation,
  without needing a separate named class (like MyThread or MyRunnable) or even an anonymous inner class
*/

package C_Java.Multithreading_1;
public class b_Lambda {
    public static void main(String[] args) {
        // Thread t1 = new MyRunnable();
        Thread t1 = new Thread(() -> System.out.println("Thread is Running")); // lambda exp
        t1.start();
    }
}

// Thread using runnable interface, which is commented above
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}