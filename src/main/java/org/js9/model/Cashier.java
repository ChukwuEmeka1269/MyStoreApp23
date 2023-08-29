package org.js9.model;

public class Cashier extends Staff{

    private static int CASHIER_COUNT = 0;

    public Cashier() {
        super();
        Cashier.CASHIER_COUNT++;
    }

    public Cashier(String firstName, String lastName, Gender gender, String email, StaffType staffType) {
        super(firstName, lastName, gender, email, staffType);
        Cashier.CASHIER_COUNT++;
    }


    public static int getStaffCount(){
        return CASHIER_COUNT;
    }

    @Override
    public String toString() {
        return "Cashier{} " + super.toString();
    }
}
