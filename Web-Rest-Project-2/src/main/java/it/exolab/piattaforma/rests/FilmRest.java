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
import it.exolab.piattaforma.ejb_interfaces.FilmInterface;
import it.exolab.piattaforma.models.Film;

@Path("/filmRest")
public class FilmRest
{

    private FilmInterface filmInterface;

    @POST
    @Path("/insertFilm")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response insert(Film film)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - insertFilm - input -> " + film);
	try
	{
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    film	  = filmInterface.insert(film);
	    return Response.status(201).entity(film).build();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    @PUT
    @Path("/updateFilm")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response update(Film film)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - updateFilm - input -> " + film);
	try
	{
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    film	  = filmInterface.update(film);
	    return Response.status(200).entity(film).build();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    @DELETE
    @Path("/deleteFilm")
    @Produces({ "application/json" })
    public Response delete(Film film)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - deleteFilm - input -> " + film);
	try
	{
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    filmInterface.delete(film);
	    return Response.status(204).build();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    @GET
    @Path("/getFilm/{idFilm}")
    @Produces({ "application/json" })
    public Response findPathParam(@PathParam("idFilm") Integer idFilm)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - getFilm - input -> " + idFilm);
	try
	{
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    Film film = filmInterface.findById(idFilm);
	    return Response.status(200).entity(film).build();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    @GET
    @Path("/getListaFilm")
    @Produces({ "application/json" })
    public Response findAll()
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - getListaFilm");
	try
	{
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    List<Film> listaFilm = filmInterface.findAll();
	    return Response.status(200).entity(listaFilm).build();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }
    
    @GET
    @Path("/getListaFilmByIdCategoria/{idCategoria}")
    @Produces({ "application/json" })
    public Response findFilmByIdCategoria(@PathParam("idCategoria") Integer idCategoria) {
	try
	{
	    System.out.println("sei dentro " + this.getClass() + " nel servizio - findFilmByIdCategoria - input -> " + idCategoria);
	    filmInterface = new EJBFactory<FilmInterface>(FilmInterface.class).getEJB();
	    List<Film> listaFilm = filmInterface.findByCategory(idCategoria);
	    return Response.status(200).entity(listaFilm).build();
	} catch (UnhandledException e)
	{
	    System.out.println("Qualcosa è andato storto col Json");
	} catch (Exception e)
	{
	    e.printStackTrace();
	    System.out.println("Qualcosa è andato storto");
	}
	return Response.status(500).build();

    }
}