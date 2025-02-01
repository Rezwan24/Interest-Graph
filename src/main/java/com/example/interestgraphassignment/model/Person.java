package com.example.interestgraphassignment.model;

public class Person {
    private String name;
    private int id;
    private int age;
    private String occupation;

    public Person(String name, int id, int age, String occupation) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.occupation = occupation;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
