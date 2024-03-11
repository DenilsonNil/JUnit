package br.com.kualit.integrationinstances;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//This annotation creates just one class instance to execute all methods.
//By default, the JUnit crates one class instance per method, in some scenarios may be necessary share class data to the methods.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClassTestA {


    StringBuilder builder = new StringBuilder("");

    @AfterEach
    void tearDown() {
        System.out.println("The actual value is = " + builder);
    }

    @Test
    void TestA(){
        builder.append("1 ");
    }

    @Test
    void TestB(){
        builder.append("2 ");
    }

    @Test
    void TestC(){
        builder.append("3 ");
    }

    @Test
    void TestD(){
        builder.append("4");
    }
}
