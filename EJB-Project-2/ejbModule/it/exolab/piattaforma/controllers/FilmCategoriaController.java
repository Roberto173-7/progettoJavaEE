package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.FilmCategoriaCrud;
import it.exolab.piattaforma.ejb_interfaces.FilmCategoriaInterface;
import it.exolab.piattaforma.models.FilmCategoria;


@Stateless(name="FilmCategoriaInterface")
@LocalBean
public class FilmCategoriaController extends Controller<FilmCategoria> implements FilmCategoriaInterface
{
    @Override
    @Transactional
    public FilmCategoria insert(FilmCategoria filmCategoria)
    {
	try
	{
	    FilmCategoriaCrud	filmCategoriaCrud = new FilmCategoriaCrud();
	    filmCategoria = filmCategoriaCrud.insert(entityManager, filmCategoria);

	    return filmCategoria;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }


    @Override
    @Transactional
    public void delete(FilmCategoria filmCategoria)
    {
	try
	{
	    FilmCategoriaCrud	filmCategoriaCrud = new FilmCategoriaCrud();
	    filmCategoriaCrud.delete(entityManager, filmCategoria);
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

    }


    @Override
    @Transactional
    public FilmCategoria update(FilmCategoria model)
    {
	// TODO Auto-generated method stub
	return null;
    }


    @Override
    @Transactional
    public FilmCategoria findById(Integer idModel)
    {
	// TODO Auto-generated method stub
	return null;
    }


    @Override
    @Transactional
    public List<FilmCategoria> findAll()
    {
	// TODO Auto-generated method stub
	return null;
    }

}
