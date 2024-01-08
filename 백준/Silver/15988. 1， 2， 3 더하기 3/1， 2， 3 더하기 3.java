import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        long arr[][] = new long[1000001][4];
        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[2][1] = 1;
        arr[3][3] = 1;
        arr[3][2] = 1;
        arr[3][1] = 2;
        for(int i=4; i<=1000000; i++) {
            arr[i][1] = (arr[i-1][1] + arr[i-1][2] + arr[i-1][3])%1000000009;
            arr[i][2] = (arr[i-2][1] + arr[i-2][2] + arr[i-2][3])%1000000009;
            arr[i][3] = (arr[i-3][1] + arr[i-3][2] + arr[i-3][3])%1000000009;
        }
        for(int i=0; i<a; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println((arr[input][1] + arr[input][2] + arr[input][3])%1000000009);
        }
    }
}
