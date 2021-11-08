package com.company;

public class Personnummer implements CandidateNumber{
    private String originalContent;
    private String formatedContent;


    public Personnummer(String personnummer) {
        this.originalContent = personnummer;
        this.formatedContent = personnummer.trim().replace("-","").replace("+", "");
    }

    @Override
    public void check(ValidityCheck validityCheck) {
        validityCheck.check(this);
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
