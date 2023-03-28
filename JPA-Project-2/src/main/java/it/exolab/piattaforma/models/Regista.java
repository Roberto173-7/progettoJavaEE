package it.exolab.piattaforma.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regista")
public class Regista implements Serializable
{
    private static final long serialVersionUID = -8145029746974635807L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_R")
    private Integer    idRegista;
    
    @Column(name = "NOME")
    private String     nome;
    
    @Column(name = "COGNOME")
    private String     cognome;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="regista")
    @JsonbTransient
    private List<Film> listaFilm;

    public Integer getIdRegista()
    {
	return idRegista;
    }

    public void setIdRegista(Integer idRegista)
    {
	this.idRegista = idRegista;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public String getCognome()
    {
	return cognome;
    }

    public void setCognome(String cognome)
    {
	this.cognome = cognome;
    }

    public List<Film> getListaFilm()
    {
	return listaFilm;
    }

    public void setListaFilm(List<Film> listaFilm)
    {
	this.listaFilm = listaFilm;
    }

    @Override
    public int hashCode()
    {
	return Objects.hash(idRegista);
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
	Regista other = (Regista) obj;
	return Objects.equals(idRegista, other.idRegista);
    }

    @Override
    public String toString()
    {
	return "Regista [idRegista=" + idRegista + ", nome=" + nome + ", cognome=" + cognome + ", listaFilm="
		+ listaFilm + "]";
    }

}
