package it.exolab.piattaforma.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film_categoria")
public class FilmCategoria implements Serializable
{
    private static final long serialVersionUID = -2796129731470101989L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_F_C")
    private Integer idFilmCategoria;
    
    @Column(name = "ID_F")
    private Integer idFilm;
    
    @Column(name = "ID_C")
    private Integer idCategoria;
    
    @ManyToOne
    @JoinColumn(name="ID_F", nullable=false, insertable=false, updatable=false)
    private Film film;
	
    @ManyToOne
    @JoinColumn(name="ID_C", nullable=false, insertable=false, updatable=false)
    private Categoria categoria;

    public Integer getIdFilmCategoria()
    {
	return idFilmCategoria;
    }

    public void setIdFilmCategoria(Integer idFilmCategoria)
    {
	this.idFilmCategoria = idFilmCategoria;
    }

    public Integer getIdFilm()
    {
	return idFilm;
    }

    public void setIdFilm(Integer idFilm)
    {
	this.idFilm = idFilm;
    }

    public Integer getIdCategoria()
    {
	return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria)
    {
	this.idCategoria = idCategoria;
    }
    
    public Film getFilm()
    {
	return film;
    }
    
    public Categoria getCategoria()
    {
	return categoria;
    }
     public void setFilm(Film film)
    {
	this.film = film;
    }
     
     public void setCategoria(Categoria categoria)
    {
	this.categoria = categoria;
    }
     

    @Override
    public int hashCode()
    {
	return Objects.hash(idFilmCategoria);
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	FilmCategoria other = (FilmCategoria) obj;
	return Objects.equals(idFilmCategoria, other.idFilmCategoria);
    }

    @Override
    public String toString()
    {
	return "FilmCategoria [idFilmCategoria=" + idFilmCategoria + ", idFilm=" + idFilm + ", idCategoria="
		+ idCategoria + "]";
    }

}
