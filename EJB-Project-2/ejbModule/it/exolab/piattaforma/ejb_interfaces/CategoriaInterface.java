package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.Categoria;

@Local
public interface CategoriaInterface
{
    Categoria insert(Categoria categoria);

    Categoria update(Categoria categoria);

    Categoria findById(Integer idCategoria);

    List<Categoria> findAll();

    void delete(Categoria categoria);
}
