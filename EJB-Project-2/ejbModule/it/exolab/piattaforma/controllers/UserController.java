package it.exolab.piattaforma.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import it.exolab.piattaforma.crud.UserCrud;
import it.exolab.piattaforma.ejb_interfaces.UserInterface;
import it.exolab.piattaforma.models.User;


@Stateless(name="UserInterface")
@LocalBean
public class UserController extends Controller<User> implements UserInterface
{

    @Override
    @Transactional
    public User insert(User user)
    {
	try
	{
	    UserCrud   userCrud	= new UserCrud();
	    
	    try
	    {
		userCrud.findByEmail(entityManager, user);
		
		user = new User();
		user.setIdUser(null);
	    } 
	    catch(NoResultException nre)
	    {
		user = userCrud.insert(entityManager, user);
		
	    }
	    catch (Exception e)
	    {
		e.printStackTrace();
	    }
	    
	    return user;
	} 
	catch (Exception e)
	{
	    e.printStackTrace();
	} 
	return null;
    }

    @Override
    @Transactional
    public User update(User user)
    {
	try
	{
	    UserCrud   userCrud	= new UserCrud();
	    
	    userCrud.update(entityManager, user);
	    
	    return user;
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    @Transactional
    public User findById(Integer idUser)
    {
	try
	{
	    UserCrud   userCrud	= new UserCrud();
	    User       user	= userCrud.findById(entityManager, idUser);
	    return user;
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 
	
	return null;
    }

    @Override
    @Transactional
    public List<User> findAll()
    {
	try
	{
	    UserCrud   userCrud	 = new UserCrud();
	    List<User> listaUser = userCrud.findAll(entityManager);
	    return listaUser;
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 
	
	return null;
    }

    @Override
    @Transactional
    public void delete(User user)
    {
	try
	{
	    UserCrud   userCrud	= new UserCrud();
	    userCrud.delete(entityManager, user);
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 

    }

    @Override
    @Transactional
    public User findByEmailPassword(User usr)
    {
	try
	{
	    UserCrud userCrud = new UserCrud();
	    usr = userCrud.findByEmailPassword(entityManager, usr);
	    return usr;
	} catch (Exception e)
	{
	    e.printStackTrace();
	} 
	
	return null;
    }

 

}
