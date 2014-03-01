package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="veiculo")
@SuppressWarnings("serial")
public class Veiculo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Condomino dono;
	
	@Column(nullable=false, length=8)
	private String placa;
	
	@Column(nullable=false, length=30)
	private String modelo;
	
	@Column(nullable=false, length=25)
	private String cor;
	
	@Column(nullable=false, length=30)
	private String marca;
	
	public Veiculo() { }
	
	public Veiculo(int id, String placa, String modelo, String cor, String marca, Condomino dono) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.dono = dono;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Condomino getDono() {
		return dono;
	}
	public void setDono(Condomino d) {
		this.dono = d;
	}
}
