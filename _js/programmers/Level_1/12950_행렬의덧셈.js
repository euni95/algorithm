var arr1 = [
	[1, 2],
	[2, 3]
];
var arr2 = [
	[3, 4],
	[5, 6]
];
console.log(solution(arr1, arr2));
function solution(arr1, arr2) {
	for (var i = 0; i < arr1.length; i++) {
		for (var j = 0; j < arr1[0].length; j++) {
			arr1[i][j] += arr2[i][j];
		}
	}
	return arr1;
}
