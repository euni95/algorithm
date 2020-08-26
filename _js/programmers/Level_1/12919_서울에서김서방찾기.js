var seoul = ["Jane", "Kim"];
console.log(solution(seoul));
function solution(seoul) {
	for (var i in seoul) {
		if (seoul[i] == "Kim") return "김서방은 " + i + "에 있다";
	}
}
