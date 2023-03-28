package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.RuoloCrud;
import it.exolab.piattaforma.ejb_interfaces.RuoloInterface;
import it.exolab.piattaforma.models.Ruolo;


@Stateless(name="RuoloInterface")
@LocalBean
public class RuoloController extends Controller<Ruolo> implements RuoloInterface
{

    @Override
    @Transactional
    public Ruolo insert(Ruolo ruolo)
    {
	try
	{
	    RuoloCrud	ruoloCrud = new RuoloCrud();
	    ruolo = ruoloCrud.insert(entityManager, ruolo);

	    return ruolo;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    
    @Override
    @Transactional
    public void delete(Ruolo ruolo)
    {
	try
	{
	    RuoloCrud	ruoloCrud = new RuoloCrud();
	    ruoloCrud.delete(entityManager, ruolo);
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

    }


    @Override
    @Transactional
    public Ruolo update(Ruolo ruolo)
    {
	// TODO Auto-generated method stub
	return null;
    }


    @Override
    @Transactional
    public Ruolo findById(Integer idRuolo)
    {
	// TODO Auto-generated method stub
	return null;
    }


    @Override
    @Transactional
    public List<Ruolo> findAll()
    {
	// TODO Auto-generated method stub
	return null;
    }

}
