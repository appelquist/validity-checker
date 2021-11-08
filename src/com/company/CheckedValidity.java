package com.company;

import java.util.ArrayList;
import java.util.List;

public class CheckedValidity {
    private List<ValidityCheck> validityChecks = new ArrayList<ValidityCheck>();
    private List<String> messages = new ArrayList<String>();

    public void addValidityCheck(ValidityCheck validityCheck) {
        validityChecks.add(validityCheck);
    }

    public void check(CandidateNumber number) {
        if (number == null) {
            messages.add("No number provided");
        } else {
            boolean isValid = false;
            String message = number.getOriginalContent();
            for (int i = 0; i < validityChecks.size(); i++) {
                number.check(validityChecks.get(i));
                isValid = validityChecks.get(i).passed();
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
    }

    public void check(List<CandidateNumber> numbers) {
        if (numbers.isEmpty()) {
            System.err.println("Empty list provided");
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                check(numbers.get(i));
            }
        }
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public void printResult() {
        System.out.println("Checks finished, results below:");
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }
}
