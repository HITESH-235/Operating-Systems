# SJF // Shortest Job First Scheduling Algorithm // Non-Preemptive
# process: [AT, BT, pID]


def fcfs(processes):
    # Sort processes by arrival time
    processes.sort(key=lambda x: x[0])
    i = 0
    
    # Initialize all variables
    t = 0
    gantt = []
    table = {} # format: pid: [AT, BT, CT, TAT, WT]
    
    while i < len(processes):
        if processes[i][0] > t: # arrival time has not come yet
            t += 1
            gantt.append("idle")
            continue

        at, bt, pid = processes[i];
        gantt.append(pid)
        t += bt

        ct = t
        tat = ct-at
        wt = tat-bt
        table[pid] = [at, bt, ct, tat, wt]
        i += 1
    return gantt, table         



if __name__ == "__main__":
    processes = [[0, 5, 'P1'], [1, 3, 'P2'], [2, 8, 'P3'], [3, 6, 'P4']]
    gantt, table = fcfs(processes)
    print("Gantt Chart: ", gantt)
    print("Full Table: ")
    print("PID AT BT  CT  TT WT")
    for pid, values in table.items():
        print(pid, "", values[0], "", values[1], " ", values[2], "", values[3], " ", values[4])