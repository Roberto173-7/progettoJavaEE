package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;

import it.exolab.piattaforma.models.Ruolo;


public class RuoloCrud extends Crud<Ruolo>
{

    @Override
    public Ruolo insert(EntityManager entityManager, Ruolo ruolo)
    {
	if (!entityManager.contains(ruolo)) 
	{
	    ruolo = entityManager.merge(ruolo);
	}
	entityManager.persist(ruolo);
	
	return ruolo;

    }

    

    @Override
    public void delete(EntityManager entityManager, Ruolo ruolo)
    {
	if (entityManager.contains(ruolo)) 
	{
	    entityManager.remove(ruolo);
	}
	else
	{
	    entityManager.remove(entityManager.merge(ruolo));
	}
    }



    @Override
    public Ruolo update(EntityManager entityManager, Ruolo model)
    {
	// TODO Auto-generated method stub
	return null;
    }



    @Override
    public Ruolo findById(EntityManager entityManager, Integer idModel)
    {
	// TODO Auto-generated method stub
	return null;
    }



    @Override
    public List<Ruolo> findAll(EntityManager entityManager)
    {
	// TODO Auto-generated method stub
	return null;
    }

}
