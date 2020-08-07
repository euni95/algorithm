var land = [
	[1, 2, 3, 5],
	[5, 6, 7, 8],
	[4, 3, 2, 1]
];
console.log(solution(land));
function solution(land) {
	var rows = land.length;
	var arr = new Array(0, 0, 0, 0);
	for (var i = 0; i < rows; i++) {
		var t1 = land[i][0] + Math.max(arr[1], arr[2], arr[3]);
		var t2 = land[i][1] + Math.max(arr[0], arr[2], arr[3]);
		var t3 = land[i][2] + Math.max(arr[0], arr[1], arr[3]);
		var t4 = land[i][3] + Math.max(arr[0], arr[1], arr[2]);

		arr[0] = t1;
		arr[1] = t2;
		arr[2] = t3;
		arr[3] = t4;
	}
	return Math.max(arr[0], arr[1], arr[2], arr[3]);
}
