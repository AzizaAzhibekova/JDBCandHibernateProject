package com.peaksoft.model;

import javax.persistence.*;

<<<<<<< HEAD
@Table
=======
@Entity
@Table(name = "users")
>>>>>>> 9aba5b7 (Initial commit)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

<<<<<<< HEAD
    @Column
=======
    @Column(name = "last_name")
>>>>>>> 9aba5b7 (Initial commit)
    private String lastName;

    @Column
    private Byte age;

    public User() {
    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}