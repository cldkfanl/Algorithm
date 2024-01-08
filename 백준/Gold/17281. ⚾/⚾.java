import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean check[];
	static int lineup[];
	static Queue<Integer> que;
	static int out;
	static int max = -1;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new int[N][10];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=9; j++) {
            	arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check = new boolean[10];
        check[4] = true;
        lineup = new int[10];
        lineup[4] = 1;
        playerseq(2);
        System.out.println(max);
	}
	static void playerseq(int num) {
		if(num == 10) {
			int score = play();
			max = Math.max(max, score);
			return;
		}
		for(int i=1; i<=9; i++) {
			if(!check[i]) {
				check[i] = true;
				lineup[i] = num;
				playerseq(num+1);
				check[i] = false;
			}
		}
	}
	static int play() {
		int score = 0;
		int idx = 1;
		for(int i=0; i<N; i++) {
			int inningscore = 0;
			out = 0;
			boolean base[] = new boolean[4];
			while(out<3) {
				switch(arr[i][lineup[idx]]) {
				case 0 :
					out++;
					break;
				case 1 : 
					if(base[3]) {
						inningscore ++;
						base[3] = false;
					}
					if(base[2]) {
						base[3] = true;
						base[2] = false;
					}
					if(base[1]) {
						base[2] = true;
						base[1] = false;
					}
					base[1] = true;
					break;
				case 2 :
					if(base[3]) {
						inningscore ++;
						base[3] = false;
					}
					if(base[2]) {
						inningscore++;
						base[2] = false;
					}
					if(base[1]) {
						base[3] = true;
						base[1] = false;
					}
					base[2] = true;
					break;
				case 3 :
					if(base[3]) {
						inningscore ++;
						base[3] = false;
					}
					if(base[2]) {
						inningscore++;
						base[2] = false;
					}
					if(base[1]) {
						inningscore++;
						base[1] = false;
					}
					base[3] = true;
					break;
				case 4 : 
					if(base[3]) {
						inningscore ++;
						base[3] = false;
					}
					if(base[2]) {
						inningscore++;
						base[2] = false;
					}
					if(base[1]) {
						inningscore++;
						base[1] = false;
					}
					inningscore++;
					break;
				}
				idx++;
				if(idx>=10) {
					idx = 1;
				}
			}
			score += inningscore;
			
		}
		
		
		return score;
	}
}
