package com.company;

import com.sun.jdi.CharType;

public class CheckDigitValidityCheck implements IValidityCheck {
    private String message = "Has incorrect check number";
    @Override
    public boolean check(String personnummer) {
        return luhn(personnummer) == 0;
    }

    private int luhn(String personnummer) {
        if (personnummer.length() == 12) {
            personnummer = personnummer.substring(2);
        }
        int temp;
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            temp = Character.getNumericValue(personnummer.charAt(i));
            temp *= 2 - (i % 2);
            if (temp > 9) {
                temp -= 9;
            }
            sum += temp;
        }
        return (10 - (sum % 10)) % 10;
    }

    @Override
    public String getValidityCheckMessage() {
        return this.message;
    }
}
