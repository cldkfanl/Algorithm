import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int l;
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	static int max;
	static int arr[][];
	static boolean flag[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            max = Integer.MAX_VALUE;
        	l = Integer.parseInt(br.readLine());
        	arr = new int[l][l];
        	flag = new boolean[l][l];
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            flag[x1][y1] = true;
            n(x1, y1);
            sb.append(arr[x2][y2]).append('\n');
        }
        System.out.println(sb);
	}
	static void n(int x1, int y1) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x1, y1});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			for(int i=0; i<8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx <0 || nx >=l || ny <0 || ny >= l || flag[nx][ny]) {
					continue;
				}
				flag[nx][ny] = true;
				arr[nx][ny] = arr[x][y] + 1;
				queue.add(new int[] {nx, ny});
			}
		}
	}
}
