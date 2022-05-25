package com.company;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Converter {
    public Converter() {}

    public Map<String, Object> convertToMap(Object object) {
        Map<String, Object> map = new HashMap<>();
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
