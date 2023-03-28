
package it.exolab.piattaforma.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.piattaforma.ejb_interfaces.CategoriaInterface;
import it.exolab.piattaforma.ejb_interfaces.FilmCategoriaInterface;
import it.exolab.piattaforma.ejb_interfaces.FilmInterface;
import it.exolab.piattaforma.ejb_interfaces.RegistaInterface;
import it.exolab.piattaforma.ejb_interfaces.RuoloInterface;
import it.exolab.piattaforma.ejb_interfaces.UserInterface;
import it.exolab.piattaforma.models.Categoria;
import it.exolab.piattaforma.models.Film;
import it.exolab.piattaforma.models.Regista;
import it.exolab.piattaforma.models.Ruolo;
import it.exolab.piattaforma.models.User;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    @EJB
    UserInterface	      userInterface;

    @EJB
    CategoriaInterface	      categoriaInterface;

    @EJB
    FilmCategoriaInterface    filmCategoriaInterface;

    @EJB
    FilmInterface	      filmInterface;

    @EJB
    RegistaInterface	      registaInterface;

    @EJB
    RuoloInterface	      ruoloInterface;

    public MainServlet()
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

	System.out.println("Nella servlet - GET");

	try
	{
	    if (null != request.getParameter("toGetAll"))
	    {
		toGetAll(request);
		request.getRequestDispatcher("printAllFilms.jsp").include(request, response);
	    }

	    if (null != request.getParameter("toGetAllRegistiAndCategorie"))
	    {
		toGetAllRegistiAndCategorie(request);
		request.getRequestDispatcher("inserisciFilm.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toGetAllUser"))
	    {
		toGetAllUser(request);
		request.getRequestDispatcher("printAllUser.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toGetAllUserNotAdmin"))
	    {
		toGetAllUser(request);
		request.getRequestDispatcher("nominaAdmin.jsp").include(request, response);
	    }

	    if (null != request.getParameter("toGetAllCategories"))
	    {
		toGetAllCategory(request);
		request.getRequestDispatcher("selezionaCategoria.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toGetFilmByCategory"))
	    {
		toGetFilmByCategory(request);
		request.getRequestDispatcher("printAllFilms.jsp").include(request, response);
	    }
	} catch (Exception e)
	{
	    e.printStackTrace();
	    request.getRequestDispatcher("error.jsp").include(request, response);
	}
    }

    private void toGetAllRegistiAndCategorie(HttpServletRequest request)
    {
	List<Categoria>	listaCategoria = categoriaInterface.findAll();
	List<Regista>	listaRegista   = registaInterface.findAll();

	request.getSession().setAttribute("listaCategoria", listaCategoria);
	request.getSession().setAttribute("listaRegista", listaRegista);

    }

    private void toGetFilmByCategory(HttpServletRequest request)
    {
	System.out.println("Nell toGetFilmByCategory");

	List<Film> listaFilm = filmInterface
		.findByCategory(Integer.parseInt(request.getParameter("toGetFilmByCategory")));

	request.getSession().setAttribute("listaFilm", listaFilm);
    }

    private void toGetAllCategory(HttpServletRequest request)
    {
	System.out.println("Nell toGetAllCategory");

	List<Categoria> listaCategorie = categoriaInterface.findAll();
	request.getSession().setAttribute("listaCategorie", listaCategorie);

    }

    private void toGetAllUser(HttpServletRequest request)
    {
	System.out.println("Nell toGetAllUser");

	List<User> listaUser = userInterface.findAll();
	request.getSession().setAttribute("listaUser", listaUser);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

	System.out.println("Nella servlet - POST");

	try
	{
	    if (null != request.getParameter("toLogin"))
	    {
		toLogin(request);
		request.getRequestDispatcher("recap.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toInsert"))
	    {
		toInsert(request);
		request.getRequestDispatcher("recap.jsp").include(request, response);
	    } else if (null != request.getParameter("toUpdate"))
	    {
		toUpdate(request);
		request.getRequestDispatcher("manage.jsp").include(request, response);
	    } else if (null != request.getParameter("toDelete"))
	    {
		toDelete(request);
		request.getRequestDispatcher("home.jsp").include(request, response);
	    }
	    if (null != request.getParameter("idToAdmin"))
	    {
		toUpdateUserToAdmin(request);
		request.getRequestDispatcher("manageAdmin.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toInsertFilm"))
	    {
		toInsertFilm(request);
		request.getRequestDispatcher("manageAdmin.jsp").include(request, response);
	    }
	    if (null != request.getParameter("toInsertRegista"))
	    {
		toInsertRegista(request);
		request.getRequestDispatcher("manageAdmin.jsp").include(request, response);
	    }

	} catch (Exception e)
	{
	    e.printStackTrace();
	    request.getRequestDispatcher("error.jsp").include(request, response);
	}
    }

    private void toInsertRegista(HttpServletRequest request)
    {
	if (request.getParameter("nomeRegista").length() > 0 && request.getParameter("cognomeRegista").length() > 0)
	{
	    Regista regista = new Regista();

	    regista.setNome(request.getParameter("nomeRegista"));

	    regista.setCognome(request.getParameter("cognomeRegista"));

	    registaInterface.insert(regista);
	}

    }

    private void toInsertFilm(HttpServletRequest request)
    {
	if (!request.getParameter("registaFilm").equals(" ") && request.getParameter("titoloFilm").length() > 0
		&& request.getParameterValues("categorieSelezionate") != null)
	{
	    Film film = new Film();

	    film.setTitolo(request.getParameter("titoloFilm"));

	    Regista r = new Regista();

	    r.setIdRegista(Integer.parseInt(request.getParameter("registaFilm")));

	    film.setRegista(r);

	    film.setIdRegista(Integer.parseInt(request.getParameter("registaFilm")));

	    List<Categoria> categorie		 = new ArrayList<>();

	    String[]	    categorieSelezionate = request.getParameterValues("categorieSelezionate");

	    for (String s : categorieSelezionate)
	    {
		Categoria c = new Categoria();

		c.setIdCategoria(Integer.parseInt(s));

		categorie.add(c);
	    }

	    film.setListaCategorie(categorie);
	    film.setRegista(r);

	    System.out.println("In toInsertFilm nella Servlet, film proveniente da inserimento utente " + film);
	    filmInterface.insert(film);
	}
    }

    private void toUpdateUserToAdmin(HttpServletRequest request)
    {
	System.out.println("Nell toUpdateUserToAdmin");

	User usr = new User();

	usr.setIdUser(Integer.valueOf(request.getParameter("idToAdmin")));
	usr.setNome(request.getParameter("nomeToAdmin"));
	usr.setCognome(request.getParameter("cognomeToAdmin"));
	usr.setEmail(request.getParameter("emailToAdmin"));
	usr.setPassword(request.getParameter("passwordToAdmin"));

	Ruolo r = new Ruolo();
	r.setIdRuolo(2);

	usr.setIdRuolo(2);

	usr.setRuolo(r);

	usr = userInterface.update(usr);
    }

    private void toInsert(HttpServletRequest request)
    {

	System.out.println("Nell toInsert");

	User usr = new User();

	usr.setNome(request.getParameter("nome"));
	usr.setCognome(request.getParameter("cognome"));
	usr.setEmail(request.getParameter("email"));
	usr.setPassword(request.getParameter("password"));

	Ruolo r = new Ruolo();
	r.setIdRuolo(1);

	usr.setRuolo(r);

	usr.setIdRuolo(1);

	usr = userInterface.insert(usr);
	request.getSession().setAttribute("usr", usr);

    }

    private void toLogin(HttpServletRequest request)
    {

	System.out.println("Nell toLogin");

	User usr = new User();

	usr.setEmail(request.getParameter("email"));
	usr.setPassword(request.getParameter("password"));

	usr = userInterface.findByEmailPassword(usr);
	request.getSession().setAttribute("usr", usr);

	System.out.println(usr);
    }

    private void toUpdate(HttpServletRequest request)
    {
	
	// prendere un parametro aggiuntivo con set ruolo dimanico per usarlo nel update utente, update admin e togliere il to update

	System.out.println("Nell toUpdate");

	User usr = new User();

	usr.setIdUser(Integer.valueOf(request.getParameter("idUser")));
	usr.setNome(request.getParameter("nome"));
	usr.setCognome(request.getParameter("cognome"));
	usr.setEmail(request.getParameter("email"));
	usr.setPassword(request.getParameter("password"));

	Ruolo r = new Ruolo();
	r.setIdRuolo(1);

	usr.setRuolo(r);

	usr.setIdRuolo(1);

	usr = userInterface.update(usr);
	request.getSession().setAttribute("usr", usr);
    }

    private void toGetAll(HttpServletRequest request)
    {
	System.out.println("Nell toGetAll");

	List<Film> listaFilm = filmInterface.findAll();
	request.getSession().setAttribute("listaFilm", listaFilm);
    }

    private void toDelete(HttpServletRequest request)
    {
	System.out.println("Nell toDelete");

	User usr = new User();

	usr.setIdUser(Integer.valueOf(request.getParameter("idUser")));

	userInterface.delete(usr);

	// svuoto l'utente in sessione
	request.getSession().setAttribute("usr", null);
    }
}