package com.springsecurity.springsecurityauth.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    //test case for the constructor

    @Test
    void getId() {
        //creating object of Student class
        Student student = new Student(1, "Ramesh", "Java");
        //checking the condition
        assertEquals(1, student.getId());
        //creating object of Student class
        Student student1 = new Student(2, "Suresh", "Spring");
        //checking the condition
        assertEquals(2, student1.getId());


    }

    @Test
    void getName() {
    }

    @Test
    void getCourse() {
    }
}