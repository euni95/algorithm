var arrangement = "()(((()())(())()))(())";
console.log(solution(arrangement));
function solution(arrangement) {
	var answer = 0;
	var open = 0,
		isOpen = false;
	for (var i of arrangement) {
		if (i == "(") {
			isOpen = true;
			open++;
		} else {
			open--;
			if (isOpen) {
				isOpen = false;
				answer += open;
			} else answer++;
		}
	}
	return answer;
}
