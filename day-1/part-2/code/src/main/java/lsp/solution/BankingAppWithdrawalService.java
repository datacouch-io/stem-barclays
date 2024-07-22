package lsp.solution;

import java.math.BigDecimal;

public class BankingAppWithdrawalService {
  private WithdrawableAccount account;

  public BankingAppWithdrawalService(WithdrawableAccount account) {
    this.account = account;
  }

  public void withdraw(BigDecimal amount) {
    account.withdraw(amount);
  }
}
