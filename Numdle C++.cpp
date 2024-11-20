// Numdle in cpp
// Nya_Twisuki

#include <iostream>
#include <vector>
#include <string>
#include <random>
using namespace std;

int main () {
	cout << "欢迎来到数兜Numdle小游戏" << endl;
	cout << "由Nya_Twisuki开发" << endl;
	cout << "---------------------------" << endl;
	cout << "规则很简单" << endl;
	cout << "输入一个数字, 猜测随机数" << endl;
	cout << "^ 表示该数和位置均正确;\n- 表示存在这个数, 但位置不对;\n* 表示不存在此数" << endl;
	cout << "你有5次机会, 开始吧" << endl;

	int n;
	cout << "---------------------------" << endl;
	cout << "请输入位数: " << endl;
	cin >> n;

	vector<int> num(n);

	random_device rd;
	mt19937 genRand(rd());

	for (int i = 0; i < n; ++ i) {
		num[i] = genRand() % 10;
	}

	cout << "---------------------------" << endl;
	cout << "游戏开始" << endl;
	bool isOver;
	int times = 0;

	while (true) {
		cout << "请输入一个" << n << "位数" << endl;
		vector<int> guess(n);
		++ times;
		string line;
		cin >> line;
		for (int i = 0; i < n; ++ i) {
			guess[i] = line[i] - '0';
		}

		isOver = true;
		for (int i = 0; i < n; ++ i) {
			if (guess[i] == num[i]) {
				cout << "^";
			} else {
				isOver = false;

				bool contain = false;
				for (int j = 0; j < n; ++ j) {
					if (guess[i] == num[j]) {
						contain = true;
					}
				}

				if (contain) {
					cout << "-";
				} else {
					cout << "*";
				}
			}
		}
		cout << endl;
		cout << "---------------------------" << endl;

		if (isOver || times >= 5) {
			break;
		}
	}

	if (isOver) {
		cout << "恭喜您猜对了!";
	} else {
		cout << "很遗憾, 次数用尽, 答案是";
		for (int i = 0; i < n; ++ i) {
			cout << num[i] << " ";
		}
	}

	cout << endl;
	system("pause");
	return 0;
}