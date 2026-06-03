// SJF // Shortest Job First Scheduling Algorithm // Non-Preemptive

package B_CPU_Sched_Single_Thread.b_SJF_NP;
import java.util.*;
public class sjf {

    public static Object[] sjf_Impl(Object[][] processes) {
        Arrays.sort(processes, (a,b)->(Integer)a[0]-(Integer)b[0]);

        int t = 0;
        List<String> gantt = new ArrayList<>();
        Map<String, int[]> table = new LinkedHashMap<>();

        while (table.size() < processes.length) {
            List<Object[]> available = new ArrayList<>();

            for (Object[] process: processes) {
                int at = (Integer)process[0];
                String pid = (String)process[2];
                if (at <= t && !table.containsKey(pid)) available.add(process);
            }

            if (available.size() == 0) {
                t++;
                gantt.add("idle");
            }
            else {
                available.sort((a,b)->(Integer)a[1]-(Integer)b[1]);
                Object[] process = available.get(0);
                int at = (Integer)process[0], bt = (Integer)process[1];
                String pid = (String)process[2];

                t += bt;
                gantt.add(pid);
                int ct = t, tat = ct-at, wt = tat-bt;
                table.put(pid, new int[]{at, bt, ct, tat, wt});
            }
        }
        return new Object[]{gantt, table};
    }

    public static void main(String[] args) {
        Object[][] processes = {{1,3,"P1"}, {2,4,"P2"}, {1,2,"P3"}, {4,4,"P4"}};
        Object[] res = sjf_Impl(processes);
        
        @SuppressWarnings("unchecked")
        List<String> gantt = (List<String>) res[0];
        @SuppressWarnings("unchecked")
        Map<String, int[]> table = (Map<String, int[]>) res[1];

        System.out.println("Gantt Chart: " + gantt.toString());
        System.out.println("\nPID AT BT CT TAT WT");

        for (String pid: table.keySet()) {
            System.out.print(pid + " ");
            int[] temp = table.get(pid);
            System.out.println(Arrays.toString(temp));
        }
    }
}