var answers = [1, 2, 3, 4, 5];
console.log(solution(answers));
function solution(answers) {
	var one = [1, 2, 3, 4, 5];
	var two = [2, 1, 2, 3, 2, 4, 2, 5];
	var three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

	var cnt = [0, 0, 0];
	var max = 0;
	for (var i in answers) {
		let temp = answers[i];
		if (temp === one[i % one.length]) cnt[0]++;
		if (temp === two[i % two.length]) cnt[1]++;
		if (temp === three[i % three.length]) cnt[2]++;
		max = Math.max(cnt[0], cnt[1], cnt[2]);
	}
	// console.log(cnt);
	return cnt.reduce((acc, cur, idx) => {
		if (max === cur) acc.push(idx + 1);
		return acc;
	}, []);
}
