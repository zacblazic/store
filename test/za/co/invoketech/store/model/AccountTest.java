package za.co.invoketech.store.model;

import static junit.framework.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import za.co.invoketech.store.model.entity.account.Account;
import za.co.invoketech.store.model.entity.role.Role;

public class AccountTest {

	private Role administrator;
	private Role user;
	private Account account;
	
	@Before
	public void setUp() {
		account = Account.getInstance("zacblazic@gmail.com", "password");
		administrator = Role.getInstance("administrator");
		user = Role.getInstance("user");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(administrator);
		roles.add(user);
		
		account.setRoles(roles);
	}
	
	@Test
	public void canAddRole() {
		Role moderator = Role.getInstance("moderator");
		account.addRole(moderator);
		assertTrue(account.hasRole(moderator));
		assertTrue(account.hasRole("moderator"));
	}
	
	@Test
	public void canRemoveRole() {
		assertTrue(account.hasRole("user"));
		account.removeRole("user");
		assertFalse(account.hasRole("user"));
	}
	
	@Test
	public void canRemoveAllRoles() {
		assertFalse(account.getRoleCount() == 0);
		account.removeAllRoles();
		assertTrue(account.getRoleCount() == 0);
	}
	
	@Test
	public void accountsAreEqual() {
		Account other = Account.getInstance("zacblazic@gmail.com", "password");
		assertEquals(account, other);
	}
	
	@Test
	public void accountsAreNotEqual() {
		Account other = Account.getInstance("mollerruan@gmail.com", "password");
		assertFalse(account.equals(other));
	}
}
