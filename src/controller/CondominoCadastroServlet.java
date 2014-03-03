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

import model.Condomino;
import model.Veiculo;
import dao.DAOCondomino;

@WebServlet("/condomino/cadastro")
public class CondominoCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("type", -1);
		request.getRequestDispatcher("/condomino/cadastro.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
		DAOCondomino dao = new DAOCondomino();
		int type = 1;
		String message = "";
		
		// Condomino
		String nome = request.getParameter("nome").trim();
		String email = request.getParameter("email").trim();
		Integer apto = Integer.parseInt(request.getParameter("apto"));
		Integer telefone = Integer.parseInt(request.getParameter("telefone").replace("-", ""));
		Integer moradores = Integer.parseInt(request.getParameter("moradores"));
		
		// Veiculo
		String placa = request.getParameter("placa").trim();
		String modelo = request.getParameter("modelo").trim();
		String cor = request.getParameter("cor").trim();
		String marca = request.getParameter("marca").trim();
		
		if (dao.findByEmail(email) != null) {
			message = "E-mail em uso";
		} else {
			type = 0;
			message = "Seu cadastro foi concluido com sucesso, aguarde um email com a validação da sua conta!";
			
			Veiculo v = new Veiculo();
			v.setPlaca(placa);
			v.setMarca(marca);
			v.setCor(cor);
			v.setModelo(modelo);
			
			Condomino c = new Condomino();
			c.setUsuario("apto" + apto);
			c.setData(new Date());
			c.setNome(nome);
			c.setApto(apto);
			c.setTelefone(telefone);
			c.setEmail(email);
			c.setMoradores(moradores);
			c.setVeiculo(v);
			v.setDono(c);
			
			dao.begin();
			dao.persist(c);
			dao.commit();
			dao.close();
		}
		
		request.setAttribute("type", type);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/condomino/cadastro.jsp").forward(request, response);
	}
		
}


