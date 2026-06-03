# Priority Scheduling // Preemptive Algorithm
# Process: [priority, AT, BT, pid]

def priority(processes):
    t = 0
    gantt = []
    table = {}
    rem_bt = {p[3]:p[2] for p in processes}

    while len(table) < len(processes):
        available = []
        for p in processes:
            if p[1] <= t and p[3] not in table: available.append(p)

        if available:
            available.sort(key=lambda x: (-x[0], x[1]))
            p = available[0]

            rem_bt[p[3]] -= 1
            t += 1
            gantt.append(p[3])
            if rem_bt[p[3]] == 0: 
                table[p[3]] = t

        else:
            gantt.append("idle")
            t += 1
    return gantt, table

if __name__ == "__main__":
    processes = [[10,0,5,'P1'], [20,1,4,'P2'], [30,2,2,'P3'], [40,4,1,'P4']]
    gantt, table = priority(processes)
    print(gantt)
    print(table)