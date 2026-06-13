
package C_Java.Multithreading_2;
public class b_Join_Method {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts"); // executed first by main thread

        Thread t1 = new Thread(() -> { // new thread created
            try { // t1's task is to sleep for 2 sec and then just print "thread-0" 
                Thread.sleep(2000);
            }
            catch(InterruptedException e) {}
            System.out.println("Thread-0 starts");
        });

        t1.start(); // begins the execution of t2 parallel with main thread
        
        t1.join(1000); // tells to main "let the t1 thread complete but for 1 sec"
        
        System.out.println("Main thread ends");
    }
}

/*
After observing the code above read this:
t1.join(1 sec) tells the main thread to wait for t1 to finish but for max 1 sec
after that 1 sec, t1 gets terminated whether completed or not
and main method continues execution again

and this exactly happens as t1 waits 2 sec before executing the print as its task
which exceeds the 1 sec limit set by join(), hence t1 terminates before completing its task
*/


// join()
/*
Main thread --> WAITING
t1 thread --> RUNNABLE --> TERMINATED
Main thread --> WAITING -> RUNNABLE --> TERMINATED
*/