package com.company;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.testng.asserts.Assertion;

import java.util.HashMap;
import java.util.Map;

public class MyConverterTest {
    private final MyConverter myConverter = new MyConverter();
    @Test
    public void testToMap() {
        Object testObject = new MyClass(15, "John");
        Map<String, Object> result = myConverter.convertToMap(testObject);

        Assertions.assertEquals(result.toString(),"{number=15, name=John}");
    }

    @Test
    public void testToObj() {
        Map <String, Object> testMap = new HashMap<>();
        testMap.put("number", 15);
        testMap.put("name", "John");

        Object result = myConverter.convertToObj(testMap, MyClass.class);
        Object testObject = new MyClass(15, "John");


        Assertions.assertEquals(testObject, result);
    }
}