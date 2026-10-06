package org.hbrs.se1.ws26.exercises.uebung1.test;

import org.hbrs.se1.ws26.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws26.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws26.exercises.uebung1.control.TranslatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class GermanTranslatorTest {

    @Test
    public void TestTranslateNumber() {
        GermanTranslator translator = new GermanTranslator();

        //untere Grenzen
        assertEquals("Übersetzung der Zahl 0 nicht möglich (" + Translator.version + ")", translator.translateNumber(0));
        assertEquals("Übersetzung der Zahl -1 nicht möglich (" + Translator.version + ")", translator.translateNumber(-1));
        assertEquals("eins", translator.translateNumber(1));

        //bis 19
        assertEquals("zwölf", translator.translateNumber(12));
        assertEquals("neunzehn", translator.translateNumber(19));

        //Glatte Zehner
        assertEquals("zwanzig" , translator.translateNumber(20));
        assertEquals("fünfzig", translator.translateNumber(50));

        //zusammengesetzt
        assertEquals("einunddreißig", translator.translateNumber(31));
        assertEquals("siebenundsechzig", translator.translateNumber(67));

        //obere Grenzen
        assertEquals("einhundert", translator.translateNumber(100));
        assertEquals("Übersetzung der Zahl 101 nicht möglich (" + Translator.version + ")", translator.translateNumber(101));
        assertEquals("Übersetzung der Zahl 102 nicht möglich (" + Translator.version + ")", translator.translateNumber(102));

        //größter int-wert
        assertEquals("Übersetzung der Zahl " + Integer.MAX_VALUE + " nicht möglich (" + Translator.version + ")", translator.translateNumber(Integer.MAX_VALUE));
    }

    @Test
    public void TestFactoryDate(){
        Translator tr = TranslatorFactory.createGermanTranslator();

        assertTrue(tr instanceof GermanTranslator);

        GermanTranslator gt = (GermanTranslator) tr;
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        assertEquals(expectedDate, gt.getDate());
    }
}
