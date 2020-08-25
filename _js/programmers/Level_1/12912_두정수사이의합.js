var a = 3,
	b = 5;
console.log(solution(a, b));
function solution(a, b) {
	var answer = 0;
	return ((a + b) * ((a < b ? b - a : a - b) + 1)) / 2;
}
