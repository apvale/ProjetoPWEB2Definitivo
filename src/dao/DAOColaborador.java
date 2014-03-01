package dao;

import java.util.List;


import model.Colaborador;




public class DAOColaborador extends DAOJPA<Colaborador> {
		public DAOColaborador(){
			super();
		}
		
		/*@SuppressWarnings("unchecked")
		public List<Categoria> findByRemetente(String remetente){
			return (List<Contato>) super.findByQuery("select c from Contato c where c.remetente = \"" + remetente + "\"");
		}*/
		
	}

