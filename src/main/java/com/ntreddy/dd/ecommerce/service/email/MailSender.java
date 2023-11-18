package com.ntreddy.dd.ecommerce.service.email;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.ntreddy.dd.ecommerce.domain.TechGContactInfo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class MailSender {

	@Autowired
    private JavaMailSender mailSender;
	@Autowired
    private SpringTemplateEngine thymeleafTemplateEngine;

    @Value("${spring.mail.username}")
    private String fromusername;
    
    private String ccname="thirupathi@ddcloud.in";
    private String toname="Kanopatra@ddcloud.in";
    

    @SneakyThrows
    public void sendMessageHtml(String to, String subject, String template, Map<String, Object> attributes) throws MessagingException {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(attributes);
        String htmlBody = thymeleafTemplateEngine.process(template, thymeleafContext);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(fromusername);
	        helper.setTo(toname);
	        helper.setSubject(subject);
	        helper.setText(htmlBody, true);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        mailSender.send(message);
    }
    
    @SneakyThrows
    public void sendEmail(TechGContactInfo data) throws MessagingException {
//        Context thymeleafContext = new Context();
    	
    	
        String subject="Tech G contact info";
        Map<String, String> map = new HashMap<>();
        map.put("First Name",data.getFirstName());
        map.put("Last Name",data.getLastName());
        map.put("Email",data.getEmail());
        map.put("Message",data.getMessage());
//        thymeleafContext.setVariables(attributes);
//        String template="mail-templates/.html";
//        String htmlBody = thymeleafTemplateEngine.process(template, thymeleafContext);
//        String mapAsString = map.keySet().stream()
//        	      .map(key -> key + "=" + map.get(key))
//        	      .collect(Collectors.joining(", ", "{", "}"));
        StringBuilder htmlBuilder = new StringBuilder();
       
        htmlBuilder.append("<html>");
        htmlBuilder.append("<style>" +
        		"table, th, td {\n"
        		+ "  border:1px solid black;\n"
        		+ "}" +
        		"</style>");
        htmlBuilder.append("<body><h2>TechG Customer Request Submitted Data</h2>");
        htmlBuilder.append("<table style=\"width:100%\">");
        htmlBuilder.append("<tr><th>First Name</th><th>Last Name</th><th>Mobile No</th><th>Email</th><th>Message</th></tr>");
        htmlBuilder.append("<body><tr><td>"+data.getFirstName()+"</td><td>"+data.getLastName()+"</td>"
        		+ "<td>"+data.getMobileNo()+"</td><td>"+data.getEmail()+"</td><td>"+data.getMessage()+"</td></tr></table>");
        htmlBuilder.append("<p>This is a system generated email. Please do not reply to this message.</p>");
        htmlBuilder.append("</body></html>");
        String html = htmlBuilder.toString();
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(fromusername);
	        helper.setTo(toname);
	        helper.setCc(ccname);
	        helper.setSubject(subject);
	        helper.setText(html, true);
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        mailSender.send(message);
    }
}
