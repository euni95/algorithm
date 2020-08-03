var n = 9;
console.log(solution(n));

function solution(n) {
	var answer = "";
	var numbers = ["4", "1", "2", "4"];
	var temp = 0;
	var idx = 1;

	if (n < 4) return numbers[n];

	while (true) {
		if (temp > n) {
			idx--;
			break;
		}
		temp += Math.pow(3, idx++);
	}
	var cnt = idx - 1;
	var cur = n - (temp - Math.pow(3, idx));
	while (true) {
		if (cnt < 0) break;
		answer += numbers[Math.ceil(cur / Math.pow(3, cnt))];
		cur %= Math.pow(3, cnt);
		cnt--;
	}
	return answer;
}
