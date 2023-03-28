package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.Film;


@Local
public interface FilmInterface
{
    Film insert(Film film);

    Film update(Film film);

    Film findById(Integer idFilm);

    List<Film> findAll();

    void delete(Film film);
    
    List<Film> findByCategory(Integer idCategoria);

}
