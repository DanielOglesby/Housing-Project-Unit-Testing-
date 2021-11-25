import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Hash_OwnerTest.
 *
 * @author  Abimbola
 * @version 4/29/21
 */
public class Hash_OwnerTest
{
   
   
    private Owner owner1 = new Owner("9999", "TEST_FNAME", "TEST_LNAME", 
                                    "TEST_EMAIL", "TEST_PHONE_NO", 
                                    null);
                                    
    
    Hash_Owner hash_Own1 =  new Hash_Owner(100);
    

    @Test
    public void insertOwner()
    {
        assertEquals(true, hash_Own1.insert(owner1));
    }

    @Test
    public void ShowAll()
    {
        hash_Own1.showAll();
    }
   
    @Test
    public void deleteOwner()
    {   
        hash_Own1.insert(owner1);
        assertEquals(true, hash_Own1.delete("9999"));
    }

    @Test
    public void updateOwner()
    {
        hash_Own1.insert(owner1);
        String id = "9999";
        assertEquals(true, hash_Own1.update("9999", owner1));
    }

    
    @Test
    public void fetchOwner()
    {
        hash_Own1.insert(owner1);
        assertNotNull("Verify owner fetch brings back object", hash_Own1.fetch("9999"));
    }
}