package C_Java.Multithreading_2;
public class f_Thread_Name {
    public void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        t1.setName("Worker-1"); // default name is set like "Thread-0", "Thread-1"
        t1.start();
    }
}