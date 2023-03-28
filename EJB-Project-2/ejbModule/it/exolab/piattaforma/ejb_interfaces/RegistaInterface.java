package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.Regista;



@Local
public interface RegistaInterface
{
    Regista insert(Regista regista);

    Regista update(Regista regista);

    Regista findById(Integer idRegista);

    List<Regista> findAll();

    void delete(Regista regista);
}
