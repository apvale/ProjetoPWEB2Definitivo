package dao;

import java.util.List;

import javax.persistence.Query;

import model.Condomino;



public class DAOCondomino extends DAOJPA<Condomino> {
		public DAOCondomino(){
			super();
		}
		
		/*@SuppressWarnings("unchecked")
		public List<Categoria> findByRemetente(String remetente){
			return (List<Contato>) super.findByQuery("select c from Contato c where c.remetente = \"" + remetente + "\"");
		}*/
		
		public Condomino findByEmail(String email){
			try {
				Query q = getManager().createQuery("SELECT u FROM Usuario u WHERE u.email=?1");
				q.setParameter(1, email);
				return (Condomino) q.getSingleResult();
			} catch (Exception e) {
				return null;
			}
		}
	}

