package listeners;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AcessoListener implements ServletContextListener {

  
    public AcessoListener() {
      
    }

    public void contextInitialized(ServletContextEvent event) {
    	Map<String,String> usuarios = new HashMap<String,String>();
    	usuarios.put("ana", "123");
    	usuarios.put("amanda", "123");
    	usuarios.put("erycsson", "123");
    	
    	event.getServletContext().setAttribute("usuarios", usuarios);  
    }

	
    public void contextDestroyed(ServletContextEvent event) {
     
    }
	
}
