package tk.wonderdance.email.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.*;

public class SendEmailRequest {
    @NotNull
    @Email
    @JsonProperty("to_address")
    private String toAddress;

    @NotNull
    @Size(max = 256)
    private String subject;

    @NotNull
    private String content;

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
