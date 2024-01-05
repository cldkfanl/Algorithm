import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=0; i<P; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y= Integer.parseInt(st.nextToken());
        	if(x >= X && x <= X+W) {
        		if(y >= Y && y <= Y + H) {
        			count ++;
        		}
        	}
        	else if(x > X + W && x <= X + W + 0.5 * H) {
        		double xlen = Math.pow(X+W-x,2) + Math.pow(Y+0.5 *H - y, 2);
        		if(xlen <= Math.pow(0.5 * H, 2)) {
        			count ++;
        		}
        	}
        	else if(x < X && x >= X - 0.5 * H) {
        		double xlen = Math.pow(X- x, 2) + Math.pow(Y + 0.5 * H - y, 2);
        		if(xlen <= Math.pow(0.5 * H , 2)) {
        			count ++;
        		}
        	}
        }
        System.out.println(count);
	}
}
