package Model;

import Controller.ActionPeson;

public class Person implements ActionPeson {
    private int Id;

    public Person(int id, String firstName, String lastName, Double diemTB) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.diemTB = diemTB;
    }

    private String firstName;
    private String lastName;
    private Double diemTB;

    public Person() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", fullName='" + firstName + " "+ lastName+ '\'' +
                ", diemTB=" + diemTB +
                '}';
    }

    @Override
    public String createName() {
        return this.getFirstName() + " Văn " + this.getLastName();
    }
}
