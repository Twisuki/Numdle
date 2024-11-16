# Numdle in cpp
# Nya_Twisuki

import random

print("欢迎来到数兜Numdle小游戏")
print("由Nya_Twisuki开发")
print("---------------------------")
print("规则很简单")
print("^表示该数和位置均正确;\n - 表示存在这个数, 但位置不对;\n * 表示不存在此数")
print("你有5次机会, 开始吧")

print("---------------------------")

n = int(input("请输入位数: "))

num = [random.randint(0, 9) for _ in range(n)]

print("---------------------------")
print("游戏开始")

isOver = True
times = 0

while True :
    times += 1

    input_str = input(f"请输入一个{n}位数\n")
    guess = [int(_) for _ in input_str]

    isOver = True
    for i in range(n) :
        if guess[i] == num[i] :
            print("^", end="")
        else :
            isOver = False

            isContained = False
            for j in range(n) :
                if guess[i] == num[j] :
                    isContained = True

            if isContained :
                print("-", end="")
            else :
                print("*", end="")

    print()
    print("---------------------------")

    if isOver or times >= 5 :
        break

if isOver :
    print("恭喜您猜对了!")
else :
    print(f"很遗憾, 次数用尽, 答案是", end="")
    for i in range(n) :
        print(num[i], end=" ")
    print()
