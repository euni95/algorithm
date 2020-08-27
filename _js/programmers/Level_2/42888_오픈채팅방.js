var record = [
	"Enter uid1234 Muzi",
	"Enter uid4567 Prodo",
	"Leave uid1234",
	"Enter uid1234 Prodo",
	"Change uid4567 Ryan"
];
console.log(solution(record));
function solution(record) {
	var answer = [];
	var map = new Map();
	for (var i in record) {
		record[i] = record[i].split(" ");
		if (record[i].length == 2) continue;
		map.set(record[i][1], record[i][2]);
	}

	for (var i in record) {
		if (record[i][0] === "Enter") {
			answer.push(map.get(record[i][1]) + "님이 들어왔습니다.");
		} else if (record[i][0] === "Leave") {
			answer.push(map.get(record[i][1]) + "님이 나갔습니다.");
		}
	}
	return answer;
}
