import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count;
	static int N,M;
	static int arr[][];
	static boolean flag[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        flag = new boolean[N+1];
        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a][b] = arr[b][a] = 1;
        }
        count = 0;
        for(int i=1; i<=N; i++) {
        	if(!flag[i]) {
            	check(i);
            	count++;
        	}
        }
        System.out.println(count);
	}
	public static void check(int num) {
		if(flag[num]) {
			return;
		}
		flag[num] = true;
		for(int i=1; i<=N; i++) {
				if(arr[num][i] == 1) {
					check(i);
				}
		}
	}
}
