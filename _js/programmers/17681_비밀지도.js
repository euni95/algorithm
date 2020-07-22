input();

function input() {
	let n = 6;
	let arr1 = [46, 33, 33, 22, 31, 50];
	let arr2 = [27, 56, 19, 14, 14, 10];
	solution(n, arr1, arr2);
}

function solution(n, arr1, arr2) {
	var map = [];
	for (var i = 0; i < n; i++) {
		let temp = dec2bin(arr1[i] | arr2[i]);
		console.log(temp);
		let result = "";
		for (var j = 0; j < n - temp.length; j++) result += " ";
		for (var j = 0; j < temp.length; j++) {
			if (temp.charAt(j) === "1") result += "#";
			else result += " ";
		}
		map[i] = result;
	}

	console.log(map);
	return map;
}

function dec2bin(dec) {
	return (dec >>> 0).toString(2);
}
