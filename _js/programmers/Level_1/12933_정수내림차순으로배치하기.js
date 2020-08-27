var n = 118372;
console.log(solution(n));
function solution(n) {
	// return Number(
	// 	n
	// 		.toString()
	// 		.split("")
	// 		.sort((a, b) => b - a)
	// 		.join("")
	// );

	var answer = [];
	// console.log(n.toString().length);
	var len = n.toString().length;
	for (var i = 0; i < len; i++) {
		answer.push(n % 10);
		n = Math.floor(n / 10);
		// console.log(n);
	}
	return Number(answer.sort((a, b) => b - a).join(""));
}
