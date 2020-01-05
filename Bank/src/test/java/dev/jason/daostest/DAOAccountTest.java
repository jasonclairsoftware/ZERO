package dev.jason.daostest;

import org.junit.Test;

import dev.jason.daos.AccountLocalDAO;
import dev.jason.enities.Account;
import junit.framework.Assert;

public class DAOAccountTest {
	
	@Test
	public void createAccountTest() {
		AccountLocalDAO accountdao = new AccountLocalDAO();
		Account account = new Account("Checking", 1.0f, 0);
		accountdao.createAccount(account);
		Assert.assertEquals("Checking", accountdao.getAccountByID(account.getId()).getName());
		System.out.println("From test createAccountTest: " + accountdao.getAccountByID(1001));
	}
	
	@Test
	public void getAccountByIDTest() {
		AccountLocalDAO adao = new AccountLocalDAO();
		Account checking = new Account("Checking", -250000.0f, 0);
		adao.createAccount(checking);
		Assert.assertEquals("Checking", adao.getAccountByID(checking.getId()).getName());
		System.out.println("Test from getAccountByID: " + adao.getAccountByID(1001));
	}
	
	@Test
	public void updateAccountTest() {
		AccountLocalDAO adao = new AccountLocalDAO();
		Account savings = new Account("Savings", 0.0f, 0);
		adao.createAccount(savings);
		savings.setBalance(200.00f);
		savings.setAccountname("VIP Savings");
		savings.setAccountuserid(404);
		adao.updateAccount(savings);
		Assert.assertEquals("VIP Savings", adao.getAccountByID(savings.getId()).getName());
		System.out.println("Test from updateAccountTest: " + adao.getAccountByID(savings.getId()));
	}
	
	@Test
	public void deleteAccountTest() {
		AccountLocalDAO adao = new AccountLocalDAO();
		Account checking = new Account("Checking", 0.0f, 0);
		adao.createAccount(checking);
		Account worker = adao.getAccountByID(checking.getId());
		adao.deleteAccount(worker);
		
	}

}
