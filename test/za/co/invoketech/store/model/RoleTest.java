package za.co.invoketech.store.model;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import za.co.invoketech.store.model.entity.role.Role;

public class RoleTest {

	Role admin;
	
	@Before
	public void setUp() {
		admin = Role.getInstance("administrator");
	}
	
	@Test
	public void rolesAreEqual() {
		Role other = Role.getInstance("administrator");
		assertEquals(admin, other);
	}
	
	@Test
	public void rolesAreNotEqual() {
		Role other = Role.getInstance("user");
		assertFalse(admin.equals(other));
	}
}
