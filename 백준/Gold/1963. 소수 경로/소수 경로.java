import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Loc{
		int num;
		public Loc(int num) {
			this.num = num;
		}
	}
	static StringBuilder sb = new StringBuilder();
	static boolean isPrime[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        isPrime = new boolean[10000];
        findPrimes();
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            bfs(fir,sec);
        }
        System.out.println(sb);
	}
    static void findPrimes() {
        for (int i = 2; i * i < 10000; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
	static void bfs(int fir, int sec) {
		boolean flag[] = new boolean[10000];
		int count[] = new int[10000];
        Queue<Loc> q = new LinkedList<>();
		int min = Integer.MAX_VALUE;
    	q.add(new Loc(fir));
    	flag[fir] = true;
    	
    	while(!q.isEmpty()) {
    		Loc tmp = q.poll();
            for (int i = 0; i < 4; i++) { // 바꿀 자리 반복문 0,1,,2,3번째 자리인 경우
                for (int j = 0; j <= 9; j++) { // i번째 자리를 0-9의 값으로 바꾼다
                    if (i == 0 && j == 0) { // 0번째 자리를 0으로 바꾸면 안된다
                        continue;
                    }
                    int k = change(tmp, i, j); // i번째를 j값으로 변경한 수
                    if (!isPrime[k] && !flag[k]) { // k가 소수이고 k를 방문하지 않았을 때
                        q.add(new Loc(k)); // 큐에 넣고
                        flag[k] = true; // 방문처리한다
                        count[k] = count[tmp.num] + 1; // 방문횟수를 증가시킨다
                    }
                }
            }
        }
    	sb.append(count[sec]).append('\n');
	}
	static int change(Loc tmp, int i, int j) {
        StringBuilder sbb = new StringBuilder(String.valueOf(tmp.num));
        sbb.setCharAt(i, (char) (j + '0'));
        return Integer.parseInt(sbb.toString()); // 그냥 sb 하면 안되는 이유는 괄호안에 타입이 string이기 때문
    }
}
