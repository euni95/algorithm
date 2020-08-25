var begin = "hit";
var target = "cog";
var words = ["hot", "dot", "dog", "lot", "log", "cog"];
console.log(solution(begin, target, words));
function solution(begin, target, words) {
	if (!words.includes(target)) return 0;
	var wordLen = begin.length;
	var queue = [];
	addWord(begin, wordLen, words, queue);
	var cnt = 0;
	var flag = true;
	while (flag) {
		cnt++;
		var qSize = queue.length;
		for (var i = 0; i < qSize; i++) {
			var temp = queue[0];
			if (temp === target) flag = false;
			queue.splice(0, 1);
			addWord(temp, wordLen, words, queue);
		}
	}
	console.log(cnt);
	return cnt;
}

function addWord(begin, wordLen, words, queue) {
	for (var word of words) {
		var cnt = wordLen;
		for (var i = 0; i < wordLen; i++) {
			if (word[i] === begin[i]) cnt--;
		}
		if (cnt === 1) queue.push(word);
	}
}
