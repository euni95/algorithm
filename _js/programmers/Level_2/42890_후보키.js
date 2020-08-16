var relation = [
	["100", "ryan", "music", "2"],
	["200", "apeach", "math", "2"],
	["300", "tube", "computer", "3"],
	["400", "con", "computer", "4"],
	["500", "muzi", "music", "3"],
	["600", "apeach", "music", "2"]
];
console.log(solution(relation));
function solution(relation) {
	var relCnt = relation.length;
	var colCnt = relation[0].length;
	var keys = [];
	for (var i = 1; i < (1 << colCnt) - 1; i++) {
		let comb = new Array(colCnt).fill(false);
		let combCnt = 0;
		for (var j = 0; j < colCnt; j++) {
			if ((i & (1 << j)) > 0) {
				comb[j] = true;
				combCnt++;
			}
		}
		console.log(comb);
		let check = true;
		for (var j = 0; j < keys.length; j++) {
			let cnt = 0;
			for (var k in keys[j]) {
				if (comb[k] && keys[j][k]) {
					cnt++;
				}
			}
			if (cnt === keys[j][colCnt]) {
				check = false;
				break;
			}
		}
		if (!check) continue;
		check = true;
		let arr = [];

		for (var j = 0; j < relCnt; j++) {
			let str = "";
			for (var k = 0; k < colCnt; k++) {
				if (!comb[k]) continue;
				str += relation[j][k];
			}
			if (arr.includes(str)) {
				check = false;
				break;
			}
			arr.push(str);
		}
		if (check) {
			comb.push(combCnt);
			keys.push(comb);
		}
	}
	return keys.length == 0 ? 1 : keys.length;
}
