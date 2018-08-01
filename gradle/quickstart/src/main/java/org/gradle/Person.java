package org.gradle;

import org.apache.commons.collections.list.GrowthList;

public class Person {
    private final String name;
    private final String lastName;
    private final String id;
    private final String department;
    private final String position;
    private final float salary;
    private final float discounts;
    private final int age;

    public Person(String name, String lastName, String id, String department, float salary, String position) {
        this.name = name;
        this.lastName = lastName;
        this.age = 30;
        this.id = id;
        this.department = department;
        this.salary = salary;
        this.discounts = 10;
        this.position = position;

        new GrowthList();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNameLastName() {
        return name+" "+lastName;
    }

    public String getNameLastNameUpperCase() {
        return name.toUpperCase()+" "+lastName.toUpperCase();
    }

    public String getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    public float getTotalSalary() {
        return salary - (salary*discounts/100);
    }

    public float getDiscount() {
        return discounts;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getPresentationCard() {
        return "Name: "+name+" "+lastName+"\n Department: "+department+"\n Position: "+position;
    }

    public int getAge() {
        return age;
    }
}
