package model;

public class Student {

    private int id;
    private String name;
    private String surname;
    private String location;

    public Student() { }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " { id: " + id +
                ", name: " + name +
                ", surname: " + surname +
                ", location: " + location +
                " }";
    }

}
