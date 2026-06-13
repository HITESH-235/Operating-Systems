/*
Yield Method: A static method which when called for Thread class itself;
- is a hint to the thread scheduler that the current thread is willing to voluntarily release its use of the processor
- and allow other threads/thread to run
- it doesn't guarantee that another thread will be scheduled immediately, as its just a suggestion to the schedular

Schedular Behaviour:
- when yeild is called, the thread transitions from Running to Runnable, meaning it doesn't enter a waiting/blocked state like sleep or join
- puts the current thread back to pool of threads that are eligible 
*/


package C_Java.Multithreading_2;
public class c_Yield_Method {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i=1; i<=10; i++) {
                System.out.println("T1 : "+i);
                Thread.yield();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=1; i<=10; i++) {
                System.out.println("T2 : "+i);
            }
        });

        t1.start();
        t2.start();
    }
}
