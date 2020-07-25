var numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];
var hand = "right";
console.log(solution(numbers, hand));

function solution(numbers, hand) {
	var answer = "";
	var left = [3, 0];
	var right = [3, 2];
	var keypad = [
		[3, 1],
		[0, 0],
		[0, 1],
		[0, 2],
		[1, 0],
		[1, 1],
		[1, 2],
		[2, 0],
		[2, 1],
		[2, 2]
	];

	answer = numbers.reduce((acc, cur) => {
		let curX = keypad[cur][0];
		let curY = keypad[cur][1];
		if (cur === 0 || cur % 3 === 2) {
			let tempL = Math.abs(curX - left[0]) + Math.abs(curY - left[1]);
			let tempR = Math.abs(curX - right[0]) + Math.abs(curY - right[1]);

			if (tempL < tempR || (tempL === tempR && hand === "left")) {
				left = [curX, curY];
				return acc + "L";
			} else if (tempL > tempR || (tempL === tempR && hand === "right")) {
				right = [curX, curY];
				return acc + "R";
			}
		} else if (cur % 3 === 1) {
			left = [curX, curY];
			return acc + "L";
		} else {
			console.log(4);
			right = [curX, curY];
			return acc + "R";
		}
	}, "");

	// for (var num of numbers) {
	// 	let curX = keypad[num][0];
	// 	let curY = keypad[num][1];
	// 	if (num === 0 || num % 3 === 2) {
	// 		let tempL = Math.abs(curX - left[0]) + Math.abs(curY - left[1]);
	// 		let tempR = Math.abs(curX - right[0]) + Math.abs(curY - right[1]);

	// 		if (tempL < tempR || (tempL === tempR && hand === "left")) {
	// 			left = [curX, curY];
	// 			answer += "L";
	// 		} else if (tempL > tempR || (tempL === tempR && hand === "right")) {
	// 			right = [curX, curY];
	// 			answer += "R";
	// 		}
	// 	} else if (num % 3 === 1) {
	// 		left = [curX, curY];
	// 		answer += "L";
	// 	} else {
	// 		console.log(4);
	// 		right = [curX, curY];
	// 		answer += "R";
	// 	}
	// }
	return answer;
}
