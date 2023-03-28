package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;

import it.exolab.piattaforma.models.FilmCategoria;


public class FilmCategoriaCrud extends Crud<FilmCategoria>
{

    @Override
    public FilmCategoria insert(EntityManager entityManager, FilmCategoria filmCategoria)
    {
	if (!entityManager.contains(filmCategoria)) 
	{
	    filmCategoria = entityManager.merge(filmCategoria);
	}
	    
	    entityManager.persist(filmCategoria);
	
	return filmCategoria;

    }

    @Override
    public FilmCategoria update(EntityManager entityManager, FilmCategoria filmCategoria)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(EntityManager entityManager, FilmCategoria filmCategoria)
    {
	if (entityManager.contains(filmCategoria)) 
	{
	    entityManager.remove(filmCategoria);
	}
	else
	{
	    entityManager.remove(entityManager.merge(filmCategoria));
	}

    }

    @Override
    public FilmCategoria findById(EntityManager entityManager, Integer idFilmCategoria)
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<FilmCategoria> findAll(EntityManager entityManager)
    {
	// TODO Auto-generated method stub
	return null;
    }

}
