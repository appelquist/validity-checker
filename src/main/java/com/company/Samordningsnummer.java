package com.company;

public class Samordningsnummer implements CandidateNumber {
    private String originalContent;
    private String formatedContent;

    public Samordningsnummer(String samordningsnummer) {
        this.originalContent = samordningsnummer;
        this.formatedContent = samordningsnummer.trim().replace("-", "").replace("+","");
    }
    @Override
    public void check(ValidityCheck validityCheck) {
        validityCheck.check(this);
    }
    @Override
    public String getOriginalContent() {
        return originalContent;
    }

    @Override
    public String getFormatedContent() {
        return formatedContent;
    }
}
