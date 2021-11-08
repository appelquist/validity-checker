package com.company;

import java.util.ArrayList;
import java.util.List;

public class DigitsValidityCheck implements ValidityCheck {
    private String message;
    private boolean isValid;
    @Override
    public void check(Personnummer number) {
        if (number == null) {
            message = "Is null";
            isValid = false;
        } else if (!number.getFormatedContent().matches("[0-9]+")) {
            message = "Contains letters or special characters";
            isValid = false;
        } else {
            isValid = true;
        }

    }
    @Override
    public void check(Samordningsnummer number) {
        if (number == null) {
            message = "Is null";
            isValid = false;
        } else if (!number.getFormatedContent().matches("[0-9]+")) {
            message = "Contains letters or special characters";
            isValid = false;
        } else {
            isValid = true;
        }
    }

    @Override
    public void check(Organisationsnummer number) {
        if(!number.getFormatedContent().matches("[0-9]+")) {
            message = "Contains letters or special characters";
            isValid = false;
        } else {
            isValid = true;
        }
    }

    @Override
    public boolean passed() {
        return this.isValid;
    }

    @Override
    public String getValidityCheckMessage() {
        return this.message;
    }
}
