package controller;

import helper.EmailHelper;
import helper.UrlHelper;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Condomino;
import dao.DAOCondomino;

@WebServlet("/condomino/recuperar-senha")
@SuppressWarnings("serial")
public class CondominoRecuperarSenhaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("type", -1);
		request.getRequestDispatcher("/condomino/recuperar-senha.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOCondomino dao = new DAOCondomino();
		int type = 1;
		String message = "";
		
		String email = request.getParameter("email");
		Condomino c = dao.findByEmail(email);
		
		if (c == null) {
			message = "E-mail não encontrado!";
		} else {
			type = 0;
			message = "Um e-mail com as informações necessarias para recuperar a senha foi enviado!";
			dao.begin();
			String codigo = c.gerarCodigoDeRecuperarSenha();
			String url = UrlHelper.getUrlRelativo(request, "/condomino/alterar-senha?codigo=" + codigo);
			
			try {
				EmailHelper.getInstance().sendAlterarSenha(c.getEmail(), c.getNome(), url);
			} catch (Exception e) { }
			
			dao.commit();
			dao.close();
		}

		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/condomino/recuperar-senha.jsp").forward(request, response);
	}
}
