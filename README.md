![CodeFactor](https://img.shields.io/badge/JAVA-13.0.2.8-blue)
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

![alt text](https://github.com/fh-erfurt/RentATool/blob/master/share/images/RentATool_Klassendiagramm.png?raw=true)


## Ausleih Prozess
![alt text](https://github.com/fh-erfurt/RentATool/blob/master/share/images/RentProcess.png?raw=true)


## Rückgabe Prozess
![alt text](https://github.com/fh-erfurt/RentATool/blob/master/share/images/ReturnProcess.png?raw=true)

## Besprechungsprotokolle


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

## Lessons Learned
- Da wir in diesem Projekt 4 Teammitglieder waren, wurde die Kommunikation und Koordination noch etwas schwieriger und Aufwändiger.
- Die Versionskontrolle (Git) hat uns am Anfang, aufgrund fehlender Erfahrung, etwas Mühe gekostet es einzuarbeiten, stellte sich im Nachgang jedoch als mächtiges Tool heraus. Paralleles arbeiten war hier wesentlich angenehmer und vor allem kontrollierbarer. Dennoch waren immer absprachen nötig, damit man nicht gleichzeitig an einer Datei arbeitet.
- Das Arbeiten mit Issues hat uns extrem geholfen den letztgenannten Punkt zu koordinieren. Jeder bekam seine Aufgaben und wusste was er zu tun hatte. Somit gab es fast keine Überschneidungen. Sollte es dennoch zu solchen kommen, wusste man es jedoch frühzeitig und konnte mit dem anderen darüber sprechen.
- Auch in diesem Projekt stellte sich heraus, dass die Kommunikation mit dem Kunden sehr wichtig ist. Vor allem das Rechtzeitige präsentieren des aktuellen Standes hat fast immer dazu geführt, dass sich Entwickler und Kunden aufeinander zu bewegt haben. Somit konnte am Ende die Richtung und somit das Ziel des Projektes umgesetzt werden.
- Die größte Schwierigkeit bei diesem Projekt war das Umdenken von der Datenbankbasierten Logik. Hier hatten wir vor allem am Anfang noch viel zu Kämpfen.
- Die Tests helfen enorm bei der Programmierung. Eine schnelle und einfache Kontrolle ist nach Änderungen möglich. Man spart somit viel manuelle Prüfarbeit.

## Programme

* [IntelliJ](https://www.jetbrains.com/de-de/idea/) - IDE für JAVA
* [lucidchart](https://www.lucidchart.com) - Tool für die Erstellung der Diagramme / Charts / ...
* [Office](https://www.office.com/) - Office Programm
* [Git](https://git-scm.com/) - Versionskontrolle

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
