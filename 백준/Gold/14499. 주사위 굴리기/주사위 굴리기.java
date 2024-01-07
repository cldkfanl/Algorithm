import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dice[][] = new int[4][4];
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];
        int arr_2[] = new int[7];
        dice[0][1] = 2;
        dice[1][1] = 1;
        dice[2][1] = 5;
        dice[3][1] = 6;
        dice[1][0] = 4;
        dice[1][2] = 3;
        
        for(int i = 0; i<N; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	for(int j = 0; j<M; j++) {
        		arr[i][j] = Integer.parseInt(st2.nextToken());	
        	}
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        while(k-- >0) {
        	int num = Integer.parseInt(st3.nextToken());
        	switch(num) {
        	case 1:
        		if(y==M-1) {
        			continue;
        		}
        		int temp = dice[1][0];
        		dice[1][0] = dice[3][1];
        		dice[3][1] = dice[1][2];
        		dice[1][2] = dice[1][1];
        		dice[1][1] = temp;
        		y++;
        		if(arr[x][y] == 0) {
        			arr[x][y] = arr_2[dice[3][1]];
        		}
        		else {
        			arr_2[dice[3][1]] = arr[x][y];
        			arr[x][y] = 0;
        		}
        		sb.append(arr_2[dice[1][1]]).append('\n');
        		break;
        	case 2:
        		if(y == 0) {
        			continue;
        		}
        		temp = dice[1][2];
        		dice[1][2] = dice[3][1];
        		dice[3][1] = dice[1][0];
        		dice[1][0] = dice[1][1];
        		dice[1][1] = temp;

        		y--;
        		if(arr[x][y] == 0) {
        			arr[x][y] = arr_2[dice[3][1]];
        		}
        		else {
        			arr_2[dice[3][1]] = arr[x][y];
        			arr[x][y] = 0;
        		}
        		sb.append(arr_2[dice[1][1]]).append('\n');
        		break;
        	case 3:
        		if(x==0) {
        			continue;
        		}
        		temp = dice[0][1];
        		dice[0][1] = dice[1][1];
        		dice[1][1] = dice[2][1];
        		dice[2][1] = dice[3][1];
        		dice[3][1] = temp;

        		x--;
        		if(arr[x][y] == 0) {
        			arr[x][y] = arr_2[dice[3][1]];
        		}
        		else {
        			arr_2[dice[3][1]] = arr[x][y];
        			arr[x][y] = 0;
        		}
        		sb.append(arr_2[dice[1][1]]).append('\n');
        		break;
        	case 4:
        		if(x == N-1) {
        			continue;
        		}
        		temp = dice[3][1];
        		dice[3][1] = dice[2][1];
        		dice[2][1] = dice[1][1];
        		dice[1][1] = dice[0][1];
        		dice[0][1] = temp;

        		x++;
        		if(arr[x][y] == 0) {
        			arr[x][y] = arr_2[dice[3][1]];
        		}
        		else {
        			arr_2[dice[3][1]] = arr[x][y];
        			arr[x][y] = 0;
        		}
        		sb.append(arr_2[dice[1][1]]).append('\n');
        		break;
        	}
        }
        System.out.println(sb);
	}
}
