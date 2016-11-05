package ru.ildar66.bm.services.impl;

import java.util.List;

import org.apache.tapestry5.ValueEncoder;

import ru.ildar66.bm.common.entity.IndexedEntity;

/**
 * ValueEncoder for indexed entity
 * 
 * @author Shafigullin Ildar
 * 
 */
public class BaseEntityValueEncoder<T extends IndexedEntity<?>> implements ValueEncoder<T> {

    private List<T> list;

    public BaseEntityValueEncoder(List<T> list) {
        this.list = list;
    }

    //@Override
    public String toClient(T value) {
        if (value == null) {
            return null;
        }
        return String.valueOf(value.getId());
    }

    //@Override
    public T toValue(String clientValue) {
        if (clientValue == null || list == null) {
            return null;
        }
        for (T object : list) {
            if (clientValue.equals(String.valueOf(object.getId()))) {
                return object;
            }
        }
        return null;
    }
}
