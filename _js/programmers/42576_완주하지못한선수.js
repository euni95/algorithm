input();

function input() {
	let participant = ["leo", "kiki", "eden", "leo", "leo"];
	let completion = ["eden", "kiki", "leo", "leo"];

	solution(participant, completion);
}

function solution(participant, completion) {
	var answer = "";
	var map = new Map();
	for (var i in completion) {
		let name = completion[i];
		if (map.has(name)) map.set(name, map.get(name) + 1);
		else map.set(completion[i], 1);
	}

	for (var i in participant) {
		let name = participant[i];
		if (map.has(name)) {
			if (map.get(name) === 1) map.delete(name);
			else map.set(name, map.get(name) - 1);
		} else return name;
	}

	return answer;
}
