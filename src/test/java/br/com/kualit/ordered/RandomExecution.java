package br.com.kualit.ordered;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//Use this annotation to run the methods in aleatory order
@TestMethodOrder(MethodOrderer.Random.class)
public class RandomExecution {

    @Test
    void TestA(){}

    @Test
    void TestB(){}

    @Test
    void TestC(){}

    @Test
    void TestD(){}
}
