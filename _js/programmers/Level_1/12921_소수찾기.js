var n = 10;
console.log(solution(n));
function solution(n) {
	var answer = n - 1;
	var arr = new Array(n + 1).fill(0).map((val, idx) => idx);
	for (var i = 2; i <= Math.sqrt(n); i++) {
		if (arr[i] == 0) continue;

		for (var j = i * 2; j <= n; j += i) {
			if (arr[j] == 0) continue;
			arr[j] = 0;
			answer--;
		}
	}
	console.log(arr);
	return answer;
}

//https://marobiana.tistory.com/91
