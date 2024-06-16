#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int fx[4] = {-1,0,0,1};
    int fy[4] = {0,1,-1,0};
    int answer = 0;
    for(int i=0; i<4; i++){
        int nx = h + fx[i];
        int ny = w + fy[i];
        if(nx >= 0 && ny >= 0 && nx < board.size() && ny < board.size()){
            if (board[h][w] == board[nx][ny]){
                answer ++;
            }
        }
    }
    printf("%s\n", board[h][w].c_str());

    return answer;
}