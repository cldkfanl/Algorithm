#include <string>
#include <vector>

using namespace std;

bool compWallet(vector<int> wallet, vector<int> bill){
    bool not_turn = (wallet[0] >= bill[0] && wallet[1] >= bill[1])?true:false;
    bool turn = (wallet[1] >= bill[0] && wallet[0] >= bill[1])?true:false;
    
    if(not_turn || turn){
        return true;
    }
    else{
        return false;
    }
}


int solution(vector<int> wallet, vector<int> bill) {
    int cnt = 0;
    while(true){
        if(compWallet(wallet, bill)){
            break;
        }
        if(bill[0] >= bill[1]){
            bill[0] /= 2;
        }
        else{
            bill[1] /= 2;
        }
        cnt++;
    }
    return cnt;
}