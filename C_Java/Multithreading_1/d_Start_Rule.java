/*
This Demo4 code is designed to illustrate a critical rule regarding Java threads:

- CANNOT start() SAME THREAD TWICE: the code attempts to call t1.start() twice on the same thread object
- Expected Outcome: when the code runs, the first t1.start() will begin the thread's execution
        - however the second t1.start() will cause a java.lang.IllegalStateException to be thrown at runtime 
*/

package C_Java.Multithreading_1;
public class d_Start_Rule {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Current thread is " + Thread.currentThread().getName());
        });

        t1.start();
        t1.start();
        //t1.run();
    }
}

// start() or run()
// Can we start() the same thread twice ? --> NO