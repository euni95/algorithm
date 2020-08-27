var arr = [1, 2, 3, 4];
console.log(solution(arr));
function solution(arr) {
	return arr.reduce((acc, cur) => acc + cur) / arr.length;
}
