#include <iostream>
#include <vector>
using namespace std;

vector<bool> prime(1000001,true);

void era()
{
	for (long long i = 2; i*i <= 1000000; i++)
	{
		for (long long j = i * i; j <= 1000000; j += i)
		{
			prime[j] = false;
		}
	}
}

int main()
{
	era();
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);
	while (1)
	{
		long long n = 0;
		cin >> n;
		if (n == 0)
			break;
		for (long long i = 2; i <= n; i++)
		{
			if ((prime[i] == true) && (prime[n - i] == true))
			{
				cout << n << " = " << i << " + " << n - i <<'\n';
				break;
			}
		}
	}
}