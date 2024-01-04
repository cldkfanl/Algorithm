num = int(input())
for i in range(num):        #num만큼 반복
    stack = []              #스택
    tmp = input()
    for char in tmp :
        if char == '(' :    #'('인 경우 스택 삽입
            stack.append('(')
        else :              #')'인 경우
            if not stack :  #스택이 비어있으면
                print("NO") #NO 출력후 종료
                break
            stack.pop()     #비어있지 않은 경우 팝
    else:
        if not stack :      #for문 종료 후 ()수가 맞으면
            print("YES")
        else :              #()수가 맞지 않으면
            print("NO")    
