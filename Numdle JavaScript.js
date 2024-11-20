// Numdle in JavaScript
// Nya_Twisuki

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

console.log("欢迎来到数兜Numdle小游戏");
console.log("由Nya_Twisuki开发");
console.log("---------------------------");
console.log("规则很简单");
console.log("输入一个数字, 猜测随机数");
console.log("^ 表示该数和位置均正确;\n- 表示存在这个数, 但位置不对;\n* 表示不存在此数");
console.log("你有5次机会, 开始吧");

console.log("---------------------------");

rl.question("请输入位数: ", (answer) => {
	n = parseInt(answer, 10);
	
	var num = [];
	for (let i = 0; i < n; ++ i) {
		num[i] = Math.trunc(10 * Math.random());
	}
	
	console.log("---------------------------");
	console.log("游戏开始")
	
	isOver = false;
	times = 0;
	
	game();
	
	if (isOver) {
		console.log("恭喜您猜对了!");
	} else {
		console.log("很遗憾, 次数用尽, 答案是");
		console.log(num.join(''));
	}
	
	rl.close();
});

function game () {
	rl.question("请输入一个" + n + "位数 :\n", (answer) => {
		const guess = answer.split('').map(Number);
		
		isOver = true;
		
		const result = [];
		for (let i = 0; i < n; i ++) {
			if (guess[i] == num[i]) {
				result.push('^');
			} else {
				isOver = false;
				let isContained = false;
				
				for (let j = 0; j < n; j ++) {
					if (guess[i] == num[j]) {
						isContained = true;
						break;
					}
				}
				
				result.push(isContained ? '-' : '*');
			}
		}
	
		console.log(result.join(''));
		console.log("---------------------------");
		times ++;
		
		if (! isOver && times < 5) {
			game();
		}
	});
	
}
	

