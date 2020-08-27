var n = 987;
console.log(solution(n));
function solution(n) {
	var answer = 0;

	// n = n
	// 	.toString()
	// 	.split("")
	// 	.reduce((acc, val) => {
	// 		return acc + Number(val);
	// 	}, 0);

	while (n >= 1) {
		answer += n % 10;
		n = Math.floor(n / 10);
	}

	return answer;
}
