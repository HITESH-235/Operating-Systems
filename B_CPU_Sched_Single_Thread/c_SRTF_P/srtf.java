// SRTF // Shortest Remaining Time First // Preemtive

package B_CPU_Sched_Single_Thread.c_SRTF_P;
import java.util.*;
public class srtf {

    public static Object[] sjf_Impl(Object[][] processes) {
        Arrays.sort(processes, (a,b)->(Integer)a[0]-(Integer)b[0]);

        int t = 0;
        List<String> gantt = new ArrayList<>();
        Map<String, int[]> table = new LinkedHashMap<>();

        Map<String, Integer> bt_map = new HashMap<>();
        Map<String, Integer> rem_bt_map = new HashMap<>();

        for (Object[] p: processes) {
            bt_map.put((String)p[2], (Integer)p[1]);
            rem_bt_map.put((String)p[2], (Integer)p[1]);
        }

        while (table.size() < processes.length) {
            List<Object[]> available = new ArrayList<>();

            for (Object[] p: processes) {
                int at = (Integer)p[0];
                String pid = (String)p[2];

                if (at <= t && !table.containsKey(pid)) 
                    available.add( new Object[]{ p[0], rem_bt_map.get((String) p[2]), p[2] } );
            }

            if (available.size() == 0) {
                t++;
                gantt.add("idle");
            }
            else {
                available.sort((a,b)-> {
                    int cmp = (Integer) a[1] - (Integer) b[1]; // compare RBT
                    if (cmp != 0) return cmp;
                    return (Integer) a[0] - (Integer) b[0];    // compare AT
                });
                Object[] p = available.get(0);
                int at = (Integer)p[0];
                String pid = (String)p[2];

                gantt.add(pid);
                rem_bt_map.put(pid, rem_bt_map.get(pid)-1);
                t++;

                if (rem_bt_map.get(pid) == 0) { // process completed
                    int ct = t, tat = ct-at, wt = tat-bt_map.get(pid);
                    table.put(pid, new int[]{at, bt_map.get(pid), ct, tat, wt});
                }
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