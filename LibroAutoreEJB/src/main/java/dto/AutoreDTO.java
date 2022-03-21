package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

public class AutoreDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String luogoNascita;
	private String codFiscale;
	private List<LibroDTO> libri;
	
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
	public List<LibroDTO> getLibri() {
		return libri;
	}
	public void setLibri(List<LibroDTO> libri) {
		this.libri = libri;
	}
	
	@Override
	public String toString() {
		return "AutoreDTO [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", luogoNascita=" + luogoNascita + ", codFiscale=" + codFiscale + ", libri=" + libri + "]";
	}

	
}
