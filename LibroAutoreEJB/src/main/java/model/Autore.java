package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(
	    name="findAllAutori",
	    query="SELECT a FROM Autore a"
	)
public class Autore implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cognome;
	
	@Column(name = "data_di_nascita")
	private Date dataNascita;
	
	@Column(name = "luogo_di_nascita")
	private String luogoNascita;
	
	@Column(name = "cod_fiscale")
	private String codFiscale;
	
	@OneToMany(mappedBy="autore", cascade = CascadeType.ALL, fetch=FetchType.LAZY) //default=LAZY
	private List<Libro> libri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	
	public String toString() {
		return "( Nome: "+ nome+ ", Cognome: "+cognome +", Data di nascit�: " + dataNascita + ", Luogo di nascit�: " + luogoNascita + ", Codice fiscale: " + codFiscale +" )" + "\n";
	}
	
}
