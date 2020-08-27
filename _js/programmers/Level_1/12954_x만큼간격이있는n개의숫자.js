var x = -4;
var n = 2;
console.log(solution(x, n));
function solution(x, n) {
	var answer = [];
	for (var i = 1; i <= n; i++) {
		answer.push(x * i);
	}
	return answer;
}
