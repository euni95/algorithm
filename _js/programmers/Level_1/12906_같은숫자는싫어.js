var arr = [1, 1, 3, 3, 0, 1, 1];
console.log(solution(arr));
function solution(arr) {
	var answer = [arr[0]];
	var before = arr[0];
	for (var i = 1; i < arr.length; i++) {
		if (before != arr[i]) answer.push(arr[i]);
		before = arr[i];
	}
	return answer;

	// return arr.filter((value, index) => value != arr[index-1]);
}
