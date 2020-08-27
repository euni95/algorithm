var x = 12;
console.log(solution(x));
function solution(x) {
	var sum = 0,
		temp = x;
	while (temp >= 1) {
		sum += temp % 10;
		temp = Number.parseInt(temp / 10);
	}
	return x % sum === 0 ? true : false;
}
