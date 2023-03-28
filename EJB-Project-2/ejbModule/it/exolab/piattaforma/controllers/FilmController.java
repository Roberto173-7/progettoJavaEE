package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.FilmCrud;
import it.exolab.piattaforma.ejb_interfaces.FilmInterface;
import it.exolab.piattaforma.models.Film;

@Stateless(name="FilmInterface")
@LocalBean
public class FilmController extends Controller<Film> implements FilmInterface
{

    @Override
    @Transactional
    public Film insert(Film film)
    {
	try
	{
	    FilmCrud filmCrud = new FilmCrud();

	    film = filmCrud.insert(entityManager, film);

	    return film;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public Film update(Film film)
    {
	try
	{
	    FilmCrud filmCrud = new FilmCrud();
	    filmCrud.update(entityManager, film);
	    return film;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public Film findById(Integer idFilm)
    {
	try
	{
	    FilmCrud filmCrud = new FilmCrud();
	    Film     film     = filmCrud.findById(entityManager, idFilm);
	    return film;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public List<Film> findAll()
    {
	try
	{
	    FilmCrud   filmCrud	 = new FilmCrud();
	    List<Film> listaFilm = filmCrud.findAll(entityManager);
	    return listaFilm;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public void delete(Film film)
    {
	try
	{
	    FilmCrud filmCrud = new FilmCrud();

	    filmCrud.delete(entityManager, film);

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    @Override
    @Transactional
    public List<Film> findByCategory(Integer idCategoria)
    {
	try
	{
	    FilmCrud   filmCrud	 = new FilmCrud();
	    List<Film> listaFilm = filmCrud.findFilmByIdCategoria(entityManager, idCategoria);
	    return listaFilm;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

}
