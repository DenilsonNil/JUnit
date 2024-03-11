package br.com.kualit.ordered;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//Use this annotation to run the methods in alphabetic order (Default)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderedByName {

    @Test
    void TestA(){}

    @Test
    void TestB(){}

    @Test
    void TestC(){}

    @Test
    void TestD(){}
}
