#include<iostream>
#include<queue>
#include<algorithm>
#include<math.h>
using namespace std;




int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, L;

    cin >> N >> L;
    // 과일 개수 최대값, 초기화
    int arr[1001] = {};

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    // 정렬
    sort(arr, arr + 1001);

    // 과일의 높이가 0이 아닌경우 && 뱀의 크기보다 큰 경우에만
    for (int i = 0; i <= 1000; i++) {
        if (arr[i] != 0) {
            if (L >= arr[i]) {
                //과일 섭취(L값 증가)
                L++;
            }
        }
    }
    cout << L << endl;
    return 0;
}
