import java.io.*;
import java.util.*;
public class Main {
	
	static class Road {
		int end;
		int weight;
		Road(int end, int weight){
			this.end = end;
			this.weight = weight;
		}
	}
	static int N, M, W;
	static int dist[];
	static ArrayList<ArrayList<Road>> a;
	static final int INF = 987654321;
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int i=0; i<TC; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	W = Integer.parseInt(st.nextToken());
        	
        	dist = new int[N+1];
        	a = new ArrayList<>();
        	for(int j=0; j<=N; j++) {
        		a.add(new ArrayList<>());
        	}
        	
        	for(int j=0; j<M; j++) {
        		st = new StringTokenizer(br.readLine());
        		int S = Integer.parseInt(st.nextToken());
        		int E = Integer.parseInt(st.nextToken());
        		int T = Integer.parseInt(st.nextToken());
        		a.get(S).add(new Road(E,T));		//도로는 양방향이므로 둘다 값 넣기
        		a.get(E).add(new Road(S,T));
        	}
        	for(int j=0; j<W; j++) {
        		st = new StringTokenizer(br.readLine());
        		int S = Integer.parseInt(st.nextToken());
        		int E = Integer.parseInt(st.nextToken());
        		int T = Integer.parseInt(st.nextToken());
        		a.get(S).add(new Road(E,-T));		//웜홀은 단방향, 시간 줄어드므로 음수로 값 넣기
        	}
        	if(check()) {
            	System.out.println("YES");
        	}
        	else {
        		System.out.println("NO");
        	}
        }
	}
	static boolean check() {			//벨만포드
		Arrays.fill(dist, INF);
		dist[1] = 0;					//시작점 초기화
		boolean update = false;
		
		//시작점 제외(N-1번 동안 최단거리 구하기)
		for(int i=1 ; i<N; i++) {
			update = false;
			
			for(int j=1; j<=N; j++) {
				for(Road road : a.get(j)) {
					if(dist[road.end] > dist[j] + road.weight) {
						dist[road.end] = dist[j] + road.weight; //비교 후 최단거리 갱신
						update = true;
					}
				}
			}
			//갱신이 더이상 일어나지 않으면 반복문 종료
			if(!update) {
				break;
			}
		}
		
		//(개수 - 1) 번 까지 계속 업데이트가 발생할 경우
		//(개수)번도 업데이트 되면 음수 사이클 발생 확인
		if(update) {
			for(int i=1; i<=N; i++) {
				for(Road road : a.get(i)) {
					if(dist[road.end] > dist[i] + road.weight) {
						return true;
						//true 리턴
					}
				}
			}
		}
		
		return false;
	}
}
