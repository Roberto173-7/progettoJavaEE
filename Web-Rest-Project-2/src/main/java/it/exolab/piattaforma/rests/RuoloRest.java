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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import it.exolab.piattaforma.conf.EJBFactory;
import it.exolab.piattaforma.ejb_interfaces.RuoloInterface;
import it.exolab.piattaforma.models.Ruolo;

@Path("/ruoloRest")
public class RuoloRest
{
    /*
	 * se questa classe fosse stata un EJB avrei potuto usare @EJB
	 * ma RESTEASY non conosce le EJB, qundi sono costretto ad usare la lookUp,
	 * @EJB si usa solo tra ejb, se avessi usato i CDI avrei potuto usare @Injection
	 * p.s. con @Stateless o @SessionScoped avrei convertito la classe rest in un EJB nel primo caso 
	 * o avrei aggiunto un context nel secondo caso, entrambi mi avrebbero permesso di usare 
	 * l'annotation @EJB, ma sarebbe stata una procedura scorretta
	 */
	private RuoloInterface ruoloInterface;
	
	@POST
	@Path("/insertRuolo")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Ruolo ruolo) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertRuolo - input -> " + ruolo);
		try {
			EJBFactory<RuoloInterface> ejbFacroty = new EJBFactory<RuoloInterface>(RuoloInterface.class);
			ruoloInterface = ejbFacroty.getEJB();
			ruolo = ruoloInterface.insert(ruolo);
			return Response.status(201).entity(ruolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/insertAutoRuolo")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insertAuto(Ruolo ruolo) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertAutoRuolo - input -> " + ruolo);
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();;
			ruolo = ruoloInterface.insert(ruolo);
			return Response.status(201).entity(ruolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@PUT
	@Path("/updateRuolo")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Ruolo ruolo) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - updateRuolo - input -> " + ruolo);
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			ruolo = ruoloInterface.update(ruolo);
			return Response.status(200).entity(ruolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@DELETE
	@Path("/deleteRuolo")
	@Produces({ "application/json" })
	public Response delete(Ruolo ruolo) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - deleteRuolo - input -> " + ruolo);
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			ruoloInterface.delete(ruolo);
			return Response.status(202).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	/*
	 * utilizzando il pathParam, il parametro viene inserito direttamente nell url 
	 * es: localhost:8080/NomeProgetto/ApplicationPath/ClassPath/MethodPath/1 <-- parametro
	 */
	@GET
	@Path("/getRuolo/{idRuolo}")
	@Produces({ "application/json" })
	public Response findPathParam(@PathParam("idRuolo") Integer idRuolo) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - findPathParam - input -> " + idRuolo);
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			Ruolo ruolo = ruoloInterface.findById(idRuolo);
			return  Response.status(200).entity(ruolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  Response.status(500).build();
	}

	/*
	 * utilizzando il queryParam, il parametro viene inserito direttamente nell'url ma con la sintassi del queryString
	 * es: localhost:8080/NomeProgetto/ApplicationPath/ClassPath/MethodPath?idRuolo=1 <-- key e value del parametro
	 */
	@GET
	@Path("/getRuolo")
	@Produces({ "application/json" })
	public Response findQueryParam(@QueryParam("idRuolo") Integer idRuolo) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - findQueryParam - input -> " + idRuolo);
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			Ruolo ruolo = ruoloInterface.findById(idRuolo);
			return  Response.status(200).entity(ruolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	@GET
	@Path("/getListaRuolo")
	@Produces({ "application/json" })
	public Response findAll() {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - getListaRuolo");
		try {
			ruoloInterface = new EJBFactory<RuoloInterface>(RuoloInterface.class).getEJB();
			List<Ruolo> listaRuolo = ruoloInterface.findAll();
			return Response.status(200).entity(listaRuolo).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}
