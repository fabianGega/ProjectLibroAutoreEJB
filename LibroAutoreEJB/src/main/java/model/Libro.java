package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_libro", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String titolo;
	
	@Column(name = "codice_isbn")
	private String codiceIsbn;
	
	private String genere;
	
	private Double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "autore_id")
	private Autore autore;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCodiceIsbn() {
		return codiceIsbn;
	}

	public void setCodiceIsbn(String codiceIsbn) {
		this.codiceIsbn = codiceIsbn;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	public String toString() {
		return "( Titolo: "+ titolo+ ", Autore: "+ autore.getNome()+ " "+ autore.getCognome() + ", Genere: " + genere +", Codice ISBN: " + codiceIsbn + ", Prezzo: " + prezzo + " )" + "\n";
	}
	
}
