package it.exolab.piattaforma.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film implements Serializable
{
    private static final long serialVersionUID = 5266154292563225772L;
    
    // solo wrapper
    // vedere fetch eager e lazy
    // lista di liste di liste per estrazione stackoverflow
    // manytomany, attributo cascade, join table bridge e le join column

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_F")
    private Integer	    idFilm;
    
    @Column(name = "TITOLO")
    private String	    titolo;
    
    @Column(name = "ID_R")
    private Integer idRegista;
    
    @ManyToOne
    @JoinColumn(name="ID_R", nullable=false, insertable=false, updatable=false)
    // DA VEDERE @JsonbTransient
    private Regista regista;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade ={/*CascadeType.PERSIST, CascadeType.MERGE,*/ CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name="film_categoria",  joinColumns= @JoinColumn(name="ID_F", referencedColumnName="ID_F"),
        			inverseJoinColumns= @JoinColumn(name="ID_C", referencedColumnName="ID_C"))
    private List<Categoria> listaCategorie;

    public Integer getIdFilm()
    {
	return idFilm;
    }

    public void setIdFilm(Integer idFilm)
    {
	this.idFilm = idFilm;
    }

    public String getTitolo()
    {
	return titolo;
    }

    public void setTitolo(String titolo)
    {
	this.titolo = titolo;
    }

    public Regista getRegista()
    {
	return regista;
    }

    public void setRegista(Regista regista)
    {
	this.regista = regista;
    }

    public List<Categoria> getListaCategorie()
    {
	return listaCategorie;
    }
    
    public Integer getIdRegista()
    {
	return idRegista;
    }
    
   
    
    public void setIdRegista(Integer idRegista)
    {
	this.idRegista = idRegista;
    }
    

    public void setListaCategorie(List<Categoria> listaCategorie)
    {
	this.listaCategorie = listaCategorie;
    }

    @Override
    public int hashCode()
    {
	return Objects.hash(idFilm);
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
	Film other = (Film) obj;
	return Objects.equals(idFilm, other.idFilm);
    }

    @Override
    public String toString()
    {
	return "Film [idFilm=" + idFilm + ", titolo=" + titolo + ", regista=" + regista + ", listaCategorie="
		+ Categoria.toStringWithoutFilm(listaCategorie)   + "]";
    }

}
