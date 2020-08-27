var m = 8;
var n = 5;
var board = ["HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"];

var dx = [0, 0, 1, 1];
var dy = [0, 1, 0, 1];

console.log(solution(m, n, board));
function solution(m, n, board) {
	var answer = 0;
	for (var i = 0; i < m; i++) {
		board[i] = board[i].split("");
	}
	while (true) {
		let temp = removeBlock(m, n, board);
		if (temp === 0) break;
		answer += temp;
	}
	return answer;
}

function removeBlock(m, n, board) {
	let visited = [];
	for (var i = 0; i < m; i++) {
		visited[i] = new Array(n).fill(0);
	}

	let removeCnt = 0;
	for (var i = 0; i < m - 1; i++) {
		for (var j = 0; j < n - 1; j++) {
			let temp = board[i][j];
			if (temp == -1) continue;

			let flag = true;
			for (var k = 1; k <= 3; k++) {
				if (temp != board[i + dx[k]][j + dy[k]]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				isRemove = true;
				for (var k = 0; k < 4; k++) {
					let tx = i + dx[k];
					let ty = j + dy[k];

					if (visited[tx][ty] == 1) continue;
					visited[tx][ty] = 1;
					removeCnt++;
				}
			}
		}
	}

	if (removeCnt === 0) return 0;

	for (var i = 0; i < n; i++) {
		for (var j = m - 1; j >= 0; j--) {
			if (visited[j][i] == 1 || board[j][i] == -1) {
				let flag = false;
				for (var k = j - 1; k >= 0; k--) {
					if (board[k][i] == -1) continue;
					if (visited[k][i] != 1) {
						board[j][i] = board[k][i];
						board[k][i] = -1;
						flag = true;
						break;
					}
				}
				if (!flag) board[j][i] = -1;
			}
			console.log(board);
		}
	}
	return removeCnt;
}

function solution(m, n, board) {
	board = board.map(e => e.split(""));
	let count = 0,
		possible;
	while ((possible = getPossiblePoint()).length > 0) {
		let temp = possible.reduce((a, c) => {
			for (let i = 0; i < 2; i++) {
				for (let j = 0; j < 2; j++) {
					if (board[c[0] + i][c[1] + j] === ".") continue;
					a++;
					board[c[0] + i][c[1] + j] = ".";
				}
			}
			return a;
		}, 0);
		if (temp === 0) break;
		count += temp;
		dropBlock();
	}
	return count;

	function dropBlock() {
		for (let i = 0; i < n; i++) {
			let stack = [];
			for (let j = 0; j < m; j++) {
				if (board[j][i] !== ".") stack.push(board[j][i]);
			}
			for (let j = m - 1; j >= 0; j--) {
				if (stack.length === 0) board[j][i] = ".";
				else board[j][i] = stack.pop();
			}
		}
	}
	function getPossiblePoint() {
		let rtv = [];
		for (let i = 0; i < m - 1; i++) {
			for (let j = 0; j < n - 1; j++) {
				if (board[i][j] !== "." && is4block(i, j)) rtv.push([i, j]);
			}
		}
		return rtv;
	}
	function is4block(y, x) {
		return (
			board[y][x] === board[y][x + 1] &&
			board[y][x + 1] === board[y + 1][x] &&
			board[y + 1][x] === board[y + 1][x + 1]
		);
	}
}
