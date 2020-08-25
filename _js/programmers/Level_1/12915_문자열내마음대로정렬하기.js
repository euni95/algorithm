var strings = ["abce", "abcd", "cdx"];
var n = 1;
console.log(solution(strings, n));
function solution(strings, n) {
	return strings.sort((a, b) => {
		let temp = a[n].localeCompare(b[n]);
		if (temp == 0) return a.localeCompare(b);
		else return temp;
	});
}
