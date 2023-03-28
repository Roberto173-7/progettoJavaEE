package it.exolab.piattaforma.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable
{
    private static final long serialVersionUID = -4586145796639820153L;
    
    @Id
 // is to configure the way of increment of the specified column(field). In questo caso auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "ID_C")
    private Integer    idCategoria;
    
    @Column(name = "NOME")
    private String     nome;
    
    @Column(name = "PERC_GRADIMENTO")
    private Integer    percentualeGradimento;
    
//  se non voglio settare  @ManyToMany(fetch=FetchType.EAGER, cascade ={/*CascadeType.PERSIST,*/ CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinTable(name="film_categoria",  joinColumns= @JoinColumn(name="ID_C", referencedColumnName="ID_C"),
//        			inverseJoinColumns= @JoinColumn(name="ID_F", referencedColumnName="ID_F"))
    @ManyToMany(mappedBy = "listaCategorie")
    @JsonbTransient
    private List<Film> listaFilm;

    public Integer getIdCategoria()
    {
	return idCategoria;
    }

    public void setIdCategoria(Integer idC)
    {
	this.idCategoria = idC;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public Integer getPercentualeGradimento()
    {
	return percentualeGradimento;
    }

    public void setPercentualeGradimento(Integer percentualeGradimento)
    {
	this.percentualeGradimento = percentualeGradimento;
    }

    public List<Film> getListaFilm()
    {
	return listaFilm;
    }

    public void setListaFilm(List<Film> listaFilm)
    {
	this.listaFilm = listaFilm;
    }
    
    
    
    /*
	 * hashCode ed equals sono modificati per la verifica dell'entity nel container 
    */

    @Override
    public int hashCode()
    {
	return Objects.hash(idCategoria);
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
	Categoria other = (Categoria) obj;
	return Objects.equals(idCategoria, other.idCategoria);
    }

    @Override
    public String toString()
    {
	return "Categoria [idCategoria=" + idCategoria + ", nome=" + nome + ", percentualeGradimento="
		+ percentualeGradimento + ", listaFilm=" + listaFilm + "]";
    }

    public static String toStringWithoutFilm(List<Categoria> listaCategorie)
    {
	String s = "[";

	if (listaCategorie != null)
	{
	    for (Categoria c : listaCategorie)
	    {
		s += "[Categoria [idCategoria=" + c.getIdCategoria() + ", nome=" + c.getNome()
			+ ", percentualeGradimento=" + c.getPercentualeGradimento() + "]";
	    }
	}

	return s;
    }

}
