/*
this code shows the concepts of Non-Deterministic Execution Order in multi threading programming

Concurrent Execution of Independent Tasks:
- t1 is tasked with iterating from 1 to 100 and printing only the even nums, prefixed with "T1 :"
- t2 is tasked with iterating from 1 to 100 and printing only the odd numbers, prefixed with "T2 :"
- both t1.start() and t2.start() are called, initiating these two tasks to run concurrently

Non-Deterministic in Output:
- because the operating system and JVM scheduler decide when each thread gets CPU time, the exact order in which t1 and t2 print their numbers is unpredictable
- the order changes with each execution of the program
*/

package C_Java.Multithreading_1;
public class e_Non_Determ_EO {
    public static void main(String[] args) {
           // 1 to 100 (even numbers)
           Thread t1 = new Thread(() -> {
               for(int i=1; i<=100; i++) {
                   if(i % 2 == 0) {
                       System.out.println("T1 : " + i);
                   }
               }
           });


           // 1 to 100 (odd numbers)
           Thread t2 = new Thread(() -> {
               for(int i=1; i<=100; i++) {
                   if(i % 2 != 0) {
                       System.out.println("T2 : " + i);
                   }
               }
           });


           t1.start();
           t2.start();
       }
}
