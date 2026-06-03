# Round Robin // Preemptive Algorithm
# Process: [AT, BT, pid]

def roundRobin(processes, tq):
    t = 0
    gantt = []
    table = {}

    rem_bt = {pid:bt for at,bt,pid in processes}
    processes.sort(key=lambda x:x[0])

    while len(table) < len(processes):
        available = []
        for p in processes:
            if p[0] <= t and p[2] not in table:
                available.append(p[0], rem_bt[p[2]], p[2])

        if available:
            t += 1
            gantt.append(idle)
            continue
        else:
            processes = available