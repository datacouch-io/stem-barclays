package isp.solution;

public interface Loan extends Payment {
  void intiateLoanSettlement();
  void initiateRePayment();
}