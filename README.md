# SE1 beantwortung der Fragen:
Autor: Max-Emanuel Thaller

## Übung1:

### Was ist der Vorteil einer seperaten Test-Klasse?

In einer seperaten Klasse bleibt der Testcode sauber vom restlichen Code getrennt und verschiedene Testfälle bleiben so übersichtlicher.
Desweiteren testet sie die zu testende Klasse von außen über ihre öffentlichen Methoden.

### Was ist bei einem Blackbox-Test der Sinn von Äquivalenzklassen?

Jede einzelne Möglichkeit zu testen wäre einfach nur aufwendig und bei größeren Projekten praktisch unmöglich.
Daher ist eine Unterteilung in ÄK sehr sinnvoll um Testcode zu reduzieren.
Dazu gehören unter anderem Randfehler (Werte an Intervallgrenzen) die leicht überprüft werden können.

### Warum ist ein Blackbox-Test mit JUnit auf der Klasse Client nicht unmittelbar durchführbar?

Ein Blackbox-Test ist nicht unmittelbar durchführbar, da die Methode display() den Rückgabetyp void besitzt.
JUnit braucht einen konkreten Rückgabetyp (z.B. assertEquals) für den Ergebnisvergleich.