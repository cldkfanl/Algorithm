fir = input()
sec = input()
cnt = 0
i = 0

while i < len(fir):
    if fir[i:i+len(sec)] == sec:
        cnt += 1
        i += len(sec)
    else:
        i += 1
print(cnt)