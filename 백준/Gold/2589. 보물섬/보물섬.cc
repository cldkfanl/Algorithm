#include<iostream>
#include<fstream>
#include<vector>
#include<queue>
using namespace std;
int N, M;
int arr[51][51];
int arr2[51][51];
bool check[51][51];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int tmp = 0;

int lencheck(int x, int y){
    queue <pair<int,int>> q;
    q.push({x,y});
    check[x][y] = true;
    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();

        for(int i=0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny] && arr[nx][ny] == 1){
                check[nx][ny] = true;
                arr2[nx][ny] = arr2[cx][cy] + 1;
                q.push({nx,ny});
                tmp = max(tmp, arr2[nx][ny]);
            }
        }
    }
    return tmp;
}

void reset(){
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            check[i][j] = false;
            arr2[i][j] = 0;
        }
    }
}
int main(){
    cin>>N>>M;
    for(int i=0; i<N; i++){
        string input;
        cin >> input;
        for(int j=0; j<M; j++){
            if(input[j] == 'W'){
                arr[i][j] = 0;
            }
            else{
                arr[i][j] = 1; //육지면 1
            }
        }

    }
    int lenmax = 0;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(arr[i][j] == 1){
                reset();
                int tmp = lencheck(i,j);
                lenmax = max(lenmax, tmp);
            }
        }
    }
    
    cout << lenmax<<endl;

    return 0;
}