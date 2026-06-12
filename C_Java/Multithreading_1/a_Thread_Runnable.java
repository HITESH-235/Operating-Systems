/*
What is a Thread ?
- the atomic-level, light-weight, process, independent path of execution within a program
- each thread has its own call stack, program counter, and local variables, though shares the heap with other threads

Java.lang.Thread:
- the primary "class" for creating and managing threads in java
- threads are typically created by extending this class and overriding its run() method to define the thread's task

java.lang.Runnable (interface): 
- a functional "interface" defining a single run() method
- provides and alternative, often preferred way to define a thread's task
- allows a class to define a thread's behaviour without inheriting from thread thus enabling
- a Runnable instance is passed to a thread's contructor

start() Method:
- purpose: initiates the execution of a thread
- behaviour: creates a new thread and then invokes the thread's run() method in this newly created thread
- key point: enables concurrent execution, calling it more than once on the same thread will throw error

run() Method:
- purpose: Contains the actual code that the thread will execute 
- behaviour: when start() is called, the JVM directs the new thread to begin execution from this method
- key point: calling run() directly (e.g. myThread.run()) executes the code within the current thread and not a new one

Relationship Summary:
- we define the task for a thread either by extending Thread and overriding run()
- then create a thread object; if using runnable pass the Runnable instance to the Thread Constructor
- finally call start() method on the thread obj, to begin its concurrent execution, which calls the run() method

Different Ways to Create Threads in Java

We create a class that extends Thread and override its run() method, to define the task
then we make an object of this class and call start()
which automatically calls the run() and begins the thread's execution
*/

package C_Java.Multithreading_1;

public class a_Thread_Runnable {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

// java.lang.Thread implements java.lang.Runnable
// thus thread class itself has the run() method to be overriden

// 1.Runnable (Interface): It is defined as the sole abstract method in the java.
// lang.Runnable  interface:

//      public interface Runnable {
//          public abstract void run();
//      }

// 2.Thread (Class): The Thread class implements the  Runnable  interface and
// therefore provides its own implementation of the run() method:

//      public class Thread implements Runnable {
//          @Override
//          public void run() {
//             // ...
//          }
//      }