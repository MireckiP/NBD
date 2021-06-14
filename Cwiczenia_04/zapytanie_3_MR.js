var mapFunction3 = function() {
	emit(this.job, null);
};
var reduceFunction3 = function(jobs, value){
	return 1;
};

var finalizeFunction3 =  function (jobs, value){
	return 1;
};
db.people.mapReduce(mapFunction3, reduceFunction3, {out:"map_reduce_jobs3", finalize: finalizeFunction3})
printjson(db.map_reduce_jobs3.find().toArray())