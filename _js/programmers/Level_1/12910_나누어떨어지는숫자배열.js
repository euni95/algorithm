var arr = [5, 9, 7, 10];
var divisor = 5;
console.log(solution(arr, divisor));
function solution(arr, divisor) {
	var answer = arr
		.sort((a, b) => a - b)
		.reduce((acc, cur, idx) => {
			if (cur % divisor == 0) acc.push(cur);
			return acc;
		}, []);
	return answer.length == 0 ? [-1] : answer;
}
