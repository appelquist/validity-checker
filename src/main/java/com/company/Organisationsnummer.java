package com.company;

public class Organisationsnummer implements CandidateNumber {
    private String originalContent;
    private String formatedContent;

    @Override
    public void check(ValidityCheck validityCheck) {
        validityCheck.check(this);
    }

    public Organisationsnummer(String organisationsnummer) {
        this.originalContent = organisationsnummer;
        this.formatedContent = organisationsnummer.trim().replace("-","").replace("+","");
    }

    @Override
    public String getOriginalContent() {
        return this.originalContent;
    }

    @Override
    public String getFormatedContent() {
        return this.formatedContent;
    }
}
