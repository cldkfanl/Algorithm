import java.io.*;
import java.util.*;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main {
	static int N, M;
	static int arr[][], arr2[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Integer> groupSize;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        arr2 = new int[N][M];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
        	}
        }
        
        int groupCnt = 1;
        groupSize = new HashMap<>();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(arr[i][j] == 0 && arr2[i][j] == 0) {
        			groupSize.put(groupCnt, bfs2(i,j,groupCnt));
        			groupCnt++;
        		}
        	}
        }
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(arr2[i][j] == 0) {
        			sb.append(count(i,j));
        		}
        		else {
        			sb.append(0);
        		}
        	}
        	sb.append('\n');
        }
    	System.out.println(sb);
	}
	static int count(int x, int y) {
		int cnt = 1;
		if(arr[x][y] == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y+ dy[i];
			if(nx >= 0 && ny >= 00 && nx < N && ny < M) {
				set.add(arr2[nx][ny]);
			}
		}
		for(int size : set) {
			cnt += groupSize.getOrDefault(size, 0);
		}
		return cnt % 10;
		
	}
	static int bfs2(int x, int y, int groupnum) {
    	int count = 1;
		Queue<Point> q = new LinkedList<>();
    	q.add(new Point(x,y));
    	arr2[x][y] = groupnum;
    	while(!q.isEmpty()) {
    		Point point = q.poll();
    		int cntx = point.x;
    		int cnty = point.y;
    		for(int i=0; i<4; i++) {
    			int nx = cntx + dx[i];
    			int ny = cnty + dy[i];
    			if(nx >=0 && ny >=0 && nx < N && ny < M) {
    				if(arr[nx][ny] == 0 && arr2[nx][ny] == 0) {
    					arr2[nx][ny] = groupnum;
    					q.add(new Point(nx,ny));
    					count++;
    				}
    			}
    		}
    	}
    	return count;
	}
}
