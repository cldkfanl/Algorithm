import java.io.*;
import java.util.*;

public class Main {
	static int N , r, c;
	static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int result = 0;

        System.out.println(z(N, c, r, result));
    }

    public static int z(int n, int x, int y, int result) {

        if (n == 0) return result;
        int half = (int) Math.pow(2, n-1);
        int quadrant;

        if(x >= half && y >= half) {
            quadrant = 3;
            x -= half;
            y -= half;
        }
        else if(x < half && y >= half) {
            quadrant = 2;
            y -= half;
        }
        else if(x >= half && y < half) {
            quadrant = 1;
            x -= half;
        }
        else quadrant = 0;

        int initNum = (int) Math.pow(4, n-1);
        result += (initNum * quadrant);

        return z(--n, x, y, result);
    }
}
