package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usuario_condomino")
@DiscriminatorValue("Condomino")
public class Condomino extends Usuario {
	@Column(nullable=false)
	private int apto;

	private int telefone;
	
	@Column(nullable=false, unique=true, length=100)
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Veiculo veiculo;
	
	@Column(nullable=false)
	private int moradores;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Condomino() { }
	
	public Condomino(int id, String usuario, String senha, String nome, int apto, int telefone, String email, Veiculo veiculo, int moradores, Date data) {
		super(id, usuario, senha, nome, 0);
		this.apto = apto;
		this.telefone = telefone;
		this.email = email;
		this.veiculo = veiculo;
		this.moradores = moradores;
		this.data = data;
	}
	
	public int getApto() {
		return apto;
	}
	public void setApto(int apto) {
		this.apto = apto;
	}
	
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public int getMoradores() {
		return moradores;
	}
	public void setMoradores(int moradores) {
		if (moradores < 0)
			throw new RuntimeException("Parametro invalido");
		this.moradores = moradores;
	}
	
	public void setData(Date d) {
		this.data = d;
	}
	public Date getData() {
		return this.data;
	}
}
