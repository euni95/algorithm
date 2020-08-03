var number = "1924";
var k = 2;
var max = 0;
console.log(solution(number, k));
function solution(number, k) {
	var idx = 1;
	while (true) {
		if (idx >= number.length || k <= 0) break;
		if (number[idx - 1] < number[idx]) {
			var cnt = 1;
			for (var i = idx - 2; i >= 0; i--) {
				if (number[i] < number[idx]) cnt++;
				else break;
			}
			number =
				number.substr(0, idx - Math.min(k, cnt)) +
				number.substr(idx, number.length);
			idx -= cnt;
			k -= cnt;
		} else {
			idx++;
		}
	}
	if (k > 0) number = number.substr(0, number.length - k);
	console.log(number);
	return number;
}

// function solution(number, k) {
// 	let stack = [],
// 		i;
// 	for (i = 0; i < number.length && k > 0; i++) {
// 		let num = number[i];
// 		while (k > 0 && stack[stack.length - 1] < num) {
// 			stack.pop();
// 			k--;
// 		}
// 		stack.push(num);
// 	}
// 	if (k > 0) stack.splice(stack.length - k);
// 	return stack.join("") + number.slice(i);
// }
