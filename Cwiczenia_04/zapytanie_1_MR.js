var mapFunction1 = function() {
	emit(this.sex,{count: 1, height: parseFloat(this.height), weight: parseFloat(this.weight)});
};

var reduceFunction1 = function(sex,values) {
	return {count: Array.sum(values.map(v => v.count)), height: Array.sum(values.map(v => v.height)), weight: Array.sum(values.map(v => v.weight))};
};

var finalizeFunction1 = function(sex, values) {
	return {avgHeight: values.height / values.count, avgWeight: values.weight / values.count };
};

db.people.mapReduce(mapFunction1, reduceFunction1,{out:"map_reduce_size1", finalize: finalizeFunction1});
printjson(db.map_reduce_size1.find().toArray());