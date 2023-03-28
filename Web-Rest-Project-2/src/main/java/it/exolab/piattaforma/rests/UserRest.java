package it.exolab.piattaforma.rests;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.UnhandledException;

import it.exolab.piattaforma.conf.EJBFactory;
import it.exolab.piattaforma.ejb_interfaces.UserInterface;
import it.exolab.piattaforma.models.User;



@Path("/userRest")
public class UserRest {
	

	private UserInterface userInterface;

	
	@POST
	@Path("/getLogin")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response login(User user) {
		try {
			System.out.println("sei dentro " + this.getClass() + " nel servizio - login - input -> " + user);
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			User userTrovato = userInterface.findByEmailPassword(user);
			return  Response.status(200).entity(userTrovato).build();
		} catch (UnhandledException e) {
			System.out.println("Qualcosa è andato storto col Json");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Qualcosa è andato storto");
		}
		return Response.status(500).build();

	}
	
	
	@POST
	@Path("/insertUser")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(User user) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			user = userInterface.insert(user);
			return Response.status(201).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	
	@PUT
	@Path("/updateUser")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(User user) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - updateUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			user = userInterface.update(user);
			return Response.status(200).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	@DELETE
	@Path("/deleteUser")
	@Produces({ "application/json" })
	public Response delete(User user) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - deleteUser - input -> " + user);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			userInterface.delete(user);
			return Response.status(204).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}


	@GET
	@Path("/getUser/{idUser}")
	@Produces({ "application/json" })
	public Response findPathParam(@PathParam("idUser") Integer idUser) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - getUser - input -> " + idUser);
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			User user = userInterface.findById(idUser);
			return Response.status(200).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	@GET
	@Path("/getListaUser")
	@Produces({ "application/json" })
	public Response findAll() {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - getListaUser");
		try {
			userInterface = new EJBFactory<UserInterface>(UserInterface.class).getEJB();
			List<User> listaUser = userInterface.findAll();
			return Response.status(200).entity(listaUser).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}