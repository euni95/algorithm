console.log(solution(12345));
function solution(n) {
	var answer = [];
	// console.log(n.toString().length);
	var len = n.toString().length;
	for (var i = 0; i < len; i++) {
		answer.push(n % 10);
		n = Math.floor(n / 10);
		// console.log(n);
	}
	return answer;
}
