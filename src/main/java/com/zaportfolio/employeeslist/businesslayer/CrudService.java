package com.zaportfolio.employeeslist.businesslayer;

import java.util.List;

public interface CrudService <T, ID> {
        List<T> findAll();
        T findById(ID id);
        T create(T object);
        T update(ID id, T object);
        void deleteById(ID id);
}
