package controller;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import dao.DAOUsuario;

@SuppressWarnings("serial")
@WebServlet("/condomino/alterar-senha")
public class CondominoAlterarSenhaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOUsuario dao = new DAOUsuario();
		int type = -1;
		String message = "";
		
		String codigo = request.getParameter("codigo");
		Usuario c = dao.findByCodigoDeRecuperacao(codigo);
		
		if (c == null) {
			type = 1;
			message = "Codigo de recuperação não encontrado!";
		} else {
			Date d_agora = new Date();
			Date d_pedido = c.getRecuperarData();
			
			if (d_agora.getTime() > d_pedido.getTime() + 86400000) {
				type = 1;
				message = "O codigo de recuperação não é mais valido!";
			} else {
				request.setAttribute("codigo", codigo);
			}
		}
	
		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/condomino/alterar-senha.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOUsuario dao = new DAOUsuario();
		int type = 1;
		String message = "";
		
		String codigo = request.getParameter("codigo");
		String senha_1 = request.getParameter("senha_1");
		String senha_2 = request.getParameter("senha_2");
		Usuario c = dao.findByCodigoDeRecuperacao(codigo);
		
		if (c == null) {
			message = "Codigo de recuperação não encontrado!";
		} else {
			Date d_agora = new Date();
			Date d_pedido = c.getRecuperarData();
			
			if (d_agora.getTime() > d_pedido.getTime() + 86400000) {
				message = "O codigo de recuperação não é mais valido!";
			} else if (senha_1.length() < 4) {
				type = 2;
				message = "A senha deve ter no minimo 4 caracteres";
				request.setAttribute("codigo", codigo);
			} else if (!senha_1.equals(senha_2)) {
				type = 2;
				message = "As senhas devem ser iguais!";
				request.setAttribute("codigo", codigo);
			} else {
				type = 0;
				message = "Sua senha foi alterada com sucesso";
				dao.begin();
				c.setRecuperarCodigo(null);
				c.setRecuperarData(null);
				c.setSenha(Usuario.hashSenha(senha_1));
				dao.commit();
				dao.close();
			}
		}

		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/condomino/alterar-senha.jsp").forward(request, response);
	}

}
