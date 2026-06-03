# Priority Scheduling // Non-Preemptive
# Process: [Priority, AT, BT, pid]

def priority(processes):

    t = 0
    gantt = []
    table = {}

    while len(table) < len(processes):
        available = []
        for p in processes:
            if p[1] <= t and p[3] not in table: available.append(p)

        if available:
            available.sort(key=lambda x: (-x[0], x[1])) # sort by priority then at, only difference with sjf
            p = available[0]

            t += p[2]
            gantt.append(p[3])
            table[p[3]] = t
        else:
            t += 1
            gantt.append("idle")

    return gantt, table

if __name__ == "__main__":
    processes = [[1,0,10,'P1'], [2,2,5,'P2'], [3,3,2,'P3'], [0,5,20,'P4']]
    gantt, table = priority(processes)
    print(gantt)
    print(table)