import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fx = {1, 5, 10, 50};
    static boolean arr[];

    static int count = 0;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N * 50+1];
        dfs(N,0,0);
        System.out.println(count);
	}
	static void dfs(int N, int idx, int sum) {
		if(N == 0) {
			if(arr[sum] == false) {
				count++;
				arr[sum] = true;
			}
			return;
		}
		for(int i=idx; i<4; i++) {
			dfs(N-1, i, sum+ fx[i]);
		}
	}
}
