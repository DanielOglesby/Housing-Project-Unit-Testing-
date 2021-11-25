import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class AdminTest {
    private Admin adm = new Admin("1234", "ADMIN", "LastName", "admin@test.edu", "8889991111");
    private Admin noArgAdmin = new Admin();
    
    @Test
    public void testSetUserID() {
        String newID = adm.newID('u');
        Assert.assertNotNull("Test newID for user", newID);
    }

    @Test
    public void testSetListingID() {
        String newID = adm.newID('l');
        Assert.assertNotNull("Test newID for listing", newID);
    }

    @Test
    public void testSetAppID() {
        String newID = adm.newID('a');
        Assert.assertNotNull("Test newID for app", newID);
    }

    @Test
    public void testBadIDOperation() {
        String newID = adm.newID('x');
        System.out.println(newID);
        Assert.assertEquals("Unable to perform ID operation", newID);
    }
}
