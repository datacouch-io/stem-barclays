package srp.solution;

import common.ValidationException;

public class UserService {

  private UserRepository repository;
  private EmailService emailService;

  public UserService(UserRepository connection, EmailService emailService) {
    this.repository = connection;
    this.emailService = emailService;
  }

  public void register(String email, String password) throws ValidationException {

    if (emailService.validateEmail(email)) {
      User user = new User(email, password);
      repository.save(user);
      emailService.send(email);
    }

  }
}
