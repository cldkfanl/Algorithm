import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char arr[][] = new char[8][8];
    static int[] dx = {-1,-1,-1, 0, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1,-1, 0, 1,-1, 0, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<8; i++) {
        	String input = br.readLine();
        	for(int j=0; j<8; j++) {
        		arr[i][j] = input.charAt(j);
        	}
        }

        System.out.println(bfs());
	}
	static int bfs() {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {7,0});
    	while(!q.isEmpty()) {
    		int s = q.size();
    		for(int j=0; j<s; j++) {
    			int now[] = q.poll();
    			if(arr[now[0]][now[1]] == '#') {
    				continue;
    			}
    			for(int i=0; i<9; i++) {
    				int nx = now[0] + dx[i];
    				int ny = now[1] + dy[i];
                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) {
                        continue;
                    }
                    if(nx == 0 && ny == 7) {
                    	return 1;
                    }
                    if(arr[nx][ny] != '#') {
                    	q.add(new int[] {nx,ny});
                    }
    			}
    		}
            movemap();
    	}
    	return 0;
	}
	static void movemap() {
		for(int i=7; i>=0; i--) {
			for(int j=0; j<8; j++) {
				if(arr[i][j] == '#') {
					arr[i][j] = '.';
					if(i!=7) {
						arr[i+1][j] = '#';
					}
				}
				
			}
		}
	}
}
