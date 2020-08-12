var board = [
	[0, 0, 0, 0, 0],
	[0, 0, 1, 0, 3],
	[0, 2, 5, 0, 1],
	[4, 2, 4, 4, 2],
	[3, 5, 1, 3, 1]
];
var moves = [1, 5, 3, 5, 1, 2, 1, 4];
console.log(solution(board, moves));
function solution(board, moves) {
	var answer = 0;
	var basket = [];
	for (var idx of moves) {
		let len = basket.length - 1;
		for (var i = 0; i < board.length; i++) {
			let temp = board[i][idx - 1];
			if (temp != 0) {
				board[i][idx - 1] = 0;
				if (basket[len] === temp) {
					basket.splice(len, len + 1);
					answer += 2;
				} else basket.push(temp);
				break;
			}
		}
		// console.log(basket);
	}
	return answer;
}
