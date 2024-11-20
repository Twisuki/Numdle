// Numdle in Java
// Nya_Twisuki

import java.util.Scanner;

class Numdle {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("欢迎来到数兜Numdle小游戏");
        System.out.println("由Nya_Twisuki开发");
        System.out.println("---------------------------");
        System.out.println("规则很简单");
        System.out.println("输入一个数字, 猜测随机数");
        System.out.println("^ 表示该数和位置均正确;\n- 表示存在这个数, 但位置不对;\n* 表示不存在此数");
        System.out.println("你有5次机会, 开始吧");

        int n;
        System.out.println("---------------------------");
        System.out.println("请输入位数: ");
        n = input.nextInt();

        int[] num = new int[n];
        for (int i = 0; i < n; ++ i) {
            num[i] = (int)(Math.random() * 10);
        }

        System.out.println("---------------------------");
        System.out.println("游戏开始");
        boolean isOver;
        int times = 0;

        while (true) {
            System.out.println("请输入一个" + n + "位数");
            String inputStr = input.next();
            int[] guess = new int[n];

            for (int i = 0; i < n; ++ i) {
                guess[i] = inputStr.charAt(i) - '0';
            }

            ++ times;
            isOver = true;
            for (int i = 0; i < n; ++ i) {
                if (guess[i] == num[i]) {
                    System.out.print("^");
                } else {
                    isOver = false;

                    boolean isContained = false;
                    for (int j = 0; j < n; ++ j) {
                        if (guess[i] == num[j]) {
                            isContained = true;
                            break;
                        }
                    }

                    if (isContained) {
                        System.out.print("-");
                    } else {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
            System.out.println("---------------------------");

            if (isOver || times >= 5) {
                break;
            }
        }

        if (isOver) {
            System.out.println("恭喜您猜对了!");
        } else {
            System.out.println("很遗憾, 次数用尽, 答案是");
            for (int i = 0; i < n; ++ i) {
                System.out.print(num[i] + " ");
            }
        }

        System.out.println();
    }
}