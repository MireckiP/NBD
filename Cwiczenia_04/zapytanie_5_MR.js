var mapFunction5= function(){
	if (this.nationality === 'Poland' && this.sex === 'Female'){
		this.credit.forEach (c => 
	emit (c.currency, {count: 1, balance: parseFloat(c.balance)}))}};

var reduceFunction5 = function(currency, values) {
	return{ count: Array.sum(values.map(v => v.count)), sumBalance: Array.sum(values.map(v=>v.balance))};
};

var finalizeFunction5 = function(currency, values) {
	return {sumBalance: values.sumBalance, avgBalance: values.sumBalance / values.count};
};

db.people.mapReduce(mapFunction5, reduceFunction5, {out:"map_reduce_PB5", finalize: finalizeFunction5})
printjson(db.map_reduce_PB5.find().toArray())