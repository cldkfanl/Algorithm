import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String arr[] = new String[N+1];
        Map<String, Integer> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
        	arr[i] = br.readLine();
        	map.put(arr[i], i);
        }
        for(int i=0; i<M; i++) {
        	String a = br.readLine();
        	if(map.containsKey(a))
        		sb.append(map.get(a)).append('\n');
        	else {
        		sb.append(arr[Integer.parseInt(a)]).append('\n');
        	}
        }
        System.out.println(sb);
	}
}
