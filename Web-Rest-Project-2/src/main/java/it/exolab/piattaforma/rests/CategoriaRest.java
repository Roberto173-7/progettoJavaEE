package it.exolab.piattaforma.rests;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import it.exolab.piattaforma.conf.EJBFactory;
import it.exolab.piattaforma.ejb_interfaces.CategoriaInterface;
import it.exolab.piattaforma.models.Categoria;

@Path("/categoriaRest")
public class CategoriaRest
{

    private CategoriaInterface categoriaInterface;

 // localhost:8080/Web-Rest-Project-2/rest/categoriaRest/insertCategoria
    @POST
    @Path("/insertCategoria")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response insert(Categoria categoria)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - insertCategoria - input -> " + categoria);

	try
	{
	    categoriaInterface = new EJBFactory<CategoriaInterface>(CategoriaInterface.class).getEJB();

	    categoria	       = categoriaInterface.insert(categoria);

	    return Response.status(201).entity(categoria).build();

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    // localhost:8080/Web-Rest-Project-2/rest/categoriaRest/updateCategoria
    // json inviato con oggetto da aggiornare, ricevo oggetto aggiornato in json
    @PUT
    @Path("/updateCategoria")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    public Response update(Categoria categoria)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - updateCategoria - input -> " + categoria);

	try
	{
	    categoriaInterface = new EJBFactory<CategoriaInterface>(CategoriaInterface.class).getEJB();

	    categoria	       = categoriaInterface.update(categoria);

	    return Response.status(200).entity(categoria).build();

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    // localhost:8080/Web-Rest-Project-2/rest/categoriaRest/deleteCategoria
    // nel body va il json con l'oggetto da cancellare, basta id se cancellazione sotto si basa su questo
    @DELETE
    @Path("/deleteCategoria")
    @Produces({ "application/json" })
    public Response delete(Categoria categoria)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - deleteCategoria - input -> " + categoria);
	
	try
	{
	    categoriaInterface = new EJBFactory<CategoriaInterface>(CategoriaInterface.class).getEJB();
	    
	    categoriaInterface.delete(categoria);
	    
	    return Response.status(204).build();
	    
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    // Se volevo usare PathParam -> localhost:8080/Web-Rest-Project-2/rest/categoriaRest/getCategoria/19
    
    // localhost:8080/Web-Rest-Project-2/rest/categoriaRest/getCategoria/?idCategoria=19
    @GET
    @Path("/getCategoria")
    @Produces({ "application/json" })
    public Response findPathParam(@QueryParam("idCategoria") Integer idCategoria)
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - getCategoria - input -> " + idCategoria);
	try
	{
	    categoriaInterface = new EJBFactory<CategoriaInterface>(CategoriaInterface.class).getEJB();
	    
	    Categoria categoria = categoriaInterface.findById(idCategoria);
	    
	    return Response.status(200).entity(categoria).build();
	    
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }

    // localhost:8080/Web-Rest-Project-2/rest/categoriaRest/getListaCategoria
    @GET
    @Path("/getListaCategoria")
    @Produces({ "application/json" })
    public Response findAll()
    {

	System.out.println("sei dentro " + this.getClass() + " nel servizio - getListaCategoria");
	try
	{
	    categoriaInterface = new EJBFactory<CategoriaInterface>(CategoriaInterface.class).getEJB();
	    
	    List<Categoria> listaCategoria = categoriaInterface.findAll();
	    
	    return Response.status(200).entity(listaCategoria).build();
	    
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return Response.status(500).build();
    }
}