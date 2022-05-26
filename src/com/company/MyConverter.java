package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyConverter implements IConverter {

    public Map<String, Object> convertToMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                    map.put(field.getName(), field.get(object));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public <T> T convertToObj(Map<String, Object> objectMap, Class<T> clazz) {
        try {
            T object = clazz.getConstructor().newInstance();
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(object, objectMap.get(field.getName()));
            }
            return object;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
