package org.js9.model;

public enum Post {
    CASHIER("cashier"),
    MANAGER("manager");
    private final String value;

     Post(String value){
        this.value = value;
    }

    public String getValue(){
         return value;
    }
}
