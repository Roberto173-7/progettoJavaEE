package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.FilmCategoria;


@Local
public interface FilmCategoriaInterface
{
    FilmCategoria insert(FilmCategoria filmCategoria);

    FilmCategoria update(FilmCategoria filmCategoria);

    FilmCategoria findById(Integer idFilmCategoria);

    List<FilmCategoria> findAll();

    void delete(FilmCategoria filmCategoria);
}
