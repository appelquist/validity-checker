package com.company;

/**
 * Class used to validate check digit of a CandidateData object.
 */
public class CheckDigitValidityCheck implements ValidityCheck {
    private String message = "Has incorrect check number";
    private boolean isValid;
    @Override
    public void check(Personnummer number) {
        if (luhn(number.getFormatedContent()) == 0) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    @Override
    public void check(Samordningsnummer number) {
        if (luhn(number.getFormatedContent()) == 0) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    @Override
    public void check(Organisationsnummer number) {
        if (luhn(number.getFormatedContent()) == 0) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    @Override
    public boolean passed() {
        return this.isValid;
    }

    private int luhn(String number) {
        if (number.length() == 12) {
            number = number.substring(2);
        }
        int temp;
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            temp = Character.getNumericValue(number.charAt(i));
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
