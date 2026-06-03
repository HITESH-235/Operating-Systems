# SJF // Shortest Job First Scheduling Algorithm // Non-Preemptive
# process: [AT, BT, pid]


def sjf(processes):
    # sort the processes by arrival time
    processes.sort(key=lambda x: x[0])

    # initialise variables
    t = 0
    gantt = []
    table = {}

    while len(table) < len(processes):

        available = [] # list of processes that "have arrived" and "are not yet completed"
        for process in processes:
            at, bt, pid = process
            if at <= t and pid not in table: 
                available.append(process)

        if available:
            available.sort(key=lambda x: x[1]) # sort the available processses by burst time
            process = available[0]
            
            at, bt, pid = process
             
            t += bt
            gantt.append(pid)
            ct = t
            tat = ct-at
            wt = tat-bt
            table[pid] = [at, bt, ct, tat, wt]
        else:
            t += 1
            gantt.append("idle")

    return gantt, table



if __name__ == "__main__":
    processes = [[1, 3, 'P1'], [2, 4, 'P2'], [1, 2, 'P3'], [4, 4, 'P4']]
    gantt, table = sjf(processes)
    print("Gantt Chart: ", gantt)
    print("Full Table: ")
    print("PID AT BT  CT  TT  WT")
    for pid, values in table.items():
        print(pid, "", values[0], "", values[1], " ", values[2], " ", values[3], " ", values[4])