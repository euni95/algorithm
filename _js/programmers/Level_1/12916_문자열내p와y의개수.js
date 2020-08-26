var s = "pPoooyY";
console.log(solution(s));
function solution(s) {
	s = s.toUpperCase();
	var cnt = 0;
	for (var i of s) {
		if (i == "P") cnt++;
		else if (i == "Y") cnt--;
	}
	return cnt == 0 ? true : false;
}
