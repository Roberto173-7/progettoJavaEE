package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class Crud<T>
{      
    public abstract T insert(EntityManager entityManager, T model);

    public abstract T update(EntityManager entityManager, T model);

    public abstract void delete(EntityManager entityManager, T model);

    public abstract T findById(EntityManager entityManager, Integer idModel);

    public abstract List<T> findAll(EntityManager entityManager);
}
