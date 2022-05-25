package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Object object = new MyClass(15, "John");
//        try {
//            System.out.println(MyClass.class.getName());
//            Class<?> testClass = Class.forName(MyClass.class.getName());
//            Constructor<?> testClassConstr = testClass.getConstructor();
//            object = testClassConstr.newInstance();
//        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//            return;
//        }
        Converter converter = new Converter();
        Map<String, Object> result = converter.convertToMap(object);
        System.out.println(result);//output 0default
    }


}
