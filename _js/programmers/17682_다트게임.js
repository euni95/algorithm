input();

function input() {
	// let dartResult = "1S2D*3T";
	let dartResult = "1D2S#10S";
	// let dartResult = "1D2S0T";
	solution(dartResult);
}

function solution(dartResult) {
	var answer = 0;
	var score = new Array(3);
	var idx = -1;
	var num = "";
	for (var i in dartResult) {
		let temp = dartResult[i];
		if (temp >= "0" && temp <= "9") num += temp;
		else if (temp === "S" || temp === "D" || temp === "T") {
			idx++;
			console.log(num);
			score[idx] = num - "0";
			num = "";
			if (temp === "D") score[idx] *= score[idx];
			else if (temp === "T")
				score[idx] = score[idx] * score[idx] * score[idx];
		} else if (temp === "*") {
			if (idx == 0) score[idx] *= 2;
			else {
				score[idx - 1] *= 2;
				score[idx] *= 2;
			}
		} else if (temp === "#") score[idx] *= -1;
	}
	for (var i in score) answer += score[i];
	return answer;
}
