package org.js9.model;


import org.js9.util.RandomAlphaNumericGenerator;

public class Staff extends Person{
    private String email;
    private String staffId;
    private StaffType staffType;

    private Store store;
    private static int STAFF_COUNT = 0;

    public Staff() {
        super();
        Staff.STAFF_COUNT = increaseStaffCount();
        this.staffId = getIdForStaff();
    }



    public Staff(String email) {
        super();
        this.email = email;
        this.staffId = getIdForStaff();
    }

    public Staff(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;
        this.staffId = getIdForStaff();
    }

    public Staff(String firstName, String lastName, Gender gender, String email) {
        super(firstName, lastName, gender);
        this.email = email;
        this.staffId = getIdForStaff();
    }

    public Staff(String firstName, String lastName, Gender gender, Address address, String email) {
        super(firstName, lastName, gender, address);
        this.email = email;
        this.staffId = getIdForStaff();
    }

    public Staff(String firstName, String lastName, Gender gender, String email, StaffType staffType) {
        super(firstName, lastName, gender);
        this.email = email;
        this.staffType = staffType;
    }

    private  String getIdForStaff() {
        return RandomAlphaNumericGenerator.generateRandomAlphaNumericForStaff(getStaffType(), Staff.STAFF_COUNT);
    }

    private static int increaseStaffCount(){
        return STAFF_COUNT++;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public StaffType getStaffType() {
        return this.staffType;
    }

    public void setStaffType(StaffType staffType) {
        this.staffType = staffType;
    }

    public  static int getStaffCount() {
        return STAFF_COUNT;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public static void setStaffCount(int staffCount) {
        STAFF_COUNT = 0;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "email='" + email + '\'' +
                ", staffId='" + staffId + '\'' +
                ", staffType=" + staffType +
                ", store=" + store +
                "} " + super.toString();
    }
}
