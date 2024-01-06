import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dfs(A,B);
        }
        System.out.println(sb);
    }
    static void dfs(int start, int end) {
    	boolean visit[] = new boolean[10000];
    	String command[] = new String[10000];
    	visit[start] = true;
    	Arrays.fill(command,  "");
    	Queue<Integer> q = new LinkedList<>();
    	q.add(start);
    	while(!q.isEmpty() && !visit[end]) {
    		int now = q.poll();
    		
    		int dNum = (now*2)%10000;
    		int sNum = (now == 0) ? 9999 : now - 1;
    		int lNum = (now % 1000) * 10 + now / 1000;
    		int rNum = (now % 10) * 1000 + now / 10;

    		if (!visit[dNum]) {
                q.add(dNum); // 큐에 넣는다
                visit[dNum] = true; // 방문처리한다
                command[dNum] = command[now] + "D"; // 명령어를 추가한다
            }
            if (!visit[sNum]) {
                q.add(sNum);
                visit[sNum] = true;
                command[sNum] = command[now] + "S";
            }
            if (!visit[lNum]) {
                q.add(lNum);
                visit[lNum] = true;
                command[lNum] = command[now] + "L";
            }
            if (!visit[rNum]) {
                q.add(rNum);
                visit[rNum] = true;
                command[rNum] = command[now] + "R";
            }
    	}
    	sb.append(command[end]).append("\n");
    }
}