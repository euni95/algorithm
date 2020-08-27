var arr = [4, 3, 2, 1, 33];
console.log(solution(arr));
function solution(arr) {
	if (arr.length === 1) return [-1];
	arr.splice(
		arr.reduce((acc, cur, idx) => {
			if (arr[acc] > cur) return idx;
			return acc;
		}, 0),
		1
	);
	return arr;
}
