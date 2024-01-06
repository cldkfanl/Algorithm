import java.io.*;
import java.util.*;
public class Main {
	static int arr[][];
	static int snakeState = 0;
	static int nowTime = 0;
	static int N, K;
	static List<int[]> snake = new ArrayList<>();
	static HashMap<Integer, String> hash = new HashMap<>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	public static void main(String args[]) throws IOException{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<K; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int fir = Integer.parseInt(st.nextToken());
        	int sec = Integer.parseInt(st.nextToken());
        	arr[fir-1][sec-1] = 1;
        }
        int L = Integer.parseInt(br.readLine());

        for(int i=0; i<L; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int X = Integer.parseInt(st.nextToken());
        	String C = st.nextToken();
        	hash.put(X,C);
        }
        slove();
	}
	static void slove() {
		int cx = 0, cy = 0;
		int time = 0;
		int d = 0;
        snake.add(new int[] {0,0});
		while(true) {
			time++;
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			
			if(!check2(nx,ny)) {
				break;
			}
			
			if(arr[nx][ny] == 1) {
				arr[nx][ny] = 0;
				snake.add(new int[] { nx, ny });
			}
			else {
				snake.add(new int[] { nx, ny });
				snake.remove(0);
			}
			
			if(hash.containsKey(time)) {
				if(hash.get(time).equals("D")) {
					d ++;
					if(d == 4) {
						d = 0;
					}
				}
				else {
					d --;
					if(d == -1) {
						d = 3;
					}
				}
			}
			cx = nx;
			cy = ny;
		}
		System.out.println(time);
	}
	static boolean check2(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		for (int i = 0; i < snake.size(); i++) {
			int[] t = snake.get(i);
			if (x == t[0] && y == t[1])
				return false;
		}
		return true;
	}
}
