package com.company;

import java.lang.reflect.Proxy;
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
        MyConverter myConverter = new MyConverter();
        IConverter converterProxy = (IConverter) Proxy.newProxyInstance(
                MyConverter.class.getClassLoader(),
                MyConverter.class.getInterfaces(),
                new MyInvocationHandler(myConverter)
        );
//        converterProxy.convertToMap(object);
        Map<String, Object> result = converterProxy.convertToMap(object);
        Object newObj = converterProxy.convertToObj(result);
        System.out.println(newObj.toString());
        System.out.println(result);//output 0default
    }


}
