import java.io.*;
import java.util.*;
public class Main {
    static class Tree{ // 트리
        int end;
        int weight;

        public Tree(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static class Node{ // BFS
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    static int V;
    static int result = 0;
    static int max_node = 0;
    static ArrayList<Tree>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        
        nodes = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
        	nodes[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            while(true) {
            	int fir = Integer.parseInt(st.nextToken());
            	if(fir == -1) {
            		break;
            	}
            	int sec = Integer.parseInt(st.nextToken());
            	nodes[num].add(new Tree(fir,sec));
            }
        }
        bfs(1);
        bfs(max_node);
        
        System.out.println(result);
    }
    static void bfs(int start) {
    	boolean visited[] = new boolean[V+1];
    	
    	Queue<Node> q = new LinkedList<>();
    	q.add(new Node(start,0));
    	visited[start] = true;
    	int max_cnt = 0;
    	
    	while(!q.isEmpty()) {
    		Node now = q.poll();
    		
    		if(now.cnt > max_cnt) {
    			max_cnt = now.cnt;
    			max_node = now.idx;
    		}
    		for(Tree e : nodes[now.idx]) {
    			if(!visited[e.end]) {
    				visited[e.end] = true;
    				q.add(new Node(e.end , now.cnt + e.weight));
    			}
    		}
    	}
    	result = Math.max(result, max_cnt);
    }
}
