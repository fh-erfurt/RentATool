package de.rat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    //Given
    Department department = new Department("Salling");

    @Test
    void should_give_the_Department(){

      assertEquals("Salling",department.getDepName());

    }
    @Test
    void should_set_new_Address(){
        department.setDepName("Management");
        assertEquals("Management",department.getDepName());

    }

}