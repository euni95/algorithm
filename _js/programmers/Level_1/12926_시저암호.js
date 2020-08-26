var s = "AB";
var n = 1;
console.log(solution(s, n));
function solution(s, n) {
	return s
		.split("")
		.map(val => {
			let charCode = val.charCodeAt();

			if (charCode >= 65 && charCode <= 90) {
				return String.fromCharCode(((charCode - 65 + n) % 26) + 65);
			} else if (charCode >= 97 && charCode <= 122) {
				return String.fromCharCode(((charCode - 97 + n) % 26) + 97);
			} else return val;
		})
		.join("");
}
