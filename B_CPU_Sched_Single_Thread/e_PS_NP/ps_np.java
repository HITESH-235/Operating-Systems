// Priority Scheduling // Non-Preemptive
// Process: [Priority, AT, BT, pid]

package B_CPU_Sched_Single_Thread.e_PS_NP;
import java.util.*;
public class ps_np {

    public static Object[] priority(Object[][] processes) {
        List<String> gantt = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();
        int t = 0;

        while (table.size() < processes.length) {
            List<Object[]> available = new ArrayList<>();
            for (Object[] p: processes) {
                if ((Integer) p[1] <= t && !table.containsKey((String) p[3])) 
                    available.add(p);
            }

            if (available.size() == 0) {
                t++;
                gantt.add("idle");
            }
            else {
                available.sort((a,b) -> {
                    int diff = (Integer)b[0]-(Integer)a[0];
                    if (diff != 0) return diff;
                    else return (Integer)a[1]-(Integer)b[1];
                });
                Object[] p = available.get(0);
                t += (Integer) p[2];
                gantt.add((String) p[3]);
                table.put((String) p[3], t);
            }
        }
        return new Object[]{gantt, table};
    }


    public static void main(String[] args) {

        Object[] res = priority(new Object[][]{{1,0,10,"P1"}, {2,2,5,"P2"}, {3,3,2,"P3"}, {0,5,20,"P4"}});
        System.out.println(res[0].toString());
        System.out.println(res[1].toString());
    }
}