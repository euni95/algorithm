var n = 121;
console.log(solution(n));
function solution(n) {
	n = Math.sqrt(n);
	return Number.isInteger(n) ? Math.pow(n + 1, 2) : -1;
}
