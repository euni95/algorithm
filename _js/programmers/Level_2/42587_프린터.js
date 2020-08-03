var priorities = [1, 1, 9, 1, 1, 1];
var location = 0;

console.log(solution(priorities, location));
function solution(priorities, location) {
	var answer = 0;
	var q = [];
	q = priorities.map((e, i) => [e, i]);

	var idx = 1;
	var before = q[0];
	while (idx <= priorities.length) {
		var maxIdx = -1;
		for (var i = 1; i < q.length; i++) {
			var temp = q[i];
			if (before[0] < temp[0]) {
				maxIdx = i;
				break;
			}
		}
		for (var i = 0; i < maxIdx; i++) q.push(q.shift());
		if (maxIdx === -1) {
			var pop = q.shift();
			if (pop[1] === location) return idx;
			idx++;
		}
		before = q[0];
	}
	return answer;
}
