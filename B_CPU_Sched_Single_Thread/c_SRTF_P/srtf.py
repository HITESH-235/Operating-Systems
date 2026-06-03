# SRTF // Shortest Remaining Time First // Preemtive
# process: [AT, BT, pid]


def srtf(processes):
    # sort the processes by arrival time
    processes.sort(key=lambda x: x[0])

    bt_map = {p[2]:p[1] for p in processes} # map storing total burst time
    rem_bt_map = {p[2]:p[1] for p in processes} # map storing remaining burst time

    # initialise variables
    t = 0
    gantt = []
    table = {}

    while len(table) < len(processes):
        available = [] # list of processes that "have arrived" and "are not yet completed"

        for process in processes:
            at, bt, pid = process

            if at <= t and pid not in table: 
                # use remaining to get remaining bt 
                available.append([at, rem_bt_map[pid], pid])

        # idle state (no process available)
        if not available:
            t += 1
            gantt.append("idle")
            continue
        # pickup suitable process from RQueue
        else:
            available.sort(key=lambda x: (x[1],x[0])) # sort by remaining burst time, then arrival time
            at, rbt, pid = available[0]
            gantt.append(pid)
            rem_bt_map[pid] -= 1
            t += 1
            
            if rem_bt_map[pid] == 0: # if process completed
                ct = t
                tat = ct-at
                wt = tat - bt_map[pid]
                table[pid] = [at, bt_map[pid], ct, tat, wt]
        
    return gantt, table


if __name__ == "__main__":
    processes = [[1, 3, 'P1'], [2, 4, 'P2'], [1, 2, 'P3'], [4, 4, 'P4']]
    gantt, table = srtf(processes)
    print("Gantt Chart: ", gantt)
    print("Full Table: ")
    print("PID AT BT  CT  TT  WT")
    for pid, values in table.items():
        print(pid, "", values[0], "", values[1], " ", values[2], " ", values[3], " ", values[4])