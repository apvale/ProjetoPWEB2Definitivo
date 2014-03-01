package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="usuario_colaborador")
@CascadeOnDelete
@SuppressWarnings("serial")
public class Colaborador implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeColaborador, profissao, empresa, telefone, horario;
	
	
	public Colaborador(){}
	
	public Colaborador(String nomeColaborador, String profissao, String empresa, String telefone, String horario) {
		this.nomeColaborador = nomeColaborador;
		this.profissao = profissao;
		this.empresa = empresa;
		this.telefone = telefone;
		this.horario = horario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	
	
	
	
}
