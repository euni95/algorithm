var s = "qwer";
console.log(solution(s));
function solution(s) {
	var len = s.length;
	return len % 2 == 0 ? s.substr(len / 2 - 1, 2) : s.substr(len / 2, 1);
}
