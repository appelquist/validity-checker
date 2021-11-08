package com.company;

public interface ValidityCheck {
    void check(Personnummer number);
    void check(Samordningsnummer number);
    void check(Organisationsnummer number);
    boolean passed();
    String getValidityCheckMessage();
}
