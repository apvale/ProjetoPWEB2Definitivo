package helper;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHelper {
	private static EmailHelper instance;
	private Session session;
	
	private EmailHelper() {}
	
	public static EmailHelper getInstance() {
		if (instance == null) {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", 587);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");

			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("projeto.pweb.2014.1@gmail.com", "projeto1691");
				}
			};

			EmailHelper helper = new EmailHelper();
			helper.session = Session.getInstance(properties, auth);
			
			instance = helper;
		}
		
		return instance;
	}
	
	private MimeMessage getEmail(String destinatario, String nome) throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage mail = new MimeMessage(session);

		mail.setFrom(new InternetAddress("projeto.pweb.2014.1@gmail.com", "Jampa Palace"));
		mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario, nome));
		mail.setSentDate(new Date());
		
		return mail;
	}

	public void sendSenha(String destinatario, String nome, String usuario, String senha) throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage mail = getEmail(destinatario, nome);
		mail.setSubject("Ativação de conta");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Jampa Palace</h2>");
		sb.append("<h4>Ativação de conta</h4>");
		sb.append("<p>Sua conta foi aceita e ativada com sucesso.</p>");
		sb.append("<p>Dados pessoais para acesso a sua conta:<br/>");
		sb.append("    <strong>Usuário:</strong> " + usuario + "<br/>");
		sb.append("    <strong>Senha:</strong> " + senha);
		sb.append("</p>");
		
		mail.setContent(sb.toString(), "text/html; charset=utf-8");
		Transport.send(mail);
	}

	public void sendAlterarSenha(String destinatario, String nome, String url) throws AddressException, MessagingException, UnsupportedEncodingException {
		MimeMessage mail = getEmail(destinatario, nome);
		mail.setSubject("Recuperação de senha");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h2>Jampa Palace</h2>");
		sb.append("<h4>Recuperação de senha</h4>");
		sb.append("<p>Houve um pedido de recuperação de senha para esta conta.</p>");
		sb.append("<p>Para alterar a senha clique <a href=\"" + url + "\">aqui</a>, caso contrario apenas ignore este e-mail</p>");
		sb.append("<p>Caso não consiga acessar o link acima, copie a url abaixo e cole na barra de endereço do seu navegador.</p>");
		sb.append("<p>" + url + "</p>");
		
		mail.setContent(sb.toString(), "text/html; charset=utf-8");
		Transport.send(mail);
	}
}