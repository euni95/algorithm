var s = "234 ";
console.log(solution(s));
function solution(s) {
	if (s.length != 4 && s.length != 6) return false;
	for (var i of s) if (isNaN(i)) return false;
	return true;
}
