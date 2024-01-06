from collections import deque

N = int(input())
deq = deque(enumerate(map(int, input().split())))
arr = []
while deq :
    fir, sec = deq.popleft()
    arr.append(fir + 1)
    if sec > 0 :
        deq.rotate(-sec + 1)
    elif sec < 0 :
        deq.rotate(-sec)
print(" ".join(map(str, arr)))