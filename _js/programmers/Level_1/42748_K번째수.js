var array = [1, 5, 2, 6, 3, 7, 4];
var commands = [
	[2, 5, 3],
	[4, 4, 1],
	[1, 7, 3]
];

console.log(solution(array, commands));
function solution(array, commands) {
	var answer = [];
	answer = commands.reduce((acc, cur, idx) => {
		var start = cur[0] - 1;
		var end = cur[1];
		var idx = cur[2] - 1;
		acc.push(
			array.slice(start, end).sort((a, b) => {
				return a - b;
			})[idx]
		);
		return acc;
	}, []);
	return answer;
}
