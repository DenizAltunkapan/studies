package firstSemester.tests;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import firstSemester.pse.immutability.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {


    @BeforeEach
    void setUp(){
        Address myAddress = new Address("Ludwigsburg", "Reichertshalde", 8);
        //Person deniz = new Person(myAddress, "Deniz", 19);
    }

    @Test
    void testHouseNumber(){
    }


}
