package tk.wonderdance.email.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import tk.wonderdance.email.model.Email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Configuration
public class EmailManager {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendmail(Email email) throws AddressException, MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email.getToAddress());
        helper.setText(email.getContent());
        helper.setSubject(email.getSubject());
        helper.setSentDate(new Date());

        javaMailSender.send(message);

    }
}
