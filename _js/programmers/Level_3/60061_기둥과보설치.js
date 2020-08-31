var n = 5;
var build_frame = [
	[0, 0, 0, 1],
	[2, 0, 0, 1],
	[4, 0, 0, 1],
	[0, 1, 1, 1],
	[1, 1, 1, 1],
	[2, 1, 1, 1],
	[3, 1, 1, 1],
	[2, 0, 0, 0],
	[1, 1, 1, 0],
	[2, 2, 0, 1]
]; // [가로좌표, 세로좌표, 0 : 기둥, 1 : 보, 0 : 삭제, 1 : 설치]
console.log(solution(n, build_frame));
function solution(n, build_frame) {
	// return [기둥과 보의 교차점 좌표, 구조물 종류]

	// 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
	// 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.

	var pillar = [],
		barrage = [];
	for (var i = 0; i <= n; i++) {
		pillar[i] = new Array(n + 1).fill(0);
		barrage[i] = new Array(n + 1).fill(0); // 기둥, 보
	}
	for (var i = 0; i < build_frame.length; i++) {
		var y = build_frame[i][0];
		var x = build_frame[i][1];
		var isBarrage = build_frame[i][2];
		var isBuild = build_frame[i][3];

		if (isBarrage === 1) {
			if (isBuild === 1) {
				if (checkBarrage(n, x, y, pillar, barrage)) {
					barrage[x][y] = 1;
				}
			} else {
				barrage[x][y] = 0;
				if (!remove(n, barrage, pillar)) {
					barrage[x][y] = 1;
				}
			}
		} else {
			if (isBuild === 1) {
				if (checkPillar(n, x, y, pillar, barrage)) {
					pillar[x][y] = 1;
				}
			} else {
				pillar[x][y] = 0;
				if (!remove(n, barrage, pillar)) {
					pillar[x][y] = 1;
				}
			}
		}
	}

	var answer = [];
	for (var j = 0; j <= n; j++) {
		for (var i = 0; i <= n; i++) {
			if (pillar[i][j] === 1) {
				answer.push([j, i, 0]);
			}
			if (barrage[i][j] === 1) {
				answer.push([j, i, 1]);
			}
		}
	}

	return answer;
}

function remove(n, barrage, pillar) {
	for (var i = 0; i <= n; i++) {
		for (var j = 0; j <= n; j++) {
			if (barrage[i][j] === 1 && !checkBarrage(n, i, j, pillar, barrage)) {
				return false;
			}

			if (pillar[i][j] === 1 && !checkPillar(n, i, j, pillar, barrage)) {
				return false;
			}
		}
	}
	return true;
}

function checkPillar(n, x, y, pillar, barrage) {
	if (x === 0 || pillar[x - 1][y] === 1) return true;
	if (barrage[x][y] === 1) return true;
	else if (y > 0 && barrage[x][y - 1] === 1) return true;
	return false;
}

function checkBarrage(n, x, y, pillar, barrage) {
	if (pillar[x - 1][y] === 1 || pillar[x - 1][y + 1]) return true;
	if (y > 0 && y < n && barrage[x][y - 1] === 1 && barrage[x][y + 1] === 1) return true;
	return false;
}
