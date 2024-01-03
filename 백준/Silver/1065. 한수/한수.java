import java.io.*;
import java.util.*;
//브루트포스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[1001];
        for(int i=1; i<100; i++) {            //1 ~ 99까지는 모두 등차수열
        	arr[i] = true;
        }
        for(int i=100; i<1000; i++) {
        	String tmp = "" + i;              //자르기 쉽게 문자열 변환, 1~2 & 2~3 자리수의 차를 구한다
        	int fir = Integer.parseInt(tmp.substring(0,1)) - Integer.parseInt(tmp.substring(1,2));
        	int sec = Integer.parseInt(tmp.substring(1,2)) - Integer.parseInt(tmp.substring(2,3));
        	if(fir == sec) {
        		arr[i] = true;                //두 수가 같으면(등차수열이면) 참으로 설정
        	}
        }
        int output = 0;
        for(int i=1; i<= N; i++) {            //주어진 수까지 참인 갯수를 구한다
        	if(arr[i]) {
        		output++;
        	}
        }
        System.out.println(output);           //참인 개수 출력
    }
}
