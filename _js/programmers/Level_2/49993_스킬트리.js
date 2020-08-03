var skill = "CBD";
var skill_trees = ["BACDE", "CBADF", "AECB", "BDA"];
console.log(solution(skill, skill_trees));
function solution(skill, skill_trees) {
	var answer = 0;
	var order = new Array(26);
	order.fill(-1);

	var idx = 0;
	for (var i of skill) {
		order[i.charCodeAt(0) - 65] = idx++;
	}

	for (var i of skill_trees) {
		var idx = 0;
		var check = true;

		for (var j of i) {
			if (skill.includes(j)) {
				var temp = order[j.charCodeAt(0) - 65];
				if (idx < temp) {
					check = false;
					break;
				} else idx++;
			}
		}
		if (check) answer++;
	}

	return answer;
}
