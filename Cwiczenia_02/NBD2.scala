object NBD2 {

  def main(args: Array[String]): Unit = {
    println("Zadanie 1")
    println(whatDayItIs("Poniedzialek"))
    println(whatDayItIs("NIEDZIELA"))
    println(whatDayItIs("styczeń"))
    println("Zadanie 2")
    val konto1 = new KontoBankowe()
    val konto2 = new KontoBankowe(300.0)
    println("Konto 1: " + konto1._stanKonta)
    konto1.wplata(200.0)
    println("Konto 1: " + konto1._stanKonta)
    konto1.wyplata(33.13)
    println("Konto 1: " + konto1._stanKonta)
    println("Konto 2:" + konto2._stanKonta)
    konto2.wyplata(15.55)
    println("Konto 2:" + konto2._stanKonta)
    println("Zadanie 3")
    val osoba1 = Osoba("Adam", "Abacki")
    val osoba2 = Osoba("Bartosz", "Babacki")
    val osoba3 = Osoba("Cezary", "Cabacki")
    println(greeting(osoba1))
    println(greeting(osoba2))
    println(greeting(osoba3))
    println("Zadanie 4")
    println(threeTimes(3, increase))
    println("Zadanie 5")
    val osobaNauczyciel = new Osoba5("Adam", "Abacki") with Nauczyciel
    val osobaStudent = new Osoba5("Bartosz", "Babacki") with Student
    val osobaPracownik = new Osoba5("Cezary", "Cabacki") with Pracownik
    val osobaPracownikStudent = new Osoba5("Damian", "Dabacki") with Pracownik with Student
    val osobaStudentPracownik = new Osoba5("Emil", "Ebacki") with Student with Pracownik
    println("Podatek dla nauczyciela: " + osobaNauczyciel.podatek)
    println("Podatek dla studenta: " + osobaStudent.podatek)
    println("Podatek dla pracownika: " + osobaPracownik.podatek)
    println("Podatek dla pracownik-student: " + osobaPracownikStudent.podatek)
    println("Podatek dla student-pracownik: " + osobaStudentPracownik.podatek)
  }

  def whatDayItIs(string: String): String = {
    string.toLowerCase() match {
      case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek" => "Praca"
      case "sobota" | "niedziela" => "Weekend"
      case default => "Nie ma takiego dnia"
    }
  }

  def greeting(osoba: Osoba): String = {
    osoba match {
      case Osoba(_, nazwisko) if nazwisko.equals("Abacki") => "Dzień dobry panie Abacki"
      case Osoba(_, nazwisko) if nazwisko.equals("Babacki") => "Cześć Babacki"
      case default => "Dzień dobry Państwu"
    }
  }

  class KontoBankowe {
    var _stanKonta = 0.0

    def this(stanKonta: Double) {
      this()
      this._stanKonta = stanKonta
    }

    def wplata(ile: Double): Unit = {
      _stanKonta += ile
    }

    def wyplata(ile: Double): Unit = {
      _stanKonta -= ile
    }
  }

  case class Osoba(imie: String, nazwisko: String) {
  }

  def increase(x: Int): Int = {
    x + 5
  }

  def threeTimes(x: Int, function: Int => Int): Int = {
    function(function(function(x)))
  }

  abstract class Osoba5(val imie: String, val nazwisko: String) {
    def podatek: Double
  }

  trait Student extends Osoba5 {
    override def podatek: Double = 0.0
  }

  trait Nauczyciel extends Pracownik {
    override def podatek: Double = 0.10 * pensja
  }

  trait Pracownik extends Osoba5 {
    var pensja: Double = 300

    override def podatek: Double = 0.20 * pensja
  }

}
