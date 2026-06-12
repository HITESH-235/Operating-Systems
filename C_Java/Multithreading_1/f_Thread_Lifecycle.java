/*
Thread Lifecycle: 

1. NEW state:
- sout(t1.getState()): (before .start()) will print NEW
- because the t1 thread has been created, but its start() has not been invoked

2. RUNNABLE state: 
- t1.start() transitions the thread from NEW to RUNNABLE
- sout(t1.getState()) (after .start()) will print runnable
- a thread in the runnable state is either executing or waiting for a processor to execute it
- it is redy to run and manaed by the JVM's scheduler

3. TIMED WAITING state:
- thread.sleep(2000): in the main method, the main thread enters waiting state with this
- it isn't explicitly printed, this takes place implicitly

4. TERMINATED state:
- After t1's lambda finishes executing, the thread has completed its task
- sout(t1.getState()): (after sleep of main): will print terminated
- a thread in this state has completed its execution and cannot be restarted
*/

package C_Java.Multithreading_1;

public class f_Thread_Lifecycle {
    public static void main(String[] args) {
           // Thread new stage

           Thread mainThread = Thread.currentThread();

           Thread t1 = new Thread(() -> {
               System.out.println("Name of current thread is " +
   Thread.currentThread().getName());
               System.out.println("Main thread state " +
   mainThread.getState());
           });
           System.out.println(t1.getState());

           // Runnable stage
           t1.start();

           System.out.println(t1.getState()); // RUNNABLE

           try {
               Thread.sleep(2000);
           }
           catch(Exception e) {}

           System.out.println(t1.getState()); // TERMINATED

       }
}
