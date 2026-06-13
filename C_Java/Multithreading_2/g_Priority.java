/*
Priority of Threads

- max priority: 10
- min priority: 1
- norm priority: 5 (set by default for any thread)

- the execution of processes depends completely on OS
- so the OS may or may not respect priority (or not at all)
*/

package C_Java.Multithreading_2;
public class g_Priority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Custom-1 Thread is Running");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Custom-2 Thread is Running");
        });

        t1.start();
        t2.start();
        t1.setPriority(10);

        System.out.println("T1's priority " + t1.getPriority());
        System.out.println("T2's priority " + t2.getPriority());
    }
}