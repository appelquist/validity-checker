package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<CandidateNumber> candidateNumbers = new ArrayList<CandidateNumber>();

        //valid
        candidateNumbers.add(new Personnummer("141206-2380"));
        candidateNumbers.add(new Personnummer("20080903-2386"));
        candidateNumbers.add(new Personnummer("7101169295"));
        candidateNumbers.add(new Personnummer("189912299816"));
        candidateNumbers.add(new Personnummer("900118+9811"));
        candidateNumbers.add(new Samordningsnummer("190910799824"));
        candidateNumbers.add(new Organisationsnummer("556614-3185"));
        candidateNumbers.add(new Organisationsnummer("16556601-6399"));
        candidateNumbers.add(new Organisationsnummer("262000-1111"));
        candidateNumbers.add(new Organisationsnummer("857202-7566"));

        //invalid
        candidateNumbers.add(new Personnummer("201701272394"));
        candidateNumbers.add(new Personnummer("190302299812"));
        candidateNumbers.add(new Personnummer("93071240344"));
        candidateNumbers.add(new Personnummer("93072240a4"));
        candidateNumbers.add(new Samordningsnummer("091092-9824"));
        candidateNumbers.add(new Organisationsnummer("551914-3185"));
        candidateNumbers.add(new Personnummer(""));

        CheckedValidity checked = new CheckedValidity();
        checked.addValidityCheck(new LengthValidityCheck());
        checked.addValidityCheck(new DigitsValidityCheck());
        checked.addValidityCheck(new DateValidityCheck());
        checked.addValidityCheck(new CheckDigitValidityCheck());

        checked.check(candidateNumbers);
        checked.printResult();
    }
}
