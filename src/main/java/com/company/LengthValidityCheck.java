package com.company;

/**
 * Class to validate that a CandidateNumber has correct length.
 */
public class LengthValidityCheck implements ValidityCheck{
    private String message;
    private boolean isValid;
    @Override
    public void check(Personnummer number) {
        if (number.getFormatedContent().length() == 10 | number.getFormatedContent().length() == 12) {
            isValid = true;
        } else {
            message = "Incorrect length";
            isValid = false;
        }
    }

    @Override
    public void check(Samordningsnummer number) {
        if (number.getFormatedContent().length() == 10 | number.getFormatedContent().length() == 12) {
            isValid = true;
        } else {
            message = "Incorrect length";
            isValid = false;
        }
    }

    @Override
    public void check(Organisationsnummer number) {
        if (number.getFormatedContent().length() == 10 | number.getFormatedContent().length() == 12) {
            isValid = true;
        } else {
            message = "Incorrect length";
            isValid = false;
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
