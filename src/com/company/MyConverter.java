package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MyConverter implements IConverter {

    public Map<String, Object> convertToMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        map.put("class", object.getClass().getName());
        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (isSimpleType(field.getType())) {
                    map.put(field.getName(), field.get(object).toString());
                } else {
                    map.put(field.getName(), convertToMap(field.get(object)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @Override
    public Object convertToObj(Map<String, Object> objectMap) {
        try {
            Class<?> c = Class.forName((String) objectMap.get("class"));
            Object object = c.newInstance();
            for (Field field : object.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (isSimpleType(field.getType())) {
                        System.out.println(objectMap.get(field.getName()));
                        Field modifiersField = Field.class.getDeclaredField("modifiers");
                        modifiersField.setAccessible(true);
                        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                        field.set(object, field.getType().cast(objectMap.get(field.getName())));
                    } else {
                        field.set(object, convertToObj((Map<String, Object>) objectMap.get(field.getName())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return object;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isSimpleType(Class<?> type) {
        return type.isPrimitive() ||
                Boolean.class == type ||
                Character.class == type ||
                CharSequence.class.isAssignableFrom(type) ||
                Number.class.isAssignableFrom(type) ||
                Enum.class.isAssignableFrom(type);
    }

//    public Object convertToObj(Map<String, Object>){
//
//        return
//    }
}
