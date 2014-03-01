package dao;

import javax.persistence.Query;

import model.Usuario;


public class DAOUsuario extends DAOJPA<Usuario> {
	public DAOUsuario(){
		super();
	}
		
		/*@SuppressWarnings("unchecked")
		public List<Categoria> findByRemetente(String remetente){
			return (List<Contato>) super.findByQuery("select c from Contato c where c.remetente = \"" + remetente + "\"");
		}*/

		
	public Usuario findByLogin(String login){
		try {
			Query q = getManager().createQuery("SELECT u FROM Usuario u WHERE u.usuario=?1");
			q.setParameter(1, login);
			return (Usuario) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}