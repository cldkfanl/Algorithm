import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
        	q.add(i);
        }
        while(N-->1) {
        	q.poll();
        	int tmp = q.poll();
        	q.add(tmp);
        }
        System.out.println(q.poll());
    }
}
