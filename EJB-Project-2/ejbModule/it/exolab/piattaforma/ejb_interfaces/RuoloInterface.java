package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.Ruolo;


@Local
public interface RuoloInterface
{
    Ruolo insert(Ruolo ruolo);

    Ruolo update(Ruolo ruolo);

    Ruolo findById(Integer idRuolo);

    List<Ruolo> findAll();

    void delete(Ruolo ruolo);
}
