package org.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PersonTest {
    public Person person;
    @Before
    public void init() {
        person = new Person("Barney",
        "Gomez",
        "34546",
        "Administration",
        3500,
        "Accountant");
    }
    
    @Test
    public void testGetPersonName() {    
        assertEquals("Barney", person.getName());
    }

    @Test
    public void testGetPersonLastName() {
        assertEquals("Gomez", person.getLastName());
    }

    @Test
    public void testGetPersonNameLastName() {
        assertEquals("Barney Gomez", person.getNameLastName());
    }

    @Test
    public void testGetNameLastNameUpperCase() {
        assertEquals("BARNEY GOMEZ", person.getNameLastNameUpperCase());
    }

    @Test
    public void testGetSalary() {
        assertEquals(3500, person.getSalary(), 0);
    }

    @Test
    public void testGetDiscount() {
        assertEquals(10, person.getDiscount(), 0);
    }

    @Test
    public void testGetDepartment() {
        assertEquals("Administration", person.getDepartment());
    }

    @Test
    public void testGetTotalSalary() {
        assertEquals(3150, person.getTotalSalary(), 0);
    }

    @Test
    public void testGetPresentation() {
        assertEquals("Name: Barney Gomez\n Department: Administration\n Position: Accountant", person.getPresentationCard());
    }

    @Test
    public void testGetPosition() {
        assertEquals("Accountant", person.getPosition());
    }

    @Test
    public void testGetAge() {
        assertEquals(30, person.getAge());
    }

    @Test
    public void testGetId() {
        assertEquals("34546", person.getId());
    }
}
