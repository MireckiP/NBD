printjson(db.people.aggregate([{$group:{_id:"$nationality", avgBMI:{$avg:{$sum:{$divide:[{$toDouble:"$weight"},{$multiply:[{$divide:[{$toDouble:"$height"},100]},{$divide:[{$toDouble:"$height"},100]}]}]}}}, minBMI:{$min:{$sum:{$divide:[{$toDouble:"$weight"},{$multiply:[{$divide:[{$toDouble:"$height"},100]},{$divide:[{$toDouble:"$height"},100]}]}]}}}, maxBMI:{$max:{$sum:{$divide:[{$toDouble:"$weight"},{$multiply:[{$divide:[{$toDouble:"$height"},100]},{$divide:[{$toDouble:"$height"},100]}]}]}}}}}]).toArray())