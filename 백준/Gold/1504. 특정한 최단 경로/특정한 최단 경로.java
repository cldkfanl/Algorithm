import java.io.*;
import java.util.*;

public class Main {
    static int N, E; // N:정점, E:간선
    static int output = 0;
    static int INF = 200000000; //200,000 * 1,000
    static ArrayList<Node>[] adjList;
    static int[] cost;
    static boolean[] visited;
    static class Node implements Comparable<Node>{
        int dest, cost;
        public Node(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost; //cost 기준 오름차순 정렬
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        cost = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<N+1; i++) {
        	adjList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	adjList[a].add(new Node(b,c));
        	adjList[b].add(new Node(a,c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        
        if(ans1 >= INF && ans2 >= INF) {
        	output = -1;
        }
        else {
        	output = Math.min(ans1, ans2);
        }
        System.out.println(output);
    }
    static int dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	Arrays.fill(visited, false);
    	Arrays.fill(cost, INF);
    	
    	cost[start] = 0;
    	pq.add(new Node(start,0));
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		
    		if(visited[now.dest]) {
    			continue;
    		}
    		visited[now.dest] = true;
    		
    		for(Node next : adjList[now.dest]) {
    			if(cost[next.dest] > next.cost + now.cost) {
    				cost[next.dest] = next.cost + now.cost;
    				pq.add(new Node(next.dest , cost[next.dest]));
    			}
    		}
    	}
    	return cost[end];
    }
}
   