N, M = map(int, input().split())    #값 수신해서 배열 생성
arr = []
for i in range(N):
    row = list(input())
    arr.append(row)
max_size = 0
for i in range(N) :
    for j in range(M) :
        tmp = 1                     #점과 점 사이의 거리
        while tmp + i < N and tmp + j < M : #네 꼭지점의 값이 모두 같다면
            if arr[i][j] == arr[i][j + tmp] == arr[i + tmp][j] == arr[i + tmp][j + tmp] :
                if tmp > max_size :         #max_size의 값 갱신
                    max_size = tmp
            tmp += 1
print((max_size+1)**2)              #제곱해서 크기 출력