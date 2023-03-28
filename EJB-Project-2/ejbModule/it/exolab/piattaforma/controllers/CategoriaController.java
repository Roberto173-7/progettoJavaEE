package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.CategoriaCrud;
import it.exolab.piattaforma.ejb_interfaces.CategoriaInterface;
import it.exolab.piattaforma.models.Categoria;

@Stateless(name="CategoriaInterface")
@LocalBean
public class CategoriaController extends Controller<Categoria> implements CategoriaInterface
{
    // transazione gestita esplicitamente solo qui negli altri, @Transactional
    @Override
    public Categoria insert(Categoria categoria)
    {
	EntityTransaction transaction = entityManager.getTransaction();
	
	try
	{
	    transaction.begin();
	    CategoriaCrud   categoriaCrud = new CategoriaCrud();
	    categoria = categoriaCrud.insert(entityManager, categoria);
	    transaction.commit();
	    return categoria;
	} catch (Exception e)
	{
	    e.printStackTrace();
	    transaction.rollback();
	} finally
	{
	    entityManager.close();
	}
	return null;
    }

    @Override
    @Transactional
    public Categoria update(Categoria categoria)
    {
	try
	{
	    CategoriaCrud   categoriaCrud = new CategoriaCrud();
	    categoria = categoriaCrud.update(entityManager, categoria);
	    return categoria;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	
	return null;
    }

    @Override
    @Transactional
    public Categoria findById(Integer idCategoria)
    {
	try
	{
	    CategoriaCrud   categoriaCrud = new CategoriaCrud();
	    Categoria	    categoria	  = categoriaCrud.findById(entityManager, idCategoria);
	    return categoria;
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 
	return null;
    }

    @Override
    @Transactional
    public List<Categoria> findAll()
    {
	try
	{
	    CategoriaCrud   categoriaCrud = new CategoriaCrud();
	    List<Categoria>	    categorie	  = categoriaCrud.findAll(entityManager);
	    return categorie;
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 
	return null;
    }

    @Override
    @Transactional
    public void delete(Categoria categoria)
    {
	try
	{
	    CategoriaCrud categoriaCrud = new CategoriaCrud();
	    categoriaCrud.delete(entityManager, categoria);
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

}
