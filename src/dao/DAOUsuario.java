package dao;

import javax.persistence.Query;

import model.Usuario;

public class DAOUsuario extends DAOJPA<Usuario> {
	public DAOUsuario() {
		super();
	}

	public Usuario findByLogin(String login) {
		try {
			Query q = getManager().createQuery(
					"SELECT u FROM Usuario u WHERE u.usuario=?1");
			q.setParameter(1, login);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Usuario findByCodigoDeRecuperacao(String codigo) {
		try {
			Query q = getManager().createQuery("SELECT u FROM Usuario u WHERE u.recuperar_codigo=?1");
			q.setParameter(1, codigo);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}