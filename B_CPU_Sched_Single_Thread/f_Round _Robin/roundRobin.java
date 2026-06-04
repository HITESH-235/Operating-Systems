package B_CPU_Sched_Single_Thread.f_Round_Robin;
import java.util.*;
public class roundRobin {
    
    public static Object[] round_robin(Object[][] processes, int tq) {
        Arrays.sort(processes, (a,b) -> (Integer) a[0] - (Integer) b[0]);

        int t = 0, i = 0, n = processes.length;
        List<String> gantt = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();
        Queue<Object[]> readyQ = new ArrayDeque<>();
        Map<String, Integer> rem_bt = new HashMap<>();
        for (Object[] p: processes) rem_bt.put((String) p[2], (Integer) p[1]);
        
        while (!rem_bt.isEmpty()) {
            while (i<n && (Integer) processes[i][0] <= t) {
                readyQ.offer(processes[i]);
                i++;
            }
            if (readyQ.isEmpty()) {
                gantt.add("idle");
                t++;
                continue;
            }
            
            Object[] curr = readyQ.poll();
            String pid = (String) curr[2];
            int runTime = Math.min(rem_bt.get(pid), tq);
            t += runTime;
            rem_bt.put(pid, rem_bt.get(pid)-runTime);
            gantt.add(pid);
            

            while (i<n && (Integer) processes[i][0] <= t) {
                readyQ.offer(processes[i]);
                i++;
            }
            if (rem_bt.get(pid) == 0) {
                rem_bt.remove(pid);
                table.put(pid, t);
            }
            else readyQ.offer(curr);
            
        }
        return new Object[]{gantt, table};
    }


    public static void main(String[] args) {
        Object[] res = round_robin(new Object[][]{{0,5,"P1"}, {1,4,"P2"}, {2,2,"P3"}, {4,1,"P4"}}, 2);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}