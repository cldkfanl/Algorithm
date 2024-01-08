import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N , M, K;
	static int arr[][], feed[][];
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0 ,1, -1, 1, -1, 0, 1};
	static class Tree implements Comparable<Tree> {
		int x, y, z;

		public Tree(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z= z;
		}

		@Override
		public int compareTo(Tree o) {
			return this.z - o.z;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        feed = new int[N][N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		feed[i][j] = 5;
        	}
        }
        Deque<Tree> trees = new LinkedList<>();
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
    		int x= Integer.parseInt(st.nextToken());
    		int y= Integer.parseInt(st.nextToken());
    		int z= Integer.parseInt(st.nextToken());
    		
    		trees.add(new Tree(x-1,y-1,z));
        }
        while(K > 0) {
        	Queue<Tree> die_tree = new LinkedList<>();
        	
        	for(int i=0; i<trees.size();) {
        		Tree cur = trees.poll();
        		if(feed[cur.x][cur.y] >= cur.z) {
        			feed[cur.x][cur.y] -= cur.z;
        			cur.z ++;
        			i++;
        			trees.add(cur);
        		}
        		else {
        			die_tree.add(cur);
        		}
        	}
        	for(Tree t : die_tree) {
        		feed[t.x][t.y] += t.z/2;
        	}
        	Queue<Tree> tmp = new LinkedList<>();
        	for(Tree t : trees) {
        		if(t.z % 5 == 0) {
        			tmp.add(t);
        		}
        	}
        	while(!tmp.isEmpty()) {
        		Tree t = tmp.poll();
        		for(int i=0; i<8; i++) {
    				int nx = t.x + dr[i];
    				int ny = t.y + dc[i];
    				if(nx >= 0 && nx < N && ny >=0 && ny < N) {
    					trees.addFirst(new Tree(nx, ny, 1));
    				}
        		}
        	}
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			feed[i][j] += arr[i][j];
        		}
        	}
        	K--;
        }
        System.out.println(trees.size());
	}
}
