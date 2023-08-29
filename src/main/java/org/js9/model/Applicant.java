package org.js9.model;

public class Applicant extends Person{
    private int age;
    private String email;
    private Qualification qualification;

    private Post appliedPosition;

    public Applicant() {
        super();
    }

    public Applicant(String firstName, String lastName, int age, String email, Qualification qualification) {
        super(firstName, lastName);
        this.age = age;
        this.email = email;
        this.qualification = qualification;
    }

    public Applicant(String firstName, String lastName, Gender gender, int age, String email, Qualification qualification) {
        super(firstName, lastName, gender);
        this.age = age;
        this.email = email;
        this.qualification = qualification;
    }

    public Applicant(int age, String email, Qualification qualification, Post appliedPosition) {
        this.age = age;
        this.email = email;
        this.qualification = qualification;
        this.appliedPosition = appliedPosition;
    }

    public Applicant(String firstName, String lastName, int age, String email, Qualification qualification, Post appliedPosition) {
        super(firstName, lastName);
        this.age = age;
        this.email = email;
        this.qualification = qualification;
        this.appliedPosition = appliedPosition;
    }

    public Applicant(String firstName, String lastName, Gender gender, int age, String email, Qualification qualification, Post appliedPosition) {
        super(firstName, lastName, gender);
        this.age = age;
        this.email = email;
        this.qualification = qualification;
        this.appliedPosition = appliedPosition;
    }

    public Applicant(String firstName, String lastName, Gender gender, Address address, int age, String email, Qualification qualification, Post appliedPosition) {
        super(firstName, lastName, gender, address);
        this.age = age;
        this.email = email;
        this.qualification = qualification;
        this.appliedPosition = appliedPosition;
    }

    public Post getAppliedPosition() {
        return appliedPosition;
    }

    public void setAppliedPosition(Post appliedPosition) {
        this.appliedPosition = appliedPosition;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }
}
