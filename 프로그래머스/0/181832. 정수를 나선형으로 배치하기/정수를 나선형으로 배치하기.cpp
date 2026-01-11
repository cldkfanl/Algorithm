#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n, vector<int>(n,0));
    
    const int dr[4] = {0,1,0,-1};
    const int dc[4] = {1,0,-1,0};
    
    int n_col = 0;
    int n_row = 0;
    int dir = 0;
    
    for(int i = 1; i <= n * n ; ++ i){
        answer[n_row][n_col] = i;
        
        int nc = n_col + dc[dir];
        int nr = n_row + dr[dir];
        
        if(nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] != 0){
            dir = (dir + 1) % 4;
            nc = n_col + dc[dir];
            nr = n_row + dr[dir];
        }
        
        n_col = nc;
        n_row = nr;
    }
    return answer;
}