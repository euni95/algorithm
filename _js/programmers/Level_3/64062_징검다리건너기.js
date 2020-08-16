var stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1];
var k = 3;
console.log(solution(stones, k));
function solution(stones, k) {
	var answer = 0;
	var left = 0;
	var right = 200000000;

	while (left <= right) {
		let mid = Math.ceil((left + right) / 2);
		if (check(mid - 1, stones, k)) {
			answer = Math.max(answer, mid);
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	return answer;
}

function check(m, stones, k) {
	var cnt = 0;
	for (var i = 0; i < stones.length; i++) {
		let temp = stones[i] - m;
		if (temp <= 0) {
			cnt++;
			if (cnt === k) return false;
		} else cnt = 0;
	}
	return true;
}
