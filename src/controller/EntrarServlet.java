package controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrador;
import model.Condomino;
import model.Usuario;
import dao.DAOUsuario;

@WebServlet("/entrar")
public class EntrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/entrar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOUsuario dao = new DAOUsuario();
		int type = 1;
		String message = "";
		Usuario c;
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		c = dao.findByLogin(login);
		dao.close();
		
		if(c != null){
			senha = Usuario.hashSenha(senha);
			if (senha.equals(c.getSenha())){				
				HttpSession session = request.getSession();
				
				if (c instanceof Condomino)
					session.setAttribute("usuario", (Condomino) c);
				else
					session.setAttribute("usuario", (Administrador) c);
				
				type = 0;
				((HttpServletResponse) response).sendRedirect("painel.jsp");
				return;
			} else {
				message = "Senha incorreta";
			}
		} else {
			message = "Condômino não encotrado!";
		}
		
		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/entrar.jsp").forward(request, response);
	}
}
