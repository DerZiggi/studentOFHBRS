package org.hbrs.se1.ws26.exercises.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = null;
	private final String[] digits = {"", "eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun",
		"zehn", "elf", "zwölf", "dreizehn", "vierzehn", "fünfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};
	private final String[] tens = {"", "", "zwanzig", "dreißig", "vierzig", "fünfzig", "sechzig", "siebzig",
		"achtzig", "neunzig"};


    /**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	 public String translateNumber(int number) {
		if(number < 1 || number > 100){
			return "Übersetzung der Zahl " + number + " nicht möglich (" + Translator.version + ")";
		} else if(number == 100){
			return "einhundert";
		} else if(number < 20){
			return digits[number];
		}

		int ten = number / 10;
		int first = number % 10;

		if(first == 0){
			return tens[ten];
		}

		String temp = (first == 1) ? "ein" : digits[first];
		return temp + "und" + tens[ten];
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: dd.MM.yyyy (Beispiel: "20.08.2026"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 * Technisch sollte einfach das "heutige" Datum gesetzt werden.
	 */
	public void setDate( String date ) {
		this.date = date;
	}

	/**
	 * Auslesen des gesetzten Datums
	 * @return
	 */
	public String getDate() {
		return date;
	}
}
