var progresses = [93, 30, 55];
var speeds = [1, 30, 5];
console.log(solution(progresses, speeds));
function solution(progresses, speeds) {
	var answer = [];

	var before = Math.ceil((100 - progresses[0]) / speeds[0]);
	var cnt = 0;
	for (var i in progresses) {
		var day = Math.ceil((100 - progresses[i]) / speeds[i]);
		if (before >= day) cnt++;
		else {
			answer.push(cnt);
			cnt = 1;
			before = day;
		}
	}
	answer.push(cnt);
	return answer;
}
