var lines = ["2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"];
console.log(solution(lines));
function solution(lines) {
	lines = lines.map((value, idx) => {
		let endDate = new Date(value.substr(0, 23)).getTime();
		let startDate = endDate - value.substring(24, lines[idx].length - 1) * 1000 + 1;
		return [startDate, endDate];
	});
	console.log(lines);
	// lines.sort((a, b) => {
	// 	return a[0] - b[0];
	// });

	var max = 0;
	for (var i = 0; i < lines.length; i++) {
		let endTime = lines[i][1] + 999;
		let cnt = 1;
		for (var j = i + 1; j < lines.length; j++) {
			let startTime = lines[j][0];
			if (startTime <= endTime) {
				cnt++;
			}
		}
		max = Math.max(max, cnt);
	}
	return max;
}
