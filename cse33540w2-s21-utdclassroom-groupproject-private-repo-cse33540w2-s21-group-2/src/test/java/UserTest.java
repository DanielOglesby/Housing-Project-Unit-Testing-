import org.junit.Test;
import org.junit.Assert;

public class UserTest {
	
	private User u = new User("320598", "Daniel", "Oglesby", "dgo170000@utdallas.edu", "8329046070");
	private User e = new User();
	
		
	@Test
	public void testUserID() {
		String id = "320598";
		Assert.assertTrue("success", id == u.getID());
	}
	@Test
	public void testFirstName() {
		String firstname = "Daniel";
		Assert.assertTrue("success", firstname == u.getfirst());
	}
	@Test
	public void testLastName() {
		String lastname = "Oglesby";
		Assert.assertTrue("success", lastname == u.getlast());
	}
	@Test
	public void testEmail() {
		String email = "dgo170000@utdallas.edu";
		Assert.assertTrue("success", email == u.getemail());
	}
	@Test
	public void testPhoneNo() {
		String phoneNo = "8329046070";
		Assert.assertTrue("success", phoneNo == u.getphone());
	}
	@Test
	public void testCreation() {
		Assert.assertNotNull("success", u);
	}
	@Test
	public void testEmptyCreation() {
		Assert.assertNotNull("success", e);
	}
	@Test
	public void testSetEmail() {
		u.setemail("x");
		Assert.assertEquals("x", u.getemail());
	}
	@Test
	public void testSetFirst() {
		u.setfirst("x");
		Assert.assertEquals("x", u.getfirst());
	}
	@Test
	public void testSetLast() {
		u.setlast("x");
		Assert.assertEquals("x", u.getlast());
	}
	@Test
	public void testSetID() {
		u.setID("x");
		Assert.assertEquals("x", u.getID());
	}
	@Test
	public void testSetPhone() {
		u.setphone("x");
		Assert.assertEquals("x", u.getphone());
	}
}

