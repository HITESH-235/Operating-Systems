// Thread.sleep(2000); in the main method, causes the main thread to temporarily enter the TIMED_WAITING state for 2 seconds 
// This isn't explicitly printed for the main thread's state, but it's an implicit state change

package C_Java.Multithreading_2;
public class a_Timed_Waiting {
    public static void main(String[] args) {
        // Sleep()
        System.out.println("Main thread starts");

        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {}

        System.out.println("Main thread ends");
    }
}

// Thread important methods
/*
 Thread.sleep(milliseconds) -> TIMED_WAITING
 RUNNABLE --> TIMED_WAITING --> RUNNABLE
*/