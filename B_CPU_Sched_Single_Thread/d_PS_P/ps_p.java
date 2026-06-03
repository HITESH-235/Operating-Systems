// Priority Scheduling // Preemptive Algorithm
// Process: [Priority, AT, BT, pid]

package B_CPU_Sched_Single_Thread.d_PS_P;
import java.util.*;
public class ps_p {

    public static Object[] priority(Object[][] processes) {
        int t = 0;
        List<String> gantt = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();

        Map<String, Integer> rem_bt = new HashMap<>();
        for (Object[] p: processes) rem_bt.put((String) p[3], (Integer) p[2]);

        while (table.size() < processes.length) {
            List<Object[]> available = new ArrayList<>();

            for (Object[] p: processes) {
                if ((Integer) p[1] <= t && !table.containsKey((String) p[3])) available.add(p);
            }

            if (available.size() == 0) {
                t++;
                gantt.add("idle");
            }
            else {
                available.sort((a,b) -> {
                    int diff = (Integer) b[0] - (Integer) a[0];
                    if (diff != 0) return diff;
                    return (Integer) a[1] - (Integer) b[1];
                });
                Object[] p = available.get(0);
                
                t++;
                String pid = (String) p[3];
                gantt.add(pid);                
                rem_bt.put(pid, rem_bt.get(pid)-1);
                if (rem_bt.get(pid) == 0) table.put(pid, t);
            }
        }
        return new Object[]{gantt, table};
    }

    public static void main(String[] args) {
        Object[] res = priority(new Object[][]{{10,0,5,"P1"}, {20,1,4,"P2"}, {30,2,2,"P3"}, {40,4,1,"P4"}});
        System.out.println(res[0].toString());
        System.out.println(res[1].toString());   
    }
}
