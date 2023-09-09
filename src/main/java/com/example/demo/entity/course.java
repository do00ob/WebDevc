package com.example.demo.entity;

public class course {
    private String id;
    private String name;
    private double credit;

    public course(String id, String name, double credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){ this.name = name;}
    public double getCredit() {
        return this.credit;
    }
    public void setCredit(double credit){ this.credit = credit;}

    public String getId() {
        return this.id;
    }
    public void setId(String id){ this.id = id;}

    public String toString() {
        return this.id + ", " + this.name + ", " + this.credit;
    }
}
