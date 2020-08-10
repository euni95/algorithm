var n = 15;
console.log(solution(n));
function solution(n) {
	var cnt = 0;
	for (var i = 1; i < n; i++) {
		var temp = i;
		for (var j = i + 1; j < n; j++) {
			temp += j;
			if (temp > n) break;
			if (temp === n) {
				cnt++;
				break;
			}
		}
	}
	return cnt + 1;
}
