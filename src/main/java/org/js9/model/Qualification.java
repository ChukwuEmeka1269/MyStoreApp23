package org.js9.model;

public enum Qualification {

    Doctorate("PhD"),
    Masters("MSc"),
    Degree("BSc"),
    HigherDiploma("HND"),
    OrdinaryDiploma("OND"),
    SecondarySchool("SSCE");


    private final String value;

    private Qualification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
