var n = 5;
console.log(solution(n));
function solution(n) {
	return n % 2 == 0 ? "수박".repeat(Math.ceil(n / 2)) : "수박".repeat(Math.ceil(n / 2)).substr(0, n);
}
