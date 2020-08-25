function solution(jobs) {
	var pq = new PriorityQueue((a, b) => a[1] < b[1]);
	jobs.sort((a, b) => a[0] - b[0]);
	let time = 0,
		task,
		total = 0,
		idx = 0;
	while (idx < jobs.length || !pq.isEmpty()) {
		while (idx < jobs.length && time >= jobs[idx][0]) {
			pq.offer(jobs[idx++]);
		}

		if (pq.isEmpty()) {
			time = jobs[idx][0];
		} else {
			task = pq.poll();
			total += time - task[0] + task[1];
			time += task[1];
		}
	}
	return Math.floor(total / jobs.length);
}

function PriorityQueue(comparator = (a, b) => a - b) {
	this.q = [];

	this.size = () => this.q.length;

	this.isEmpty = () => {
		return this.size() === 0;
	};

	this.peek = () => {
		return this.q[0];
	};

	this.offer = data => {
		let idx = this.q.length;
		this.q.push(data);
		while (idx > 0) {
			let next = Math.floor((idx - 1) / 2);
			if (comparator(this.q[idx], this.q[next])) {
				[this.q[idx], this.q[next]] = [this.q[next], this.q[idx]];
				idx = next;
			} else break;
		}
		return this.q.length;
	};

	this.poll = () => {
		if (this.isEmpty()) return;
		let size = 0;
		[this.q[size], this.q[this.q.length - 1]] = [this.q[this.q.length - 1], this.q[size]];
		let rtv = this.q.pop(),
			next;
		while (size * 2 + 1 < this.q.length) {
			if (this.q.length <= size * 2 + 2) {
				next = size * 2 + 1;
			} else {
				next = comparator(this.q[size * 2 + 1], this.q[size * 2 + 2]) ? size * 2 + 1 : size * 2 + 2;
			}
			if (comparator(this.q[size], this.q[next])) break;
			[this.q[size], this.q[next]] = [this.q[next], this.q[size]];
			size = next;
		}
		return rtv;
	};
}
