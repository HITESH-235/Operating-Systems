/*
isAlive()
- checks whether a thread has been started and has not yet terminated
- it returns true/false
- for new state => false, for runnable, blocked, waiting, timed_waiting => true
- terminated => false
*/

package C_Java.Multithreading_2;
public class e_isAlive_Meth {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            }
            catch(Exception e) {}
        });

        System.out.print(t1.isAlive()); // false

        t1.start();

        System.out.print(t1.isAlive()); // true

        try { // when main thread sleeps for 3 sec, t1 finishes its task of sleeping 2 sec and terminates
            Thread.sleep(3000);
        }
        catch (Exception e) {}

        System.out.print(t1.isAlive()); // false
    }
}