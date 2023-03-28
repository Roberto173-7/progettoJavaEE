package it.exolab.piattaforma.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.exolab.piattaforma.models.User;


/**
 * Servlet Filter implementation class MainFilter
 */
@WebFilter("/MainFilter")
public class MainFilter implements Filter
{

    /**
     * Default constructor.
     */
    public MainFilter()
    {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {
	// TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException
    {
	HttpServletRequest  req	= (HttpServletRequest) request;
	HttpServletResponse res	= (HttpServletResponse) response;

	String		    uri	= req.getRequestURI();
	User		    usr	= ((User) req.getSession().getAttribute("usr"));

	if ((usr == null || usr.getPassword()== null) && !(uri.contains("home.jsp") || uri.contains("login.jsp")|| uri.contains("register.jsp")))
	{
	    res.sendRedirect("home.jsp");
	    return;
	}
	
	if ((uri.contains("manage.jsp") && (usr.getRuolo().getIdRuolo() == 2)))
	{
	    res.sendRedirect("manageAdmin.jsp");
	    return;
	}
	
	if (uri.contains("manageAdmin.jsp") && (usr.getRuolo().getIdRuolo() == 1))
	{
	    res.sendRedirect("manage.jsp");
	    return;
	}
	
	chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException
    {
	// TODO Auto-generated method stub
    }

}
