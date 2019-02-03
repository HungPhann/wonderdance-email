package tk.wonderdance.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.wonderdance.email.helper.EmailManager;
import tk.wonderdance.email.model.Email;
import tk.wonderdance.email.payload.SendEmailRequest;
import tk.wonderdance.email.payload.SendEmailResponse;

import javax.validation.Valid;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailManager emailManager;
//
//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    public ResponseEntity<?> test(){
//        return ResponseEntity.ok("OK");
//    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public ResponseEntity<?> send(@Valid @RequestBody SendEmailRequest sendEmailRequest) {
        String toAddress = sendEmailRequest.getToAddress();
        String subject = sendEmailRequest.getSubject();
        String content = sendEmailRequest.getContent();

        Email email = new Email(toAddress, subject, content);

        try {
            emailManager.sendmail(email);
            return ResponseEntity.ok(new SendEmailResponse(true));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new SendEmailResponse(true));
        }

    }
}
