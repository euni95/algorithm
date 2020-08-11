var msg = "TOBEORNOTTOBEORTOBEORNOT";
console.log(solution(msg));
function solution(msg) {
	var answer = [];
	var index = [];
	for (var i = 0; i <= 26; i++) {
		index[i] = String.fromCharCode(i + 64);
	}

	var len = msg.length;
	for (var i = 0; i < len; i++) {
		var temp = 0,
			check = false;
		for (var j = +i + 1; j <= len; j++) {
			if (index.includes(msg.substring(i, j))) {
				temp = index.indexOf(msg.substring(i, j));
			} else {
				check = true;
				index.push(msg.substring(i, j)) - 1;
				i = +j - 2;
				break;
			}
		}
		if (!check) i = +j - 2;
		answer.push(temp);
	}
	return answer;
}
