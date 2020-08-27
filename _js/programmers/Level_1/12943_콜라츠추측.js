var num = 6;
console.log(solution(num));
function solution(num) {
	var answer = 0;
	while (true) {
		if (num === 1 || answer === 500) break;
		if (num % 2 == 0) num /= 2;
		else num = num * 3 + 1;
		answer++;
	}
	return answer === 500 ? -1 : answer;
}
