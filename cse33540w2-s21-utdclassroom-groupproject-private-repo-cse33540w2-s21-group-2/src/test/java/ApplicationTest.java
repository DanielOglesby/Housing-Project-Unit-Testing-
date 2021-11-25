import org.junit.Test;
import org.junit.Assert;

public class ApplicationTest {
    //Normal argument constructor
    private Application app = new Application("1234", "5678", "Noble Bakken");
    //Single appId constructor
    private Application appIdCon = new Application("9876");
    //No argument constructor
	private Application appNoArg = new Application();


    @Test
	public void testGetAppId() {    //Test getAppId method
		String id = "1234";
		Assert.assertTrue("getAppId method test", id == app.getAppId());
	}

    @Test
	public void testGetDateApplied() {    //Test getDateApplied method
		Assert.assertNotNull("getDateApplied method test", app.getDateApplied());
	}

    @Test
	public void testToString() {
		Assert.assertNotNull("toString method test", app.toString());
	}



}