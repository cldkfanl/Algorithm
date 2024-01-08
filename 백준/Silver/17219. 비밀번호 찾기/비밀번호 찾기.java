import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());;
        int M = Integer.parseInt(st.nextToken());;
        HashMap<String, String> names = new HashMap<>();
        String arr2[] = new String[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            String site = st2.nextToken();
            String password = st2.nextToken();
            names.put(site, password);
        }
        for(int i=0; i<M; i++) {
        	String input = br.readLine();
        	sb.append(names.get(input)).append('\n');
        }
        System.out.println(sb);
	}
}
