import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int arr[][] = new int[H+X][W+Y];
        int arr2[][] = new int[H][W];
        for(int i=0; i<H+X; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0; j<W+Y; j++) {
            	arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        for(int i=0; i<H; i++) {
        	for(int j=0; j<W; j++) {
        		if(i < X || j <Y) {
        			arr2[i][j] = arr[i][j];
        		}
        	}
        }
        for(int i=X; i<H; i++) {
        	for(int j=Y; j<W; j++) {
        		arr2[i][j] = arr[i][j]-arr2[i-X][j-Y];
        	}
        }
        for(int i=0; i<H; i++) {
        	for(int j=0; j<W; j++) {
        		sb.append(arr2[i][j]).append(' ');
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
	}
}
