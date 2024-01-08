import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int N, M;
	static int x1, x2, y1, y2;
	static int output = Integer.MAX_VALUE;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        int count = 0;
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
        	String input = br.readLine();
        	for(int j=0; j<M; j++) {
        		if(input.substring(j,j+1).equals("o")) {
        			if(count == 0) {
            			x1 = i;
            			y1 = j;
            			count++;
        			}
        			else {
            			x2 = i;
            			y2 = j;
        			}
        		}
        		else if(input.substring(j,j+1).equals("#")) {
        			arr[i][j] = 2;
        		}
        	}
        }
        coin(new Coin16197(x1, y1, x2, y2), 0);
        if(output == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
            System.out.println(output);
        }
	}
	
	static void coin(Coin16197 coins, int movecount) {
		if(movecount >= output ||movecount >=10) {
			return;
		}
		for(int i=0; i<4; i++) {
			int outsidecount = 0;
			int next_x1 = coins.x1 + dx[i];
			int next_y1 = coins.y1 + dy[i];
			int next_x2 = coins.x2 + dx[i];
			int next_y2 = coins.y2 + dy[i];
            if (next_x1 < 0 || next_x1 >= N || next_y1 < 0 || next_y1 >= M) {
            	outsidecount++;
            }

            if (next_x2 < 0 || next_x2 >= N || next_y2 < 0 || next_y2 >= M) {
            	outsidecount++;
            }
            if(outsidecount == 2) {
            	continue;
            }
            if(outsidecount == 1) {
            	output = Math.min(output,  movecount +1);
            	return;
            }
            if(arr[next_x1][next_y1] == 2) {
            	next_x1 = coins.x1;
				next_y1 = coins.y1;
            }
            if(arr[next_x2][next_y2] == 2) {
            	next_x2 = coins.x2;
				next_y2 = coins.y2;
            }
            coin(new Coin16197(next_x1, next_y1, next_x2, next_y2), movecount + 1);
		}
	}
}
class Coin16197 {
	int x1;
	int y1;
	int x2;
	int y2;
	
	Coin16197(int x1, int y1, int x2, int y2) {
		this.y1 = y1;
		this.x1 = x1;
		this.y2 = y2;
		this.x2 = x2;
	}
}
