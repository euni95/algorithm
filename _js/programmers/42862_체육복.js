input();

function input() {
	let n = 5;
	// 체육복을 도난당한 학생들
	let lost = [3];
	// 여벌의 체육복을 가져온 학생들
	let reserve = [3];
	solution(n, lost, reserve);
}

function solution(n, lost, reserve) {
	var cnt = n - lost.length;
	var check = new Array();
	for (var i = 0; i <= n; i++) check[i] = true;
	for (var i in lost) check[lost[i]] = false;
	for (var i in reserve) {
		let temp = reserve[i];
		if (!check[temp]) {
			check[temp] = true;
			cnt++;
			reserve[i] = -1;
		}
	}
	for (var i in reserve) {
		let temp = reserve[i];
		if (temp === -1) continue;
		if (temp > 1 && !check[temp - 1]) {
			check[temp - 1] = true;
			cnt++;
		} else if (temp < n && !check[temp + 1]) {
			check[temp + 1] = true;
			cnt++;
		}
	}
	return cnt;
}
