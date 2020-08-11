var m = "ABC";
var musicinfos = ["12:00,12:07,HELLO,ABCD", "13:00,13:05,WORLD,ABCDEF"];
console.log(solution(m, musicinfos));
function solution(m, musicinfos) {
	var answer = "";
	var maxLen = 0;
	m = replaceText(m);
	for (var i of musicinfos) {
		var music = i.split(",");
		var time = (new Date(1, 1, 1, 1, music[1].substr(0, 2), music[1].substr(3, 2)) - new Date(1, 1, 1, 1, music[0].substr(0, 2), music[0].substr(3, 2))) / 1000;
		var lyrics = replaceText(music[3]);
		var length = lyrics.length; // 노래 길이
		var listen = lyrics;
		if (length < time) {
			var temp = length;
			while (true) {
				if (temp > time) break;
				temp += length;
				if (temp <= time) {
					listen += lyrics;
				} else {
					listen += lyrics.substr(0, time - (temp - length));
				}
			}
		} else if (length > time) {
			listen = lyrics.substr(0, time);
		}
		if (listen.includes(m)) {
			if (maxLen < time) {
				answer = music[2];
				maxLen = time;
			}
		}
	}
	return answer === "" ? "(None)" : answer;
}

function replaceText(text) {
	return text.replace(/C#/g, "c").replace(/D#/g, "d").replace(/F#/g, "f").replace(/G#/g, "g").replace(/A#/g, "a");
}
