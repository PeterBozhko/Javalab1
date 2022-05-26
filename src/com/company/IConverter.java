package com.company;

import java.util.Map;

public interface IConverter {
    Map<String, Object> convertToMap(Object object);
    <T> T convertToObj(Map<String, Object> objectMap, Class<T> clazz);
}
