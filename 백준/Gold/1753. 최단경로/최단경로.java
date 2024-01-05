import java.io.*;
import java.util.*;

public class Main {
	static int dist[];
	static ArrayList<ArrayList<Node>> list;
	
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        dist = new int[V+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        list = new ArrayList<>();
        for(int i=0; i<=V; i++) {
        	list.add(new ArrayList<>());
        }
        
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	list.get(u).add(new Node(v,w));
        }
        
        dijkstra(K , V);
        
        for(int i=1; i<=V; i++) {
        	if(dist[i] == Integer.MAX_VALUE) {
        		System.out.println("INF");
        	}
        	else {
        		System.out.println(dist[i]);
        	}
        }
    }
    
    static void dijkstra(int start , int cnt) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	boolean check[] = new boolean[cnt + 1];
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
