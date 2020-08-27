var n = 3;
var m = 12;
console.log(solution(n, m));
function solution(n, m) {
	var lcm = n * m;
	if (n > m) [n, m] = [m, n];
	while (true) {
		if (m == 0) break;
		[n, m] = [m, n % m];
	}
	return [n, lcm / n];
}
