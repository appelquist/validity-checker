package com.company;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class DateValidityCheck implements ValidityCheck {
    private LocalDate date;
    private LocalDate toDay = LocalDate.now();
    private String message;
    private boolean isValid;

    @Override
    public void check(Personnummer number) {
        if (isValidDate(number) && isNotInFuture()) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    @Override
    public void check(Samordningsnummer number) {
        if (isValidDate(number) && isNotInFuture()) {
            isValid = true;
        } else {
            isValid = false;
        }
    }

    @Override
    public void check(Organisationsnummer number) {
        int middlePair;
        if (number.getFormatedContent().length() == 10) {
            middlePair = parseInt(number.getFormatedContent().substring(2,4));
            if (middlePair < 20) {
                message = "Has invalid middle pair number";
                isValid = false;
            } else {
                isValid = true;
            }
        }
    }

    @Override
    public boolean passed() {
        return this.isValid;
    }

    private boolean isNotInFuture() {
        if (date.compareTo((toDay)) > 0) {
            message = "Has date in future";
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidDate(Personnummer number) {
        int year;
        int month;
        int day;
        if (number.getFormatedContent().length() == 10) {
            year = parseInt(number.getFormatedContent().substring(0, 2));
            month = parseInt(number.getFormatedContent().substring(2, 4));
            day = parseInt((number.getFormatedContent().substring(4, 6)));
        } else {
            year = parseInt(number.getFormatedContent().substring(0, 4));
            month = parseInt(number.getFormatedContent().substring(4, 6));
            day = parseInt((number.getFormatedContent().substring(6, 8)));
        }
        try {
            date = LocalDate.of(year, month, day);
            return true;
        } catch (Exception e) {
            message = "Has invalid date";
            return false;
        }
    }

    private boolean isValidDate(Samordningsnummer number) {
        int year;
        int month;
        int day;
        if (number.getFormatedContent().length() == 10) {
            year = parseInt(number.getFormatedContent().substring(0, 2));
            month = parseInt(number.getFormatedContent().substring(2, 4));
            day = parseInt((number.getFormatedContent().substring(4, 6)));
        } else {
            year = parseInt(number.getFormatedContent().substring(0, 4));
            month = parseInt(number.getFormatedContent().substring(4, 6));
            day = parseInt((number.getFormatedContent().substring(6, 8)));
        }
        try {
            date = LocalDate.of(year, month, day - 60);
            return true;
        } catch (Exception e) {
            message = "Has invalid date";
            return false;
        }
    }

    @Override
    public String getValidityCheckMessage() {
        return this.message;
    }
}
