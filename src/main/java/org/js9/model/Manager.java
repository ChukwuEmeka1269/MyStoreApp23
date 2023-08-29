package org.js9.model;


public class Manager extends Staff {


    private static int MANAGERS_COUNT = 0;
    public Manager() {
        super();
        MANAGERS_COUNT++;
    }



    public Manager(String firstName, String lastName, Gender gender, String email) {
        super(firstName, lastName, gender, email);
        MANAGERS_COUNT++;
    }

    public Manager(String firstName, String lastName, Gender gender, String email, StaffType staffType) {
        super(firstName, lastName, gender, email, staffType);
        MANAGERS_COUNT++;
    }

    public static int getStaffCount(){
        return MANAGERS_COUNT;
    }


}
