from collections import deque                      //Deque 사용

N = int(input())
deq = deque(enumerate(map(int, input().split())))  //입력 순서와 입력값을 deque에 저장
arr = []
while deq :                                        //deq가 비기 전까지
    fir, sec = deq.popleft()                       //맨 앞에 있는 값 뽑아서
    arr.append(fir + 1)                            //입력 순서는 arr에 저장
    if sec > 0 :                                   //입력값이 0보다 크다면
        deq.rotate(-sec + 1)                       //우측으로 이동, 본인을 제외해야 하기 때문에 + 1
    elif sec < 0 :                                 //입력값이 0보다 작다면
        deq.rotate(-sec)                           //좌측으로 이동.
print(" ".join(map(str, arr)))                     //저장한 arr을 출력
