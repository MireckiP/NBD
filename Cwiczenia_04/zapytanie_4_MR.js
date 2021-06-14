var mapFunction4 = function() {
	const BMI = this.weight / ((this.height / 100) ** 2);
	emit(this.nationality, {count: 1, BMIv: BMI, minBMI: BMI, maxBMI: BMI});
};
var reduceFunction4 = function(nation, values) {
	return { count: Array.sum (values.map(v => v.count)), BMI: Array.sum(values.map(v => v.BMIv)), minBMI: Math.min(...values.map(v => v.minBMI)), maxBMI: Math.max(...values.map(v => v.maxBMI))};
};

var finalizeFunction4 = function(nation, values) {
	return { avgBMI: values.BMI / values.count, minBMI: values.minBMI, maxBMI: values.maxBMI};
};

db.people.mapReduce(mapFunction4, reduceFunction4, {out:"map_reduce_bmi4", finalize: finalizeFunction4})
printjson(db.map_reduce_bmi4.find().toArray())