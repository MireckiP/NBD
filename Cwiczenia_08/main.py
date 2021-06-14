# s14926 NBD zadanie 8

import requests

riakAddress = "http://127.0.0.1:8098/buckets/s14926/keys/"


def printResult(result):
    movie = result.json()
    print("Title: " + movie['title'] + "\nOriginal title: " + movie[
        'originalTitle'] + "\nTheatrical release date: " + str(
        movie['theatricalReleaseDate']) + "\nNumber of DVDs: " + str(movie['numberOfDVDs']))

def printSeq():
    print(resp.json())
    print("------")
    print("Print:")
    printResult(resp)

# wrzuci
print("Put")
movie = {"title": "Cruella", "originalTitle": "Cruella", "theatricalReleaseDate": 2019, "numberOfDVDs": 1}
resp = requests.put(riakAddress + "Cruella?returnbody=true", json=movie)
if resp.status_code != 200:
    print("Unable to put! " + resp.text)
else:
    print("Movie added successfully!")
print("\n----------------")

# pobierze i wypisze
print("Get")
resp = requests.get(riakAddress + "Cruella")
if resp.status_code != 200:
    print("Unable to get! " + resp.text)
else:
    printSeq()
print("\n----------------")

# zmodyfikuje
print("Update")
movie = {"title": "Cruella", "originalTitle": "Cruella", "theatricalReleaseDate": 2021, "numberOfDVDs": 2}
resp = requests.put(riakAddress + "Cruella?returnbody=true", json=movie)
if resp.status_code != 200:
    print("Unable to update! " + resp.text)
else:
    print("Movie updated successfully!")
print("\n----------------")

# pobierze i wypisze
print("Get")
resp = requests.get(riakAddress + "Cruella")
if resp.status_code != 200:
    print("Unable to get! " + resp.text)
else:
    printSeq()
print("\n----------------")

# usunie
print("Delete")
resp = requests.delete(riakAddress + "Cruella")
if resp.status_code != 204:
    print("Unable to delete! " + resp.text)
else:
    print("Movie deleted successfully!")
print("\n----------------")

# spróbuje pobrać z bazy
print("Get")
resp = requests.get(riakAddress + "Cruella")
if resp.status_code == 404:
    print("No movie in database")
else:
    printSeq()
