printjson(db.people.find({job:"Editor"}).toArray())
printjson(db.people.updateMany({job:"Editor"}, {$unset: {email:1}},false, true))
printjson(db.people.find({job:"Editor"}).toArray())