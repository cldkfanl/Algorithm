import java.io.*;
import java.util.*;

public class Main {
	static int dist[];
	static int N, M;
	static ArrayList<ArrayList<Node>> list;
	static int output = Integer.MAX_VALUE;
	static class Node implements Comparable<Node>{
		int nodeN;
		int weight;
		
		public Node(int nodeN, int weight) {
			this.nodeN = nodeN;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
        	list.add(new ArrayList<>());
        }
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<M; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	list.get(u).add(new Node(v,w));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start , end);
        
        System.out.println(dist[end]);

    }
    
    static void dijkstra(int start , int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	boolean check[] = new boolean[N + 1];
    	dist[start] = 0;
    	pq.add(new Node(start, 0));
    	
    	while(!pq.isEmpty()) {
    		Node now = pq.poll();
    		int startNum = now.nodeN;
    		
    		if(!check[startNum]) {
    			check[startNum] = true;
    			
    			for(Node node : list.get(startNum)) {
    				
    				if(!check[node.nodeN] && dist[node.nodeN] > (dist[startNum] + node.weight) ) {
    					dist[node.nodeN] = dist[startNum] + node.weight;
    					pq.add(new Node(node.nodeN , dist[node.nodeN]));
    				}
    			}	
    		}
    	}
    }
}
