package it.exolab.piattaforma.ejb_interfaces;

import java.util.List;

import javax.ejb.Local;

import it.exolab.piattaforma.models.User;


@Local
public interface UserInterface
{
    User insert(User user);

    User update(User user);

    User findById(Integer idUser);

    List<User> findAll();
     
    void delete(User usr);
    
    User findByEmailPassword(User usr);
}
