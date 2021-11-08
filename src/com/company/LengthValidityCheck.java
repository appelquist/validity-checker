package com.company;

import java.util.ArrayList;
import java.util.List;

public class LengthValidityCheck implements ValidityCheck{
    private String message = "Incorrect length";
    @Override
    public boolean check(String input) {
        String personnummer = input;
        personnummer.trim();
        personnummer.replace("-", "");
        if (personnummer.length() == 10) {
            personnummer = "19" + personnummer;
        }
        if (personnummer.length() != 12) {
            return false;
        }
        return true;
    }

    @Override
    public String getValidityCheckMessage() {
        return this.message;
    }
}
