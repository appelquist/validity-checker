package com.company;

import java.util.ArrayList;
import java.util.List;

public class DigitsValidityCheck implements ValidityCheck {
    private String message = "Contains letters or special characters";

    @Override
    public boolean check(String personnummer) {
        if (!personnummer.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    @Override
    public String getValidityCheckMessage() {
        return this.message;
    }
}
