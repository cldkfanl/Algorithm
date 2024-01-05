import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
	    int end;
	    int weight;
	    
	    Node(int end, int weight){
	    	this.end = end;
	    	this.weight = weight;
	    }
	 
	    @Override
	    public int compareTo(Node o) {
	        return weight - o.weight;
	    }
	}
	static int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<ArrayList<Node>> list = new ArrayList<>();
	static List<ArrayList<Node>> back = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        back = new ArrayList<>();
        for(int i=0; i<=N; i++) {
        	list.add(new ArrayList<>());
        	back.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int T = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new Node(end, T));
        	back.get(end).add(new Node(start, T));
        }
        int firout[] = dij(list);
        int laout[] = dij(back);
        
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
        	max = Math.max(max, firout[i] + laout[i]);
        }
        
        System.out.println(max);
        
    }
    static int[] dij(List<ArrayList<Node>> list) {
    	PriorityQueue<Node> que = new PriorityQueue<>();
    	
    	boolean visit[] = new boolean[N+1];
    	int dist[] = new int[N+1];
    	Arrays.fill(dist, INF);
    	dist[X] = 0;
    	que.offer(new Node(X,0));
    	
    	
    	while(!que.isEmpty()) {
    		Node now = que.poll();
    		int num = now.end;
    		if(visit[num]) {
    			continue;
    		}
    		visit[num] = true;
    		for(Node node : list.get(num)) {
    			if(!visit[node.end] && dist[node.end] > (dist[num] + node.weight)) {
    				dist[node.end] = dist[num] + node.weight;
    				que.offer(new Node(node.end , dist[node.end]));
    			}
    		}
    		
    	}
    	return dist;
    }
}
