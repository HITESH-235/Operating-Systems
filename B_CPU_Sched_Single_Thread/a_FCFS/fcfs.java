// SJF // Shortest Job First Scheduling Algorithm // Non-Preemptive
// process: [AT, BT, pID]

package B_CPU_Sched_Single_Thread.a_FCFS;
import java.util.*;
public class fcfs {

    public static Object[] fcfs_Impl(Object[][] processes) {
        // Sort the process by arrival time
        Arrays.sort(processes, (a,b)->((Integer)a[0]-(Integer)b[0]));
        int i = 0;

        // Initialise all variables
        int t = 0;
        List<String> gantt = new ArrayList<>();
        Map<String, int[]> table = new HashMap<>();

        while (i < processes.length) {
            int at = (Integer)processes[i][0];
            int bt = (Integer)processes[i][1];
            String pid = (String)processes[i][2];

            if (at > t) {
                t++;
                gantt.add("idle");
                continue;
            }

            gantt.add(pid);
            t += bt;
            int ct = t, tat = ct-at, wt = tat-bt;
            table.put(pid, new int[]{at, bt, ct, tat, wt});
            i++;
        }
        return new Object[]{gantt, table};
    }

    public static void main(String[] args) {
        Object[][] processes = {{0,5,"P1"}, {1,3,"P2"}, {2,8,"P3"}, {3,6,"P4"}};
        Object[] res = fcfs_Impl(processes);
        
        @SuppressWarnings("unchecked")
        List<String> gantt = (List<String>) res[0];
        @SuppressWarnings("unchecked")
        Map<String, int[]> table = (Map<String, int[]>) res[1];

        System.out.println("Gantt Chart: " + gantt.toString());
        System.out.println("\nPID AT BT CT TAT AT");

        for (String pid: table.keySet()) {
            System.out.print(pid + " ");
            int[] temp = table.get(pid);
            System.out.println(Arrays.toString(temp));
        }
    }
}