package za.co.invoketech.store.model;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import za.co.invoketech.store.domain.model.role.Role;

public class RoleTest {

	Role admin;
	
	@Before
	public void setUp() {
		admin = new Role("administrator");
	}
	
	@Test
	public void rolesAreEqual() {
		Role other = new Role("administrator");
		assertEquals(admin, other);
	}
	
	@Test
	public void rolesAreNotEqual() {
		Role other = new Role("user");
		assertFalse(admin.equals(other));
	}
}
