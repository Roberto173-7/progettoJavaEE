package it.exolab.piattaforma.conf;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.exolab.piattaforma.rests.CategoriaRest;
import it.exolab.piattaforma.rests.FilmRest;
import it.exolab.piattaforma.rests.RegistaRest;
import it.exolab.piattaforma.rests.RuoloRest;
import it.exolab.piattaforma.rests.UserRest;


@ApplicationPath("/rest")
public class ControllerRestApplication extends Application
{

    @Override
    public Set<Class<?>> getClasses()
    {
	Set<Class<?>> set = new HashSet<>();
	set.add(FilmRest.class);
	set.add(CategoriaRest.class);
	set.add(RegistaRest.class);
	set.add(RuoloRest.class);
	set.add(UserRest.class);
	return set;
    }

}
