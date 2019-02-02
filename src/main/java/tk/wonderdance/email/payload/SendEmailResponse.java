package tk.wonderdance.email.payload;

import javax.validation.constraints.NotNull;

public class SendEmailResponse {
    @NotNull
    private Boolean success;

    public SendEmailResponse(Boolean success){
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
