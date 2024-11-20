// Numdle in Kotlin
// Nya_Twisuki

import java.util.*

fun main (args: Array<String>) {
    val sc = Scanner(System.`in`)
    val rand = Random()

    println("欢迎来到数兜Numdle小游戏")
    println("由Nya_Twisuki开发")
    println("---------------------------")
    println("规则很简单")
    println("输入一个数字, 猜测随机数")
    println("^ 表示该数和位置均正确;\n- 表示存在这个数, 但位置不对;\n* 表示不存在此数")
    println("你有5次机会, 开始吧")

    println("---------------------------")
    println("请输入位数: ")
    val n : Int = sc.nextInt()

    val num : IntArray = IntArray(n)

    for (i in num.indices) {
        num[i] = rand.nextInt(10)
    }

    println("---------------------------")
    println("游戏开始");
    var isOver : Boolean
    var times : Int = 0

    while (true) {
        println("请输入一个" + n + "位数")
        val inputStr : String = sc.next()
        val guess : IntArray = IntArray(n)

        for (i in guess.indices) {
            guess[i] = inputStr[i].code - '0'.code;
        }

        ++ times
        isOver = true

        for (i in guess.indices) {
            if (guess[i] == num[i]) {
                print("^")
            } else {
                isOver = false

                var isContained : Boolean = false
                for (j in num.indices) {
                    if (guess[i] == num[j]) {
                        isContained = true
                        break
                    }
                }

                if (isContained) {
                    print("-")
                } else {
                    print("*")
                }
            }
        }

        println()
        println("---------------------------")

        if (isOver || times >= 5) {
            break
        }
    }

    if (isOver) {
        println("恭喜您猜对了!")
    } else {
        println("很遗憾, 次数用尽, 答案是")
        for (i in num.indices) {
            print(num[i].toString() + " ")
        }
    }

    println()
}