package it.exolab.piattaforma.crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.exolab.piattaforma.models.User;

public class UserCrud extends Crud<User>
{

    @Override
    public User insert(EntityManager entityManager, User user)
    {
	if (!entityManager.contains(user))
	{
	    user = entityManager.merge(user);
	}
	entityManager.persist(user);

	return user;

    }

    @Override
    public User update(EntityManager entityManager, User user)
    {
	entityManager.merge(user);

	return user;

    }

    @Override
    public void delete(EntityManager entityManager, User user)
    {
	if (entityManager.contains(user))
	{
	    entityManager.remove(user);
	} else
	{
	    entityManager.remove(entityManager.merge(user));
	}
    }

    @Override
    public User findById(EntityManager entityManager, Integer idUser)
    {
	User user = new User();
	user = entityManager.find(User.class, idUser);
	return user;

    }

    @Override
    public List<User> findAll(EntityManager entityManager)
    {
	TypedQuery<User> query	     = entityManager.createQuery("SELECT u FROM User u", User.class);
	List<User>	 listaUtenti = query.getResultList();

	return listaUtenti;

    }

    public User findByEmailPassword(EntityManager entityManager, User usr)
    {
	User  usrTrovato;
	Query query = entityManager
		.createQuery("Select u FROM User u WHERE u.email = :mail And u.password = :password");
	query.setParameter("mail", usr.getEmail());
	query.setParameter("password", usr.getPassword());
	usrTrovato = (User) query.getSingleResult();
	return usrTrovato;
    }

    public void findByEmail(EntityManager entityManager, User user)
    {
	Query query = entityManager
		.createQuery("Select u FROM User u WHERE u.email = :mail");
	query.setParameter("mail", user.getEmail());
	query.getSingleResult();
    }

}
