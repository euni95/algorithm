var s = "try hello world";
console.log(solution(s));
function solution(s) {
	s = s.split("");
	var idx = 0;
	for (var i = 0; i < s.length; i++) {
		if (s[i] === " ") {
			idx = 0;
			continue;
		}
		if (idx % 2 == 0) s[i] = s[i].toUpperCase();
		else s[i] = s[i].toLowerCase();
		idx++;
	}
	return s.join("");
}
