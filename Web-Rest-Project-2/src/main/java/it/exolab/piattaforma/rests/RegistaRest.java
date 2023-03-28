package it.exolab.piattaforma.rests;


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
import it.exolab.piattaforma.ejb_interfaces.RegistaInterface;
import it.exolab.piattaforma.models.Regista;

import java.util.List;


@Path("/registaRest")
public class RegistaRest {

	/*
	 * se questa classe fosse stata un EJB avrei potuto usare @EJB
	 * ma RESTEASY non conosce le EJB, qundi sono costretto ad usare la lookUp,
	 * @EJB si usa solo tra ejb, se avessi usato i CDI avrei potuto usare @Injection
	 * p.s. con @Stateless o @SessionScoped avrei convertito la classe rest in un EJB nel primo caso 
	 * o avrei aggiunto un context nel secondo caso, entrambi mi avrebbero permesso di usare 
	 * l'annotation @EJB, ma sarebbe stata una procedura scorretta
	 */
	private RegistaInterface registaInterface;
	
	@POST
	@Path("/insertRegista")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insert(Regista regista) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertRegista - input -> " + regista);
		try {
			EJBFactory<RegistaInterface> ejbFacroty = new EJBFactory<RegistaInterface>(RegistaInterface.class);
			registaInterface = ejbFacroty.getEJB();
			regista = registaInterface.insert(regista);
			return Response.status(201).entity(regista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@POST
	@Path("/insertAutoRegista")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response insertAuto(Regista regista) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - insertAutoRegista - input -> " + regista);
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();;
			regista = registaInterface.insert(regista);
			return Response.status(201).entity(regista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@PUT
	@Path("/updateRegista")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response update(Regista regista) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - updateRegista - input -> " + regista);
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();
			regista = registaInterface.update(regista);
			return Response.status(200).entity(regista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@DELETE
	@Path("/deleteRegista")
	@Produces({ "application/json" })
	public Response delete(Regista regista) {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - deleteRegista - input -> " + regista);
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();
			registaInterface.delete(regista);
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
	@Path("/getRegista/{idRegista}")
	@Produces({ "application/json" })
	public Response findPathParam(@PathParam("idRegista") Integer idRegista) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - findPathParam - input -> " + idRegista);
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();
			Regista regista = registaInterface.findById(idRegista);
			return  Response.status(200).entity(regista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  Response.status(500).build();
	}

	/*
	 * utilizzando il queryParam, il parametro viene inserito direttamente nell'url ma con la sintassi del queryString
	 * es: localhost:8080/NomeProgetto/ApplicationPath/ClassPath/MethodPath?idRegista=1 <-- key e value del parametro
	 */
	@GET
	@Path("/getRegista")
	@Produces({ "application/json" })
	public Response findQueryParam(@QueryParam("idRegista") Integer idRegista) {

		System.out.println("sei dentro " + this.getClass() + " nel servizio - findQueryParam - input -> " + idRegista);
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();
			Regista regista = registaInterface.findById(idRegista);
			return  Response.status(200).entity(regista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	
	@GET
	@Path("/getListaRegista")
	@Produces({ "application/json" })
	public Response findAll() {
		
		System.out.println("sei dentro " + this.getClass() + " nel servizio - getListaRegista");
		try {
			registaInterface = new EJBFactory<RegistaInterface>(RegistaInterface.class).getEJB();
			List<Regista> listaRegista = registaInterface.findAll();
			return Response.status(200).entity(listaRegista).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}