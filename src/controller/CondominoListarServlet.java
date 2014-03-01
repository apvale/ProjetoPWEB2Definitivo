package controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Condomino;
import model.Usuario;
import dao.DAOCondomino;
import dao.DAOUsuario;

@WebServlet("/admin/condominos")
public class CondominoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOCondomino dao = new DAOCondomino();
		List<Condomino> condominos = dao.findAll();
		
		request.setAttribute("condominos", condominos);
		request.getRequestDispatcher("/admin/condominos/lista.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		if (acao.equals("aceitar")) {
			DAOCondomino dao = new DAOCondomino();
			Condomino c = dao.find(id);
			dao.begin();
			String senha = Usuario.gerarSenha();
			c.setSenha(Usuario.hashSenha(senha));
			c.setAtivado(true);
			dao.commit();
			dao.close();
		} else if (acao.equals("negar")) {
			DAOUsuario dao = new DAOUsuario();
			dao.begin();
			Usuario u = dao.find(id);
			dao.remove(u);
			dao.commit();
			dao.close();
		}
		
	}

}
