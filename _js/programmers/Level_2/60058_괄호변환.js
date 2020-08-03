var w = "()))((()";
console.log(solution(w));
function solution(w) {
	var answer = "";

	answer = splitStr(w);
	return answer;
}

function splitStr(w) {
	if (w.length === 0) return "";

	var a = 0,
		b = 0,
		c = 0;
	var u = "",
		v = "";
	var check = true;

	for (var i in w) {
		if (w[i] === "(") {
			a++;
			c++;
		} else {
			b++;
			if (c === 0) check = false;
			c--;
		}
		if (a === b) {
			u = w.substr(0, +i + 1);
			v = w.substr(+i + 1, w.length);
			console.log(u, v);
			break;
		}
	}

	if (check) return u + splitStr(v);
	else {
		var temp = "(";
		temp += splitStr(v);
		temp += ")";
		console.log(u);
		u = u.substr(1, u.length - 2).split("");
		console.log(u);
		for (var i in u) {
			if (u[i] == "(") u[i] = ")";
			else u[i] = "(";
		}
		u = u.join("");
		return temp + u;
	}
}
