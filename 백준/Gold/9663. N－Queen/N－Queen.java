import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int arr2[][];
	static int N;
	static int output = 0;
	static StringBuilder sb = new StringBuilder();
	static boolean flag[][];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr2 = new int[N][2];
        flag = new boolean[N][N];
        queen(0);
        System.out.println(output);
	}
	static void queen(int count) {
		if(count == N) {
			output++;
			return;
		}
			for(int j=0; j<N; j++) {
				if(!flag[count][j] && queencheck(count, j)) {
					flag[count][j] = true;
					arr2[count][0] = count;
					arr2[count][1] = j;
					queen(count + 1);
					flag[count][j] = false;
				}
			}
	}
	static boolean queencheck(int num, int j) { 
		boolean check = true;
		for(int i=0; i<num; i++) {
			if((arr2[i][1] == j) || (Math.abs(arr2[i][0]-num) == Math.abs(arr2[i][1]-j))) {
				check=false;
			}
		}
		if(!check) {
			return false;
		}
		return true;
	}
}
