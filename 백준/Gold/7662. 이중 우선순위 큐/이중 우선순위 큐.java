import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
        	TreeMap<Integer, Integer> map = new TreeMap<>();
        	int k = Integer.parseInt(br.readLine());
        	for(int j=0; j<k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                char D = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                
                if(D == 'I') {
                	map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else if(map.size() == 0) {
                	continue;
                }
                else {
                	int key = n == 1? map.lastKey() : map.firstKey();
                	int cnt = map.get(key);
                	if(cnt == 1) {
                		map.remove(key);
                	}
                	else {
                		map.put(key, cnt -1);
                	}
                }
        	}
        	if(map.size() == 0) {
        		sb.append("EMPTY").append("\n");
        	}
        	else {
        		sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
        	}
        }
        System.out.println(sb);
    }
}
