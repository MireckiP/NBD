var mapFunction2 = function() {
	for (var card in this.credit){
		var currency = this.credit[card].currency;
		var balance = parseFloat(this.credit[card].balance);
		emit(currency, balance);
	}
};

var reduceFunction2 = function(currency, value){
	return Array.sum(value);
};

var finalizeFunction2 = function (currency, value) {
	return value;
};


db.people.mapReduce(mapFunction2, reduceFunction2, {out:"map_reduce_balance2", finalize: finalizeFunction2})
printjson(db.map_reduce_balance2.find().toArray())