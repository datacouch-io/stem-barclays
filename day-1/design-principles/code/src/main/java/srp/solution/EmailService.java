package srp.solution;

import common.ValidationException;

public class EmailService {
    SMTPClient client;

    public boolean validateEmail(String email) throws ValidationException {
        if(!email.contains("@")) {
            throw new ValidationException("Email is not valid");
        }
        return true;
    }

    public void send(String email) {
        MailMessage mailMessage = new MailMessage("mysite@nowhere.com", email);
        String subject = "Hello, you are now registered";
        client.send(mailMessage, subject);
    }
}
