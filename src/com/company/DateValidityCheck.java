package com.company;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;

public class DateValidityCheck implements ValidityCheck {
    private LocalDate date;
    private LocalDate toDay = LocalDate.now();
    private String message;

    @Override
    public boolean check(String personnummer) {
        return isValidDate(personnummer) && isNotInFuture();
    }

    private boolean isNotInFuture() {
        if (date.compareTo((toDay)) > 0) {
            message = "Has date in future";
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidDate(String personnummer) {
        try {
            int year = parseInt(personnummer.substring(0, 4));
            int month = parseInt(personnummer.substring(4, 6));
            int day = parseInt((personnummer.substring(6, 8)));
            date = LocalDate.of(year, month, day);
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
