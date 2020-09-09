var n = 1;
var t = 1;
var m = 5;
var timetable = ["08:00", "08:01", "08:02", "08:03"];
console.log(solution(n, t, m, timetable));
function solution(n, t, m, timetable) {
	var time = 0;
	var startTime = 60 * 9;
	var endTime = 60 * 9 + (n - 1) * t;

	timetable = timetable
		.map(val => {
			return Number(val.substr(0, 2)) * 60 + Number(val.substr(3, 2));
		})
		.sort((a, b) => a - b);
	var bus = new Array(n).fill(0);
	var j = 0;
	for (var i = 0; i < n; i++) {
		let now = startTime + i * t;
		while (true) {
			if (j === timetable.length || bus[i] === m || timetable[j] > now) break;
			time = timetable[j++];
			bus[i]++;
		}
		// if (j === timetable.length || timetable[j] > endTime) break;
	}
	console.log(j, bus, m);
	if (bus[n - 1] < m) time = endTime;
	else time -= 1;

	var hour = Math.floor(time / 60);
	var min = time % 60;
	hour = hour < 10 ? "0" + hour.toString() : hour.toString();
	min = min < 10 ? (min === 0 ? "00" : "0" + min.toString()) : min.toString();
	return hour + ":" + min;
}
