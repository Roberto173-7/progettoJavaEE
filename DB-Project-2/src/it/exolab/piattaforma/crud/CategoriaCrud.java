package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.exolab.piattaforma.models.Categoria;

public class CategoriaCrud extends Crud<Categoria>
{

    @Override
    public Categoria insert(EntityManager entityManager, Categoria categoria)
    {
	if (!entityManager.contains(categoria))
	{
	    categoria = entityManager.merge(categoria);
	}
	entityManager.persist(categoria);

	return categoria;

    }

    @Override
    public Categoria update(EntityManager entityManager, Categoria categoria)
    {
	entityManager.merge(categoria);

	return categoria;

    }

    @Override
    public void delete(EntityManager entityManager, Categoria categoria)
    {
	if (entityManager.contains(categoria))
	{
	    entityManager.remove(categoria);
	} else
	{
	    entityManager.remove(entityManager.merge(categoria));
	}
    }

    @Override
    public Categoria findById(EntityManager entityManager, Integer idCategoria)
    {
	Categoria categoria = new Categoria();
	categoria = entityManager.find(Categoria.class, idCategoria);
	return categoria;
    }

    @Override
    public List<Categoria> findAll(EntityManager entityManager)
    {
	TypedQuery<Categoria> query	     = entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class);
	List<Categoria>	      listaCategorie = query.getResultList();

	return listaCategorie;

    }

}
