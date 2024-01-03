rows = 101
cols = 101
arr = [[0 for j in range(cols)] for i in range(rows)] #101 * 101 이중 배열 생성

for _ in range(4):
    tmp = input().split()                            #입력값 받아서 배열로 나눈다.
    for j in range(int(tmp[0]), int(tmp[2])):        #범위에 있는 배열 칸을 1로 변경
        for k in range(int(tmp[1]), int(tmp[3])):
            arr[j][k] = 1
cnt = 0
for i in range(rows):                                #배열 값이 1인 수만 세기
    for j in range(cols):
        if(arr[i][j] == 1):
            cnt += 1

print(cnt)