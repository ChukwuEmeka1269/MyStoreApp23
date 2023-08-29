package org.js9.model;

public enum StaffType {
    MANAGER("MAN"),
    CASHIER("CASH");

    private final String value;

    private StaffType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
