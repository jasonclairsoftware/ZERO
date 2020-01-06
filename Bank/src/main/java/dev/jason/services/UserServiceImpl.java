package dev.jason.services;

import java.util.ArrayList;
import java.util.List;
import dev.jason.daos.AccountDAO;
import dev.jason.daos.AccountLocalDAO;
import dev.jason.daos.UserDAO;
import dev.jason.daos.UserLocalDAO;
import dev.jason.enities.Account;
import dev.jason.enities.User;

public class UserServiceImpl implements UserService{

	private UserDAO udao = new UserLocalDAO();
	private AccountDAO adao = new AccountLocalDAO();
	
	public User createUser(User user) {
		
		
		
		
		
		
		
		
		user = udao.createUser(user); // updates ID
		return udao.getUserByID(user.getId());
	}

	public User login(User user) {
		User temp = udao.getUserByUsername(user.getUsername());
		// The strings are returning false
		if (temp != null && temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
			user.setIsloggedin(true);
			udao.updateUser(temp);
			return temp;
		}
		//System.out.println("This is just a test");
		return null;
	}

	public User logout(User user) {
		User temp = udao.getUserByID(user.getId());
		if (temp != null && temp.isloggedin()) {
			user.setIsloggedin(false);
			return udao.updateUser(user);
		}
		return null;
	}

	public Account getBalance(Account account) {
		Account temp = adao.getAccountByID(account.getId());
		if (temp != null)
			return temp;
		return null;
	}

	public Account createAccount(Account account) {
		account = adao.createAccount(account);  // Updates ID
		return adao.getAccountByID(account.getId());
	}

	public Account depositToAccount(Account account, float amount) {
		if (amount > 0) {
			account.setBalance(account.getBalance() + amount);
			account = adao.updateAccount(account);
		}
		return adao.getAccountByID(account.getId());
	}

	public boolean deleteAccount(Account account) {
			return adao.deleteAccount(account); // DAO checks if empty
	}

	public Account withdrawFromAccount(Account account, float amount) {
		float balance = adao.getAccountByID(account.getId()).getBalance();
		if (amount <= balance) {
			account.setBalance(account.getBalance() - amount);
			account = adao.updateAccount(account);
		}
		return adao.getAccountByID(account.getId());
	}

	public void printAccounts(User user) {
		List<Account> accounts = new ArrayList<Account>(adao.getAccountByUserID(user));
		for (Account account : accounts) {
			System.out.println(account);
		}
		
	}

}
