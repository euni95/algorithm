// var files = ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"];
var files = ["Freedom Fighter 310", "Freedom Fighter310"];
console.log(solution(files));
function solution(files) {
	var splitFiles = [];
	for (var i in files) splitFiles[i] = splitFile(files[i]);
	console.log(splitFiles);

	files = files.map((v, i) => [v, i]);
	files.sort((a, b) => {
		let fileA = splitFiles[a[1]];
		let fileB = splitFiles[b[1]];

		if (fileA[0] === fileB[0]) {
			if (fileA[1] === fileB[1]) return a[1] - b[1];
			else return fileA[1] < fileB[1] ? -1 : 1;
		} else return fileA[0] < fileB[0] ? -1 : 1;
	});
	files = files.map(v => v[0]);
	return files;
}

function splitFile(file) {
	var flag = false;
	var head = "",
		number = "",
		cnt = 0;
	for (var i = 0; i < file.length; i++) {
		let temp = file.charAt(i);
		if (temp != " " && !isNaN(temp)) {
			if (!flag) head = file.substr(0, i);
			if (cnt === 5) {
				number = file.substr(i - 5, 5);
				break;
			}
			flag = true;
			cnt++;
		} else {
			if (flag) {
				number = file.substr(i - cnt, cnt);
				break;
			}
		}
	}
	if (number.length === 0) number = file.substr(-1 * cnt, cnt);
	return [head.toLowerCase(), Number(number)];
}
