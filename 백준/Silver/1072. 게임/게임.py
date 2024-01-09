X, Y = map(int, input().split())

low = 0
high = X
cnt = X
percent = (100 * Y) // X    #이분탐색
if(percent >= 99):          #99퍼센트 일 때
    print(-1)               #값 증가 불가능
else :
    while low <= high :     #진행조건
        mid = (low + high) // 2 #중앙값
        result = (100 * (Y + mid)) // (X + mid)
        if result > percent :
            cnt = mid
            high = mid - 1
        else :
            low = mid + 1
    print(cnt)
