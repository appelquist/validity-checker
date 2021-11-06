package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> personnummer = new ArrayList<String>();

        //valid
        personnummer.add("141206-2380");
        personnummer.add("20080903-2386");
        personnummer.add("7101169295");
        personnummer.add("189912299816");
        personnummer.add("900118+9811");

        //invalid
        personnummer.add("201701272394");
        personnummer.add("190302299812");
        personnummer.add("93071240344");
        personnummer.add("93072240a4");

        List<String> formated = Formated.format(personnummer);

        CheckedValidity checked = new CheckedValidity();
        checked.addValidityCheck(new LengthValidityCheck());
        checked.addValidityCheck(new DigitsValidityCheck());
        checked.addValidityCheck(new DateValidityCheck());
        checked.addValidityCheck(new CheckDigitValidityCheck());

        checked.check(formated);
        List<String> messages = checked.getMessages();


    }
}
