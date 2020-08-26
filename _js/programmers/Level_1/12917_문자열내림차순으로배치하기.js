var s = "Zbcdefg";
console.log(solution(s));
function solution(s) {
	return s
		.split("")
		.sort((a, b) => (a > b ? -1 : 1))
		.join("");
}
