import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Rebecca
 */
public class StudentTest {
    private Student stu = new Student("9999", "TEST_FNAME", "TEST_LNAME", 
                                        "TEST_EMAIL", "TEST_PHONE_NO",
                                        "TEST_MAJOR", "TEST_GRAD_DATE", 'T', 
                                        "TEST_ABOUTME", null);
    private Application studentApp = new Application("1111", "2222", stu.applicantInfo());

    @Test
    public void testtoString() {
        String expected = "******** Student Profile ***********\n"+
                            "Student ID: " + "9999" + "\n" +
                            "First Name: " + "TEST_FNAME" + "\n" +
                            "Last Name: " + "TEST_LNAME" + "\n" +
                            "Email: " + "TEST_EMAIL" + "\n" +
                            "Phone: " + "TEST_PHONE_NO" + "\n" +
                            "Major: " + "TEST_MAJOR" + "\n" +
                            "Graduation Date: " + "TEST_GRAD_DATE" + "\n" +
                            "About Me : " + "TEST_ABOUTME" + "\n" +
                            "Gender: " + "T" + "\n" +
                            "******* Student Applications: *********** " + "\n";
        
        String actual = "******** Student Profile ***********\n"+
                        "Student ID: " + stu.userID + "\n" +
                        "First Name: " + stu.firstName + "\n" +
                        "Last Name: " + stu.lastName + "\n" +
                        "Email: " + stu.email + "\n" +
                        "Phone: " + stu.phoneNo + "\n" +
                        "Major: " + stu.getMajor() + "\n" +
                        "Graduation Date: " + stu.getGradDate() + "\n" +
                        "About Me : " + stu.getAboutMe() + "\n" +
                        "Gender: " + stu.getGender() + "\n" +
                        "******* Student Applications: *********** " + "\n";
        Assert.assertEquals(expected, actual);
    } // end test student toString


    @Test
    public void applicantInfo() {
        String expected = "******** Student Profile ***********\n"+
                            "Student ID: " + "9999" + "\n" +
                            "First Name: " + "TEST_FNAME" + "\n" +
                            "Last Name: " + "TEST_LNAME" + "\n" +
                            "Email: " + "TEST_EMAIL" + "\n" +
                            "Phone: " + "TEST_PHONE_NO" + "\n" +
                            "Major: " + "TEST_MAJOR" + "\n" +
                            "Graduation Date: " + "TEST_GRAD_DATE" + "\n" +
                            "About Me : " + "TEST_ABOUTME" + "\n" +
                            "Gender: " + "T" + "\n";

        String actual = "******** Student Profile ***********\n"+
                            "Student ID: " + stu.userID + "\n" +
                            "First Name: " + stu.firstName + "\n" +
                            "Last Name: " + stu.lastName + "\n" +
                            "Email: " + stu.email + "\n" +
                            "Phone: " + stu.phoneNo + "\n" +
                            "Major: " + stu.getMajor() + "\n" +
                            "Graduation Date: " + stu.getGradDate() + "\n" +
                            "About Me : " + stu.getAboutMe() + "\n" +
                            "Gender: " + stu.getGender() + "\n";
        Assert.assertEquals(expected, actual);
    } // end test student applicantInfo

    @Test
    public void getKey()
    {
        String expected = "9999";
        String actual = stu.userID;
        Assert.assertEquals(expected, actual);
    } // end test student getKey

    @Test
    public void deepCopy(){
        String expected = "9999";
        String actual = stu.userID;
        Assert.assertEquals(expected, actual);
    } // end test student deepCopy

    @Test
    public void compareTo()
    {
        String expected = "9999";
        String actual = stu.userID;
        Assert.assertEquals(expected, actual);
    } // end test student compareTo

    @Test
    public void applyToListing() {
        String expected = "Application " + "1111" + " has been submitted.";
        String actual = "Application " + studentApp.getAppId() + " has been submitted.";
        Assert.assertEquals(expected, actual);
    } // end test student applyToListing

    @Test
    public void saveApplication() {
        String expected = "Application " + "1111" + " saved.\n";
        String actual = "Application " + studentApp.getAppId() + " saved.\n";
        Assert.assertEquals(expected, actual);
    } // end test student saveApplication


    // TEST FOR SETTERS AND GETTERS 
    @Test
    public void setMajor()
    {
        stu.setMajor("XX");
        String expected = "XX";
        String actual = stu.getMajor();
        Assert.assertEquals(expected, actual);
    } // end test student set and get major

    @Test
    public void setGradDate()
    {
        stu.setGradDate("XX-XX-XXXX");
        String expected = "XX-XX-XXXX";
        String actual = stu.getGradDate();
        Assert.assertEquals(expected, actual);
    } // end test student set and get grad date

    @Test
    public void setGender()
    {
        stu.setGender('X');
        char expected = 'X';
        char actual = stu.getGender();
        Assert.assertEquals(expected, actual);
    } // end test student set and get gender

    @Test
    public void setAboutMe()
    {
        stu.setAboutMe("XXXXXXXXXX");
        String expected = "XXXXXXXXXX";
        String actual = stu.getAboutMe();
        Assert.assertEquals(expected, actual);
    } // end test student set and get about me

    @Test
    public void setApp()
    {
        stu.setApp(studentApp);
        String expected = "1111";
        String actual = (stu.getApp()).get(0).getAppId();
        Assert.assertEquals(expected, actual);
    } // end test student set and get application
} // end student test class
