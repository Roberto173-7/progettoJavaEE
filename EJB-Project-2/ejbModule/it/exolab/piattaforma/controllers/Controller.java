package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Controller<T>
{
    protected String entityProjectName = "JPA-Project-2"; //nome del progetto in cui sono mappate le Entity 
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(entityProjectName);
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public abstract T insert(T model);

    public abstract T update(T model);

    public abstract T findById(Integer idModel);

    public abstract List<T> findAll();

    public abstract void delete(T model);
}
