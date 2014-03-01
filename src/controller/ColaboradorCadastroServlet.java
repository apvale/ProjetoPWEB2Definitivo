package controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Colaborador;
import dao.DAOColaborador;
import dao.DAOJPA;


@WebServlet("/colaborador/cadastro")
public class ColaboradorCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/colaborador/cadastro.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOColaborador dao = new DAOColaborador();
		
		HttpSession session = request.getSession();
		
		String nome = request.getParameter("nome");
		String profissao = request.getParameter("profissao");
		String empresa = request.getParameter("empresa");
		String telefone = request.getParameter("telefone");
		String horario = request.getParameter("horario_atendimento");
		
		Colaborador c = new Colaborador();
		c.setNomeColaborador(nome);
		c.setProfissao(profissao);
		c.setEmpresa(empresa);
		c.setTelefone(telefone);
		c.setHorario(horario);

		dao.begin();
		dao.persist(c);
		dao.commit();		
		dao.close();
	}
		
}


