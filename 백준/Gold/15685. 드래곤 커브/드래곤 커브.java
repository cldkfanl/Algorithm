import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean map[][] = new boolean[101][101];
	static int arrxy[][];
	static final int right = 0;
	static final int up = 1;
	static final int left = 2;
	static final int down = 3;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int g = Integer.parseInt(st.nextToken());
        	paint(x,y,getDirec(d,g));
        }
        int output = 0;
        for(int i=0; i<100; i++) {
        	for(int j=0; j<100; j++) {
        		if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
        			output++;
        		}
        	}
        }
        System.out.println(output);
	}
	public static void paint(int x, int y, List<Integer> directions) {
		map[x][y] = true;
		for(int direction : directions) {
			switch(direction) {
			case right :
				map[++x][y] = true;
				break;
			case up :
				map[x][--y] = true;
				break;
			case left :
				map[--x][y] = true;
				break;
			case down :
				map[x][++y] = true;
				break;
			}	
		}
	}
	public static List<Integer> getDirec(int d, int g){
		List<Integer> directions = new ArrayList<>();
		directions.add(d);
		while(g-- >0) {
			for(int i= directions.size() -1; i>=0; i--) {
				int direction = (directions.get(i) + 1) %4;
				directions.add(direction);
			}
		}
		return directions;
	}
}

