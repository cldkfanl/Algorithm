import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean arr[][];
	static boolean wall[][];
	static boolean finish = false;
	static int r;
	static int c;
	static int d;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        r = Integer.parseInt(st2.nextToken());
        c = Integer.parseInt(st2.nextToken());
        d = Integer.parseInt(st2.nextToken());
        wall = new boolean[N][M];
        arr = new boolean[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<M; j++) {
        		int flag = Integer.parseInt(st3.nextToken());
        		if(flag == 1) {
        			wall[i][j] = true;
        			//wall이 true가 벽, false가 벽 아님
        		}
        	}
        }
        while(!finish) {
        	if(arr[r][c] == false) {
        		//arr이 false(청소가 안됨)면
        		arr[r][c] = true;
        		//청소 하면 arr을 true로
        		count ++;
        	}
    		cleancheck();
    		//주변 청소 여부 탐색
    	}
    System.out.println(count);
	}
	public static void switchstate() {
		switch(d) {
		case 0 : d = 3; break;
		case 1 : d = 0; break;
		case 2 : d = 1; break;
		case 3 : d = 2; break;
		}//d의 상태에 따라서 회전
	}
	public static void checkfront(int count) {
		if(count == 4) {
			finish = true;
		} else {
			int nextR = r;
			int nextC = c;
			switch(d) {
            case 0: nextR--; break;
            case 1: nextC++; break;
            case 2: nextR++; break;
            case 3: nextC--; break;
			}
			if (!wall[nextR][nextC] && !arr[nextR][nextC]) {
                r = nextR;
                c = nextC;
                //이동할 곳이 벽도 없고 청소할 곳이면 이동
            } else {
            	//아니라면 회전 한번 더
                switchstate();
                checkfront(count + 1);
                //재귀
            }
		}
	}
	public static void checkback() {
		int nextR = r;
		int nextC = c;
		switch(d) {
		case 0 : nextR++; break;
		case 1 : nextC--; break;
		case 2 : nextR--; break;
		case 3 : nextC++; break;
		}
		if(!wall[nextR][nextC]) {
			r = nextR;
			c = nextC;
		}
		else {
			finish = true;
		}
	}
	public static void cleancheck() {
//	    if (r > 0 && r < arr.length - 1 && c > 0 && c < arr[0].length - 1) {
	        if ((arr[r+1][c]||wall[r+1][c])&&(arr[r-1][c]||wall[r-1][c])&&(arr[r][c+1]||wall[r][c+1])&&(arr[r][c-1]||wall[r][c-1])) {
	        	//현 위치 주변이 전부 청소가 되어있다면
	        	checkback();
	        	//로봇의 뒤 상태 확인
	        }else {
	        	switchstate();
	        	//청소할 곳이 있다면 반시계방향으로 회전
	        	checkfront(0);
	        	//앞 칸 확인
	        }
//	    } else {
//	        finish = true;
//	    }
	}

}
