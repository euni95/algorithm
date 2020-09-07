var key = [
	[0, 0, 0],
	[1, 0, 0],
	[0, 1, 1]
];

var lock = [
	[1, 1, 1],
	[1, 1, 0],
	[1, 0, 1]
];

console.log(solution(key, lock));
function solution(key, lock) {
	var M = key.length;
	var N = lock.length;
	var lockCnt = 0;
	var keyCnt = 0;

	var newLock = [];
	for (var i = 0; i < N + (M - 1) * 2; i++) {
		newLock.push(new Array(N + (M - 1) * 2).fill(3));
	}
	for (var i = 0; i < N; i++) {
		let tempI = i + (M - 1);
		for (var j = 0; j < N; j++) {
			let tempJ = j + (M - 1);
			newLock[tempI][tempJ] = lock[i][j];

			if (lock[i][j] === 0) lockCnt++;
			if (i < M && j < M && key[i][j] === 1) keyCnt++;
		}
	}

	if (keyCnt < lockCnt) return false;
	if (lockCnt === 0 || (keyCnt === 1 && lockCnt === 1)) return true;

	N = newLock.length;
	for (var i = 0; i < N - 1; i++) {
		for (var j = 0; j < N - 1; j++) {
			if (openLock(i, j, N, M, key, newLock, lockCnt)) return true;
		}
	}

	for (var k = 0; k < 3; k++) {
		key = rotateKey(M, key);
		for (var i = 0; i < N - 1; i++) {
			for (var j = 0; j < N - 1; j++) {
				if (openLock(i, j, N, M, key, newLock, lockCnt)) return true;
			}
		}
	}

	return false;
}

function openLock(lockX, lockY, N, M, key, lock, lockCnt) {
	var tempCnt = 0;
	var x = 0,
		y = 0;

	for (var i = lockX; i < N; i++) {
		y = 0;
		for (var j = lockY; j < N; j++) {
			if (lock[i][j] === 0 && key[x][y] === 1) tempCnt++;
			else if (lock[i][j] === 1 && key[x][y] === 1) return false;
			y++;
			if (y === M) break;
		}
		x++;
		if (x === M) break;
	}
	if (tempCnt === lockCnt) return true;
	else return false;
}

function rotateKey(M, key) {
	var temp = [];
	for (var i = 0; i < M; i++) {
		temp.push(new Array(M));
		for (var j = 0; j < M; j++) {
			temp[i][j] = key[M - 1 - j][i];
		}
	}
	return temp;
}
