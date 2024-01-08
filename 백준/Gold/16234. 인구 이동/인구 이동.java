import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R;
	static int arr[][];
	static boolean flag[][];
	static List<int[]> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        boolean moved;
        int output = 0;
        do {
        	flag = new boolean[N][N];
        	moved = false;
            for(int i=0; i<N; i++) {
            	for(int j=0; j<N; j++) {
            		if(!flag[i][j]) {
                		list = new ArrayList<>();
                		list.add(new int[] {i,j});
                		flag[i][j] = true;
            	        int sum = trans(i,j,arr[i][j]);
            	        if(list.size() > 1) {
            	        	int avg = sum / list.size();
                            for (int[] pos : list) {
                                arr[pos[0]][pos[1]] = avg;
                            }
                            moved = true;
            	        }
            		}
            	}
            }
            if(moved) {
                output ++;
            }
        } while(moved);
        System.out.println(output);
	}
	static int trans(int x, int y, int sum) {
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !flag[nx][ny]) {
				if(Math.abs(arr[x][y]-arr[nx][ny])>= L &&  Math.abs(arr[x][y] - arr[nx][ny]) <= R) {
					flag[nx][ny] = true;
					list.add(new int[] {nx,ny});
					sum = trans(nx, ny, sum+arr[nx][ny]);
				}
			}
		}
		return sum;
	}
}
