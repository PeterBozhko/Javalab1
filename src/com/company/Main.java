package com.company;

import java.lang.reflect.Proxy;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Object object = new MyClass(15, "John");
        MyConverter myConverter = new MyConverter();
        IConverter converterProxy = (IConverter) Proxy.newProxyInstance(
                MyConverter.class.getClassLoader(),
                MyConverter.class.getInterfaces(),
                new MyInvocationHandler(myConverter)
        );
        Map<String, Object> result = converterProxy.convertToMap(object);
        Object newObj = converterProxy.convertToObj(result, MyClass.class);

        System.out.println(newObj.toString());
        System.out.println(result);
    }


}
