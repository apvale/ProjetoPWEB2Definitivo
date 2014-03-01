package mail;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

import dao.DAOCondomino;
import dao.DAOUsuario;
 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/RecuperarSenha")
public class RecuperarSenha extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
       
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("condominio");
        Usuario c;
        DAOUsuario dao = new DAOUsuario();
        String login = request.getParameter("login");
        c = dao.findByLogin(login);
        
		dao.close();
 
        String resultMessage = "Sua senha é ";
 
        try {
            UtilizarEmail.sendSenha(host, port, user, pass, login);
            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
            
        } finally {
            request.setAttribute("Message", resultMessage);
            getServletContext().getRequestDispatcher("/entrar.jsp").forward(
                    request, response);
        }
    }
}