package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.RegistaCrud;
import it.exolab.piattaforma.ejb_interfaces.RegistaInterface;
import it.exolab.piattaforma.models.Regista;

@Stateless(name="RegistaInterface")
@LocalBean
public class RegistaController extends Controller<Regista> implements RegistaInterface
{

    @Override
    @Transactional
    public Regista insert(Regista regista)
    {
	try
	{
	    RegistaCrud registaCrud = new RegistaCrud();
	    regista = registaCrud.insert(entityManager, regista);
	    return regista;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public Regista update(Regista regista)
    {
	try
	{
	    RegistaCrud registaCrud = new RegistaCrud();
	    registaCrud.update(entityManager, regista);
	    return regista;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public Regista findById(Integer idRegista)
    {
	try
	{
	    RegistaCrud	registaCrud = new RegistaCrud();
	    Regista	regista	    = registaCrud.findById(entityManager, idRegista);
	    return regista;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public List<Regista> findAll()
    {
	try
	{
	    RegistaCrud	  registaCrud  = new RegistaCrud();
	    List<Regista> listaRegista = registaCrud.findAll(entityManager);
	    return listaRegista;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public void delete(Regista regista)
    {
	try
	{
	    RegistaCrud registaCrud = new RegistaCrud();
	    registaCrud.delete(entityManager, regista);
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

}
