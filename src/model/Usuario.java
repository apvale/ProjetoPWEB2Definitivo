package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="usuario")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING, length=13)
@DiscriminatorValue("Usuario")
@CascadeOnDelete
@SuppressWarnings("serial")
public abstract class Usuario implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(length=16)
	protected String usuario;
	
	@Column(length=32)
	protected String senha;
	
	@Column(nullable=false, length=100)
	private String nome;

	@Column(nullable=true, length=36)
	private String recuperar_codigo;
	
	@Column(nullable=true)
	@Temporal(TemporalType.DATE)
	private Date recuperar_data;

	public Usuario() { }
	
	public Usuario(int id, String usuario, String senha, String nome) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
	}
	
	public static String hashSenha(String senha) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(), 0, senha.length());
			BigInteger i = new BigInteger(1, m.digest());
			return String.format("%1$032X", i);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String gerarSenha() {
		return UUID.randomUUID()
			       .toString()
			       .replace("-", "")
			       .substring(0, 8);
	}
	
	public String gerarCodigoDeRecuperarSenha() {
		String codigo = UUID.randomUUID().toString();
		recuperar_codigo = codigo;
		recuperar_data = new Date();
		return codigo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRecuperarCodigo() {
		return recuperar_codigo;
	}
	public void setRecuperarCodigo(String codigo) {
		this.recuperar_codigo = codigo;
	}

	public Date getRecuperarData() {
		return recuperar_data;
	}
	public void setRecuperarData(Date data) {
		this.recuperar_data = data;
	}
}
