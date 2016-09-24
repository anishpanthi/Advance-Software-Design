package di.bank.service;

import java.util.Collection;

import di.bank.dao.IAccountDAO;
import di.bank.domain.Account;
import di.bank.domain.Customer;

public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
//	private IAccountDAO testAccountDAO;

//	public AccountService() {
//		accountDAO = new AccountDAO();
//	}
	
	public void setAccountDAO(IAccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
//	public void setTestAccountDAO(IAccountDAO testAccountDAO){
//		this.testAccountDAO = testAccountDAO;
//	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
