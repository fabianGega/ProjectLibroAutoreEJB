package dto;

import java.io.Serializable;

public class LibroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titolo;
	private String codiceIsbn;
	private String genere;
	private Double prezzo;
	private AutoreDTO autore;
	
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
	public AutoreDTO getAutore() {
		return autore;
	}
	public void setAutore(AutoreDTO autore) {
		this.autore = autore;
	}

	
}
