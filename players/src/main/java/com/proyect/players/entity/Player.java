package com.proyect.players.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String position;
    private String team;
    private int number;
    private int age;
    private int cellPhone;
    
    public Player() {
    }

    

    public Player(String name, String lastName, String position, String team, int number, int age, int cellPhone) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.team = team;
        this.number = number;
        this.age = age;
        this.cellPhone = cellPhone;
    }



    public int getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", lastName=" + lastName + ", position=" + position + ", team="
                + team + ", number=" + number + ", age=" + age + ", cellPhone=" + cellPhone + "]";
    }

    
}