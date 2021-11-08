package com.company;

import java.util.ArrayList;
import java.util.List;

public class CheckedValidity {
    private List<ValidityCheck> validityChecks = new ArrayList<ValidityCheck>();
    private List<String> messages = new ArrayList<String>();

    public void addValidityCheck(ValidityCheck validityCheck) {
        validityChecks.add(validityCheck);
    }

    public void check(String personnummer) {
        boolean isValid = false;
        String message = personnummer;
        for (int i = 0; i < validityChecks.size(); i++) {
            isValid = validityChecks.get(i).check(personnummer);
            if (!isValid) {
                message += " : failed | message: " + validityChecks.get(i).getValidityCheckMessage();
                messages.add(message);
                break;
            }
        }
        if (isValid) {
            message += ": valid";
            messages.add(message);
        }
    }

    public void check(List<String> personnummer) {
        if (personnummer.isEmpty()) {
            System.err.println("Empty list provided");
        } else {
            for (int i = 0; i < personnummer.size(); i++) {
                check(personnummer.get(i));
            }
        }
    }

    public List<String> getMessages() {
        return this.messages;
    }
}
