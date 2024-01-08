import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T;
	public static void main(String args[]) throws IOException{
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int arr[][] = new int[10001][4];
        arr[1][1] = 1;
        arr[2][1] = arr[1][1] + arr[1][2] + arr[1][3];
        arr[2][2] = 1;
        arr[3][1] = arr[2][1] + arr[2][2] + arr[2][3];
        arr[3][2] = arr[1][2] + arr[1][3];
        arr[3][3] = 1;
        for(int i=4; i<10001; i++) {
        	arr[i][1] = arr[i-1][1] + arr[i-1][2] + arr[i-1][3];
        	arr[i][2] = arr[i-2][2] + arr[i-2][3];
        	arr[i][3] = arr[i-3][3];
        }
        for(int i=0; i<T; i++) {
        	int n = Integer.parseInt(br.readLine());
        	sb.append(arr[n][1] + arr[n][2] + arr[n][3]).append('\n');
        }
        System.out.println(sb);
	}
}
