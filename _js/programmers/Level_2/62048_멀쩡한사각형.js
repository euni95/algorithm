var w = 8;
var h = 12;
console.log(solution(w, h));
function solution(w, h) {
	var answer = 1;
	if (w > h) [w, h] = [h, w];
	answer = gcd(h, w);
	return w * h - (w + h - answer);
}

function gcd(a, b) {
	return b === 0 ? a : gcd(b, a % b);
}
