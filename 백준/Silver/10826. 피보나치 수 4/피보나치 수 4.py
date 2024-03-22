arr = []
num = input()
arr.append(0)
arr.append(1)
arr.append(1)

for i in range(3,10001):
    tmp = arr[i-1] + arr[i-2]
    arr.append(tmp)

print(arr[int(num)])
