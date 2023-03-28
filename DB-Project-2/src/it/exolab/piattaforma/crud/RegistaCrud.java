package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.exolab.piattaforma.models.Regista;

public class RegistaCrud extends Crud<Regista>
{

    @Override
    public Regista insert(EntityManager entityManager, Regista regista)
    {
	if (!entityManager.contains(regista)) 
	{
	    regista = entityManager.merge(regista);
	}
	entityManager.persist(regista);
	
	return regista;

    }

    @Override
    public Regista update(EntityManager entityManager, Regista regista)
    {
	entityManager.merge(regista);
	
	return regista;

    }

    @Override
    public void delete(EntityManager entityManager, Regista regista)
    {
	if (entityManager.contains(regista)) 
	{
	    entityManager.remove(regista);
	}
	else
	{
	    entityManager.remove(entityManager.merge(regista));
	}

    }

    @Override
    public Regista findById(EntityManager entityManager, Integer idRegista)
    {
	Regista regista = new Regista();
	regista = entityManager.find(Regista.class, idRegista);
	return regista;

    }

    @Override
    public List<Regista> findAll(EntityManager entityManager)
    {
	TypedQuery<Regista> lQuery = entityManager.createQuery("SELECT r FROM Regista r", Regista.class);
	List<Regista> listaRegisti = lQuery.getResultList();
	
	return listaRegisti;

    }

}
