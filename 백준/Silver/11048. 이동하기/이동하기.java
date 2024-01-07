import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[][];
	static int arr2[][];
	static int max = 0;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        arr2 = new int[N][M];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        arr2[0][0] = arr[0][0];
        candy();
        System.out.println(arr2[N-1][M-1]);
	}
	static void candy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i-1 >=0 && j-1>=0) {
					arr2[i][j] = arr[i][j] + Math.max(arr2[i-1][j-1], Math.max(arr2[i-1][j], arr2[i][j-1]));
				}
				else if(i-1 >=0) {
					arr2[i][j] = arr[i][j] + arr2[i-1][j];
				}
				else if(j-1 >=0) {
					arr2[i][j] = arr[i][j] + arr2[i][j-1];
				}
			}
		}
	}
}
