import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static class Num {
		int num;
		int count;
		Num(int num, int count){
			this.num = num;
			this.count = count;
		}
	}
	static long output = Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];
        bfs(F,S,G,U,D);
        if(output == Integer.MAX_VALUE) {
        	System.out.println("use the stairs");
        }
        else {
        	System.out.println(output);
        }
	}
    static void bfs(int max, int start, int end, int up, int down) {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Num nw = q.poll();
            if (nw.num == end) {
                output = Math.min(nw.count, output);
                return;
            }
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case 0:
                        if (nw.num + up <= max && !visited[nw.num + up]) {
                            q.add(new Num(nw.num + up, nw.count + 1));
                            visited[nw.num + up] = true;
                        }
                        break;
                    case 1:
                        if (nw.num - down > 0 && !visited[nw.num - down]) {
                            q.add(new Num(nw.num - down, nw.count + 1));
                            visited[nw.num - down] = true;
                        }
                        break;
                }
            }
        }
    }
}
