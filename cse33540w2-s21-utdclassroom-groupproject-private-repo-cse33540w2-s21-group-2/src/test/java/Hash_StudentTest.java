import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Hash_StudentTest.
 *
 * @author  Abimbola
 * @version 4/29/21
 */
public class Hash_StudentTest
{
   
    private Student student1 = new Student("9999", "TEST_FNAME", "TEST_LNAME", 
                                        "TEST_EMAIL", "TEST_PHONE_NO",
                                        "TEST_MAJOR", "TEST_GRAD_DATE", 'T', 
                                        "TEST_ABOUTME", null);
  
    
   
  

    Hash_Student hash_Stu1 =  new Hash_Student(100);

    @Test
    public void insertStudent()
    {
        assertEquals(true, hash_Stu1.insert(student1));
    }

    @Test
    public void ShowAll()
    {
        hash_Stu1.showAll();
    }
    
   
    
    @Test
    public void fetchStudent()
    {
        hash_Stu1.insert(student1);
        String id = "9999";
        assertNotNull("Verify fetch brings student back",  hash_Stu1.fetch(id));
    }

   

    @Test
    public void deleteStudent()
    {   
        hash_Stu1.insert(student1);
        assertEquals(true, hash_Stu1.delete("9999"));
    }

    @Test
    public void updateStudent()
    {
        hash_Stu1.insert(student1);
        String id = "9999";
        assertEquals(true, hash_Stu1.update("9999", student1));
    }
}