
package it.exolab.piattaforma.conf;

import javax.naming.InitialContext;

public class EJBFactory<T>
{
    // percorso e nome del progetto con	le EJB
    
    private final static String	PREFIX = "java:global/EAR-Project-2/EJB-Project-2/"; 

    private Class<T>		interfaceClass;

    // Costruttore parametrico
    public EJBFactory(Class<T> interfaceClass)
    {
	this.interfaceClass = interfaceClass;
    }

    @SuppressWarnings("unchecked")
    public T getEJB() throws Exception
    {
	// punto iniziale per la risoluzione del naming
	InitialContext context = new InitialContext(); 
	
	// indirizzo ejb all'interno del container
	return (T) context.lookup(PREFIX + interfaceClass.getSimpleName() + "!" + interfaceClass.getName());
    }
}