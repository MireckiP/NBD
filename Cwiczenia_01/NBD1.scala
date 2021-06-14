import com.sun.org.apache.xerces.internal.util.PropertyState.is

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object NBD1 {
  val listaTydzien = List("Poniedzialek", "Wtorek", "Sroda", "Czwartek", "Piatek", "Sobota", "Niedziela")
  val cennik = Map("Cebula"->3.00, "Jablka"->4.00, "Gruszki"->5.00, "Banany"->6.0)
  val liczby = List(-3,3,0,5,1,0,2,7,9,0,-2)
  val liczby2 = List(-10.11,2, -6.34,7, -5.21, 3.14, 6.28, 9.13, 14.76)

  def main(args: Array[String]) = {
    println("Zadanie 1a")
    println(listToStringFor(listaTydzien))
    println("Zadanie 1b")
    println(listToStringForFilterP(listaTydzien))
    println("Zadanie 1c")
    println(listToStringWhile(listaTydzien))
    println("Zadanie 2a")
    println(listToStringRecursion(listaTydzien))
    println("Zadanie 2b")
    println(listToStringRecursionRev(listaTydzien))
    println("Zadanie 3")
    println(listToStringRecursionTail(listaTydzien))
    println("Zadanie 4a")
    println(listFoldLeft(listaTydzien))
    println("Zadanie 4b")
    println(listFoldRight(listaTydzien))
    println("Zadanie 4c")
    println(listFoldLeftFiltered(listaTydzien))
    println("Zadanie 5")
    println(reducedMap(cennik))
    println("Zadanie 6")
    printTuple(("Jabłka",12,3.49))
    println("Zadanie 7")
    println("Nie ma elementu: "+ cennik.get("Pomarańcza"))
    println("Jest element: "+cennik.get("Banany"))
    println("Zadanie 8")
    println(removeZeros(liczby))
    println("Zadanie 9")
    println(increaseList(liczby))
    println("Zadanie 10")
    println(absoluteList(liczby2))
  }

  def listToStringFor(lista: List[String]): String = {
    var result = ""
    var separator = ""
    for (day <- lista) {
      result += separator + day
      separator = ", "
    }
    result
  }

  def listToStringForFilterP(lista: List[String]): String = {
    var result = ""
    var separator = ""
    for (day <- lista.filter {
      _.startsWith("P")
    }) {
      result += separator + day
      separator = ", "
    }
    result
  }

  def listToStringWhile(lista: List[String]): String = {
    var result = ""
    val day = lista.iterator
    var separator = ""
    while (day.hasNext) {
      result += separator + day.next()
      separator = ", "
    }
    result
  }

  def listToStringRecursion(lista: List[String]): String = {
    var result = ""
    var separator = ""

    def rekList(list_in: List[String]): String = list_in match {
      case Nil => ""
      case h :: t =>
        result += separator + h
        separator = ", "
        rekList(t)
    }

    rekList(lista)
    result
  }

  def listToStringRecursionRev(lista: List[String]): String = {
    var result = ""
    var separator = ""

    def rekList(list_in: List[String]): String = list_in match {
      case Nil => ""
      case h :: t =>
        result = h + separator + result
        separator = ", "
        rekList(t)
    }

    rekList(lista)
    result
  }

  def listToStringRecursionTail(lista: List[String]): String = {
    var result = ""

    @tailrec
    def rekListTail(list_in: List[String], result: String = ""): String = list_in match {
      case Nil => result
      case h :: t => {
        rekListTail(t, if (result != "") result + ", " + h else result + h)
      }
    }
    rekListTail(lista, result)
  }

  def listFoldLeft(lista: List[String]): String = {
    lista.foldLeft("")((result, current) => result + current +", " ).dropRight(2)
  }

  def listFoldRight(lista: List[String]): String = {
    lista.foldRight("")((result, current) => result + ", " + current).dropRight(2)
  }

  def listFoldLeftFiltered(lista: List[String]): String = {
    lista.foldLeft("")((result, current) => if(current.startsWith("P")) result+current+", " else result).dropRight(2)
  }

  def reducedMap(mapa:Map[String, Double]):Map[String, Double] ={
    mapa.view.mapValues(_*0.9).toMap
  }

  def printTuple(tuple:(String,Integer,Double ))={
    println ("Nazwa: "+tuple._1)
    println("Ilość: "+tuple._2)
    println("Cena jednostkowa: "+tuple._3)
  }

  def removeZeros(lista: List[Int]): List[Int] = {
    var result = new ListBuffer[Int]()

    def rekList(list_in: List[Int]): List[Int] = list_in match {
      case Nil => List()
      case h :: t =>
        if (h!=0) result+=h
                rekList(t)
    }
    rekList(lista)
    result.toList
  }

  def increaseList(lista:List[Int]):List[Int] ={
    lista.map(_+1)
  }

  def absoluteList(lista:List[Double]):List[Double]={
    lista.filter(n => n>= -5 && n<=12).map(_.abs)
  }
}
