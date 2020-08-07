var citations = [3, 0, 6, 1, 5];
console.log(solution(citations));
function solution(citations) {
	citations.sort((a, b) => {
		return a - b;
	});

	var len = citations.length;
	var h = citations.length;
	for (var i in citations) {
		var temp = citations[i];
		console.log(temp, len - i);
		if (temp > len - i) break;
		h = len - i;
	}
	return h;
}
