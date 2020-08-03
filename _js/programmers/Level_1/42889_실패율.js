let N = 5;
let stages = [2, 1, 2, 6, 2, 4, 3, 3];

console.log(solution(N, stages));

function solution(N, stages) {
	var answer = [];
	var score = [];
	for (var i = 0; i < N; i++) score[i] = [0, i + 1];
	for (var i = 0; i < stages.length; i++) {
		var temp = stages[i] - 1;
		if (temp === N) continue;
		score[temp][0]++;
	}

	var remain = stages.length;
	for (var i = 0; i < N; i++) {
		if (remain <= 0) break;
		var temp = score[i][0];
		score[i][0] = temp / remain;
		remain -= temp;
	}

	score.sort(function (a, b) {
		if (b[0] === a[0]) return a[1] - b[1];
		return b[0] - a[0];
	});

	answer = score.map(e => e[1]);
	return answer;
}
