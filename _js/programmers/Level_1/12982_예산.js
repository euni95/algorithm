var d = [3, 3, 3, 5, 4];
var budget = 9;
console.log(solution(d, budget));

function solution(d, budget) {
	var answer = 0;
	d.sort((a, b) => a - b);
	for (var i in d) {
		budget -= d[i];
		if (budget < 0) break;
		answer++;
	}

	// var i = 0;
	// var sum = 0;
	// while (true) {
	// 	sum += d[i++];
	// 	if (sum > budget || i > d.length) break;
	// 	answer++;
	// }
	return answer;
}
