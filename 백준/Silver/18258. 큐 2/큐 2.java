import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String tmp = st.nextToken();
            switch(tmp) {
            case "push" :
            	q.add(Integer.parseInt(st.nextToken()));
            	break;
            case "pop" :
            	if(q.isEmpty()) {
            		sb.append(-1).append("\n");
            	}
            	else {
            		sb.append(q.poll()).append("\n");
            	}
            	break;
            case "front" :
            	if(q.isEmpty()) {
            		sb.append(-1).append("\n");
            	}
            	else {
            		sb.append(q.peek()).append("\n");
            	}
            	break;
            case "back" :
            	if(q.isEmpty()) {
            		sb.append(-1).append("\n");
            	}
            	else {
            		sb.append(q.peekLast()).append("\n");
            	}
            	break;
            case "size" :
            	sb.append(q.size()).append("\n");
            	break;
            case "empty" :
            	if(q.isEmpty()) {
            		sb.append(1).append("\n");
            	}
            	else {
            		sb.append(0).append("\n");
            	}
            	break;
            }
        }
        System.out.println(sb);
    }
}
