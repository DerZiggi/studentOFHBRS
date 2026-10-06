package org.hbrs.se1.ws26.exercises.uebung1.control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TranslatorFactory {

    public static Translator createGermanTranslator(){
        GermanTranslator translator = new GermanTranslator();

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        translator.setDate(today);
        return translator;
    }
}
