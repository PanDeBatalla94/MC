package org.gradle.sample;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class GreeterTest {
    public Greeter person;
    @Before
    public void init() {
        person = new Greeter();
    }
    
    @Test
    public void testGetPersonName() {    
        assertEquals("Barney", person.getName());
    }

    @Test
    public void testGetPersonLastName() {
        assertEquals("Gomez", person.getLastName());
    }
}
