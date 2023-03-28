package it.exolab.piattaforma.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable
{
    private static final long serialVersionUID = 1146906830349516270L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RUOLO")
    private Integer idRuolo;
    
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    
    public Integer getIdRuolo()
    {
        return idRuolo;
    }
    public void setIdRuolo(Integer idRuolo)
    {
        this.idRuolo = idRuolo;
    }
    public String getDescrizione()
    {
        return descrizione;
    }
    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }
    @Override
    public int hashCode()
    {
	return Objects.hash(idRuolo);
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
	Ruolo other = (Ruolo) obj;
	return Objects.equals(idRuolo, other.idRuolo);
    }
    @Override
    public String toString()
    {
	return "Ruolo [idRuolo=" + idRuolo + ", descrizione=" + descrizione + "]";
    }
    
    
}
