import java.util.Arrays;
class Solution
{
// 첫번째 배열의 큰 값 * 두번째 배열의 작은 값
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);     //정렬
        Arrays.sort(B);     //정렬
        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[B.length-i-1]; //하나는 순서대로 증가, 다른 하나는 역순으로 증가, 두개 곱해서 더함
        }

        return answer;
    }
}