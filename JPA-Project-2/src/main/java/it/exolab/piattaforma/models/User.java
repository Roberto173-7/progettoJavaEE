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
@Table(name = "user")
public class User implements Serializable
{
    private static final long serialVersionUID = -2016363389930357026L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_U")
    private Integer idUser;
    
    @Column(name = "NOME")
    private String  nome;
    @Column(name = "COGNOME")
    private String  cognome;
    @Column(name = "EMAIL")
    private String  email;
    @Column(name = "PASSWORD")
    private String  password;
    @Column(name = "ID_RUOLO")
    private Integer  idRuolo;
    
    @ManyToOne
    @JoinColumn(name="ID_RUOLO", nullable=false,updatable=false, insertable=false)
    private Ruolo   ruolo;
    
    public Integer getIdUser()
    {
        return idUser;
    }
    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
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
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public Ruolo getRuolo()
    {
        return ruolo;
    }
    public void setRuolo(Ruolo ruolo)
    {
        this.ruolo = ruolo;
    }
    
    public Integer getIdRuolo()
    {
	return idRuolo;
    }
    
    public void setIdRuolo(Integer idRuolo)
    {
	this.idRuolo = idRuolo;
    }
    @Override
    public int hashCode()
    {
	return Objects.hash(idUser);
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
	User other = (User) obj;
	return Objects.equals(idUser, other.idUser);
    }
    @Override
    public String toString()
    {
	return "User [idUser=" + idUser + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", ruolo="
		+ ruolo + "]";
    }
    
    
    

}
