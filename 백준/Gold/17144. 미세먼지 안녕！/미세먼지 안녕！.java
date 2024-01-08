import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C,T;
	static int arr[][];
	static int arr2[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for(int i=0; i<R; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<C; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        while(T-- >0) {
    		arr2 = new int[R][C];
            air();
        }
        int output = 0;
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		if(arr[i][j] != -1) {
        			output += arr[i][j];
        		}
        	}
        }
        System.out.println(output);
	}
	static void air() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				int tmp = arr[i][j]/5;
				int tmp2 = arr[i][j];
				for(int k=0; k<4; k++) {
					int nx = dx[k] + i;
					int ny = dy[k] + j;
					if(nx>=0 && ny>=0 && nx<R && ny<C && arr[nx][ny] != -1) {
						arr2[nx][ny] += tmp;
						tmp2 -= tmp;
					}
				}
				arr2[i][j] += tmp2;
			}
		}
		for(int i=0; i<R; i++) {
			if(arr2[i][0] == -1 && arr2[i+1][0] == -1) {
				for(int j = i+3; j < R; j++) {
					arr2[j-1][0] = arr2[j][0];
				}
				for(int j = i-2; j>=0; j--) {
					arr2[j+1][0] = arr2[j][0];
				}
				for(int j = 1; j <C; j++) {
					arr2[R-1][j-1] = arr2[R-1][j];
					arr2[0][j-1] = arr2[0][j];
				}
				for(int j= R-2; j>= i+1; j-- ) {
					arr2[j+1][C-1] = arr2[j][C-1];
				}
				for(int j = 1; j<= i; j++) {
					arr2[j-1][C-1] = arr2[j][C-1];
				}
				for(int j=C-2; j>=1; j--) {
					arr2[i][j+1] = arr2[i][j];
					arr2[i+1][j+1] = arr2[i+1][j];
				}
				arr2[i][1] = 0;
				arr2[i+1][1] = 0;
			}
		}
		arr = arr2;
	}
}
