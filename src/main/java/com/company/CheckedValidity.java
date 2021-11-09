package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to check swedish identity numbers.
 * Results will be saved to messages attribute.
 */
public class CheckedValidity {
    private List<ValidityCheck> validityChecks = new ArrayList<ValidityCheck>();
    private List<String> messages = new ArrayList<String>();

    public void addValidityCheck(ValidityCheck validityCheck) {
        validityChecks.add(validityCheck);
    }

    /**
     * Will iterate through all ValidityCheck's and perform them on the provided CandidateNumber.
     * Results for the provided CandidateNumber will be saved to the List messages.
     * @param number
     */
    public void check(CandidateNumber number) {
        if (number == null) {
            messages.add("No number provided");
        } else {
            boolean isValid = false;
            String message = number.getClass().getSimpleName() + ": " + number.getOriginalContent();
            for (int i = 0; i < validityChecks.size(); i++) {
                ValidityCheck validityCheck = validityChecks.get(i);
                number.check(validityCheck);
                isValid = validityCheck.passed();
                if (!isValid) {
                    message += " : failed | message: " + validityCheck.getValidityCheckMessage();
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

    /**
     * Will iterate through all provided numbers and run checks on them.
     * @param numbers
     */
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
