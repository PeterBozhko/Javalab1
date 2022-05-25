package com.company;

import java.util.Map;

public interface IConverter {
    public Map<String, Object> convertToMap(Object object);
    public Object convertToObj(Map<String, Object> objectMap);
}
