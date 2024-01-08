import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int arr[][];
	static Horse[] horse;
	static LinkedList<Integer>[][] state;
	static int dx[] = {0, 0, 0, -1, 1};
	static int dy[] = {0, 1, -1, 0, 0};
	static int count = 0;
	static class Horse{
		int x, y, dir;
		Horse(int x, int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        state = new LinkedList[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            	state[i][j] = new LinkedList<>();
            }
        }
        horse = new Horse[K+1];
        for(int i=1; i<=K; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int dir = Integer.parseInt(st.nextToken());
        	horse[i] = new Horse(x-1,y-1,dir);
        	state[x-1][y-1].add(i);
        }
        movehorse();
        if(count > 1000) {
        	System.out.println(-1);
        }
        else {
            System.out.println(count);
        }
    }
    static void movehorse() {
    	boolean check = true;
    	while(check) {
    		count++;
    		if(count > 1000) {
    			break;
    		}
    		for(int i=1; i<=K; i++) {
    			Horse h = horse[i];
    			int x = h.x;
    			int y = h.y;
    			
    			if(state[x][y].get(0) != i) {
    				continue;
    			}
    			int nx = x + dx[h.dir];
    			int ny = y + dy[h.dir];
    			
    			if(!isRange(nx,ny) || arr[nx][ny] == 2) {
    				h.dir = changedir(h.dir);
    				nx = x + dx[h.dir];
    				ny = y + dy[h.dir];
    			}
    			if(!isRange(nx,ny) || arr[nx][ny] == 2) {
    				continue;
    			}
    			else if(arr[nx][ny] == 1) {
    				for(int j=state[x][y].size()-1; j>=0; j--) {
    					int tmp = state[x][y].get(j);
    					state[nx][ny].add(tmp);
    					horse[tmp].x = nx;
    					horse[tmp].y = ny;
    				}
    				state[x][y].clear();
    			}
    			else {
    				for(int j=0; j<state[x][y].size(); j++) {
    					int tmp = state[x][y].get(j);
    					state[nx][ny].add(tmp);
    					horse[tmp].x = nx;
    					horse[tmp].y = ny;
    				}
    				state[x][y].clear();
    			}
    			if(state[nx][ny].size() >= 4) {
    				check = false;
    				break;
    			}
    		}
    	}
    }
    static int changedir(int dirr) {
    	switch(dirr) {
    	case 1 : return 2;
    	case 2 : return 1;
    	case 3 : return 4;
    	case 4 : return 3;
    	}
    	return 0;
    }
    static boolean isRange(int xx, int yy) {
    	if(xx < 0 || yy < 0 || xx >= N || yy >= N) {
    		return false;
    	}
    	return true;
    }
}
