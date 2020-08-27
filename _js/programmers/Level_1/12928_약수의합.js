var n = 5;
console.log(solution(n));
function solution(n) {
	if (n == 0 || n == 1) return n;
	var answer = n + 1;
	for (var i = 2; i <= n / 2; i++) {
		if (n % i == 0) answer += i;
	}
	return answer;
}
