![CodeFactor](https://img.shields.io/badge/JAVA-11-blue)
[![Build Status](https://github.com/fh-erfurt/RentATool/workflows/RentATool/badge.svg)](https://github.com/fh-erfurt/RentATool/actions)

# Verleihstation für Werkzeuge
Im Rahmen des Projektes zum Thema Programmierung JAVA 1 haben wir uns entschieden einen Werkzeugverleih (analog zur Packstation) zu Programmieren.

## Projektteam
Das Unternehmen „KSP IT-Solutions“ wurde 2018 von 
* **Danny Steinbrecher** - [Profil](https://github.com/darthkali)
* **Marco Petzold** - [Profil](https://github.com/monschey)
* **Christian König** - [Profil](https://github.com/christiankoenig)
* **Bilal Alnani** - [Profil](https://github.com/bilal0710)

gegründet. Die Kernkompetenzen liegen im Entwickeln, Designen und Implementieren von Datenbankanwendungen. Unsere Kunden stammen meistens aus mittelständischen und Kleinunternehmen. Die meisten unserer Projekte sind speziell für den Kunden zugeschnitten und erfüllen stets die gewünschten Anforderungen.

## Produkte
Werkzeuge in verschiedenen Ausführungen und Größen!


## Kundenunternehmen
„Rent a Tool“ ist das Unternehmen von Tim Taylor. Es hat sich auf den Verleih von Heimwerkerwerkzeug spezialisiert. Mit seinen 12 Mitarbeitern hat es seinen Firmensitz in der Landeshauptstadt Erfurt.


## Anforderungsbeschreibung(Grob)
Die Grobziele wurden anhand der Anforderungsanalyse, sowie in Absprache mit dem Geschäftsführer Tim Taylor ermittelt.
Dies diente zur Überprüfung der S.M.A.R.T Kriterien des Projekts.
Grobziele sind:

	- Erstellung und Implementierung eines Verleih- und Kundenverwaltungssystems
	- Erstellung und Implementierung eines Lager- und Logistikverwaltungssystems

## Abgrenzungskriterien
Nicht zum Projektumfang gehören:

	- Die Personalverwaltung
	- Lohnbuchhaltung/Zeiterfassung
	- Rechnung und Mahnwesen
	
Hier werden lediglich Schnittstellen bereitgestellt, damit die erforderlichen Daten zu den externen Bearbeitern geschickt werden können. Speziell für den Bereich Rechnungen werden die gesamten Daten über unser Verleihsystem bereits gesammelt und anschließend übertragen.



## Klassendiagramm

![alt text](https://github.com/fh-erfurt/RentATool/blob/master/images/RentATool_Klassendiagramm.png?raw=true)


## Ausleih Prozess
![alt text](https://github.com/fh-erfurt/RentATool/blob/master/images/RentProcess.png?raw=true)


## Rückgabe Prozess
![alt text](https://github.com/fh-erfurt/RentATool/blob/master/images/ReturnProcess.png?raw=true)

## Besprechungsprotokolle

### Besprechung 06.01.2020

---

**1. Aggregation / Komposition / Assoziation**

- Ist eine Stilfrage. Wichtig ist, dass die Beziehungen überall da dargestellt werden wo sie vorhanden sind.
- Wir haben Festgelegt, das wir eine Aggregation nur dort erstellen, wo wir in der Klasse eine Liste von Objekten einer anderen Klasse haben.
- Beziehung zwischen Tool und Manufacturer fehlt noch

**2. Rental hat Bills und beinhaltet den Gesamten Process (aus Firmensicht)**

- Bill lieber in eine Bill Management Klasse auslagern
- Die Klasse Rental soll nur die Funktionen RentATool und ReturnTool besitzen

**3. Employee entfernen?**

- nein die Klasse Employee ist durchaus Sinnvoll
- jedoch sollte diese mit Sinnvollen Funktionen befüllt werden.
- z.b.: Rabatt vergeben, Bills suchen, Umsatz errechnen(des letzten Monats)
- Hier kann man durchaus Sachen nur andeuten, damit es den Rahmen nicht sprengt

**4. Before Each in Tests wirklich nötig?**

- Hier ist es uns Freigestellt, wir sollten uns aber auf ein Thema einigen 

**5. JavaDocs**

- Wir sollen JavaDocs nur an die Köpfe der Klassen und Methoden hängen
- nicht an die einzelnen Funktionen innerhalb der Methoden
- Hier nur Kommentieren

**6. Clean Code**

- Einzelne Funktionen innerhalb einer Methode mit sprechenden Namen erzeugen

![image](https://user-images.githubusercontent.com/46423967/71821171-ada6c380-3091-11ea-9f0d-f04934ea2dfd.png)


### Besprechung 09.12.2019

---

**1. UML**
- Object in UML Diagramm entfernen!
- Beziehungen kenntlich machen z.b. zwischen Tool und Station
- UML in Bereiche unterteilen (z.B.: Customer, Verwaltung, Tool,)

**2. Datumsformatierung**
- Date nicht benutzen
- GregorianCalender nutzen

**3. try Catch**
- kann überall eingebaut werden
- ist nicht nur für das Errorhandling

**4. Java Dogs**
- bei public Methoden sollte eine sinnvolle (mit Mehrwert) JavaDocumentation geschrieben werden

**5. Interface**
- Bereiche die nicht direkt miteinander zu tun haben
- recht groß Bereiche

**6. Tests**
- BeforeEach muss umgesetzt werden
- Nach dem BeforeEach müssen die Variablen zunächst Deklariert werden
- In einer Funktion, z.B.: setUp(), werden die Variablen dann initialisiert

**7. Dokumentation**
- tests brauchen in der Dokumentation nur erwähnt werden, brauchen aber nicht im Detail erklärt werden
- Testverlauf und Doku kann direkt aus IntelliJ erstellt werden

### Besprechung 20.01.2020

---

**1. Abgabe des Projektes**
- Abgabe über Github
- Link zum Repository an Jonas übergeben
- Präsentationen können in dem Repository hinterlegt werden
- Abgabe am 03.02.2020

**2. Abschlusspräsentation**
- welche Änderungen gab es seit der letzten Präsentation
- das Endprodukt präsentieren
- ursprüngliches Ziel - mit Endprodukt vergleichen
- lessons learned
- 15 min Präsentation
- am 03.02 Vorlesung und Übung  wird für die Präsentation genutzt

**3. Dokumentation**
- Top Down Sicht auf das Projekt
- was macht das Programm
- wie ist es strukturiert
- UML-Klassendiagramm (Whitebox)
- Businesscase
- Usecase
- Einfache Sicht auf das System (Blackbox)
- Lessons learned 
- Dokumentation kann in GitHub ReadMe erfolgen

**4. Änderungen am Projekt**
- Notification Class einbauen
- Company und Departments entfernen

## Programme

* [IntelliJ](https://www.jetbrains.com/de-de/idea/) - IDE für JAVA
* [Visio](https://products.office.com/de-de/visio) - Tool für die Erstellung der Diagramme / Charts / ...

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
