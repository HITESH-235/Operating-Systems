/*
Interrupt() Method (Non Static)
- since non static, applies for a particular thread with the reference
- sends a signal to t1 thread that it should stop doing what it is doing

isInterrupted() Method:
- checks the thread's internal interrupted status flag
- return true/false if the thread has been interrupted/ not interrupted

interrupted() Method:
- check the thread's interrupted status flag (T/F)
- as well as sets the this status flag to False*
*/ 

package C_Java.Multithreading_2;
public class d_Interrupt_Meth {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (Thread.currentThread().isInterrupted()) { // writing "true" instead makes interrupt unable to stop here
                System.out.println("Running");
            }
        });

        t1.start();

        // put the main thread to sleep before interrupting, hence the above print statement executes for 2 seconds
        Thread.sleep(2000); 
        
        t1.interrupt(); // after 2 sec t1 stops
    }
}
