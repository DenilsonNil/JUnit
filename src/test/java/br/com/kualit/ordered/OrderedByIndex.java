package br.com.kualit.ordered;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//Use this annotation to run the methods by index order
//Integration tests sometimes needs a specific execution order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Order(1) // This annotation executes the CLASS firstly. [needs to configure JUnit at the file junit.platform.properties]
public class OrderedByIndex {

    @Test
    @Order(2)
    void TestA(){}

    @Test
    @Order((0))
    void TestB(){}

    @Test
    @Order(3)
    void TestC(){}

    @Test
    @Order(1)
    void TestD(){}
}
