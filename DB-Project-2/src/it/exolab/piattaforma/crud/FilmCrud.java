package it.exolab.piattaforma.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.exolab.piattaforma.models.Film;


public class FilmCrud extends Crud<Film>
{

    @Override
    public Film insert(EntityManager entityManager, Film film)
    {
	// ha senso perché il contains si basa sugli id ma il merge unifica pure i senza id, unificando sul tipo dell oggetto
	if (!entityManager.contains(film))
	{
	    film = entityManager.merge(film);
	} else
	{
	    entityManager.persist(film);
	}
	return film;
    }

    @Override
    public Film update(EntityManager entityManager, Film film)
    {
	entityManager.merge(film);
	
	return film;
    }

    @Override
    public void delete(EntityManager entityManager, Film film)
    {
	if (entityManager.contains(film)) 
	{
	    entityManager.remove(film);
	}
	else
	{
	    entityManager.remove(entityManager.merge(film));
	}
    }

    @Override
    public Film findById(EntityManager entityManager, Integer idFilm)
    {
	Film film = new Film();
	film = entityManager.find(Film.class, idFilm);
	return film;	
    }

    @Override
    public List<Film> findAll(EntityManager entityManager)
    {
	TypedQuery<Film> lQuery = entityManager.createQuery("SELECT f FROM Film f", Film.class);
	List<Film> listaFilm = lQuery.getResultList();
	
	return listaFilm;

	
    }

    @SuppressWarnings("unchecked")
    public List<Film> findFilmByIdCategoria(EntityManager entityManager, Integer idCategoria)
    {
	List<Film> listaFilm = new ArrayList<Film>();
	
	Query query = entityManager.createNativeQuery("SELECT * FROM FILM LEFT JOIN FILM_CATEGORIA USING (ID_F) LEFT JOIN CATEGORIA USING (ID_C) WHERE ID_C = ?", Film.class);
	
	query.setParameter(1, idCategoria);
	
	listaFilm.addAll(query.getResultList());
	
	return listaFilm;
    }

}
