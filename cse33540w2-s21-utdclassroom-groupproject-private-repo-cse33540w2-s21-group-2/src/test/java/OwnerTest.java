import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

/**
 *
 * @author Rebecca
 */
public class OwnerTest {
     private Owner onr = new Owner("9999", "TEST_FNAME", "TEST_LNAME", 
                                     "TEST_EMAIL", "TEST_PHONE_NO", 
                                     new ArrayList<Listing>());
     private Listing listing = new Listing("532987", "900", "monthly", 
                                             "123 Sesame St", "Apartment", 
                                             "2", "1", "1000", "Furnished",
                                             "pending", new ArrayList<Application>());
 
     
     @Test
     public void addListing()
     {
         onr.addListing(listing);
         String expected = listing.listingID;
         String actual = onr.getListing().listingID;
         Assert.assertEquals(expected, actual);
     } // end test owner add listing and get listing
 
     @Test
     public void removeListing()
     {
         onr.addListing(listing);
         Boolean expected = true;
         Boolean actual = onr.removeListing("532987");
         Assert.assertEquals(expected, actual);
     } // end test owner remove listing
 
     @Test
     public void getKey()
     {
         String expected = "9999";
         String actual = onr.userID;
         Assert.assertEquals(expected, actual);
     } // end test own getKey
 
     @Test
     public void deepCopy()
     {
         String expected = "9999";
         String actual = onr.userID;
         Assert.assertEquals(expected, actual);
     } // end test owner deep copy
 
     @Test
     public void compareTo()
     {
         String expected = "9999";
         String actual = onr.userID;
         Assert.assertEquals(expected, actual);
     } // end test owner compareTo
 
     @Test
     public void testtoString()
     {
         String expected = "******** Owner Profile ***********\n"+
                             "User ID: " + "9999" + "\n" +
                             "First Name: " + "TEST_FNAME" + "\n" +
                             "Last Name: " + "TEST_LNAME" + "\n" +
                             "Email: " + "TEST_EMAIL" + "\n" +
                             "Phone: " + "TEST_PHONE_NO" + "\n" ;
         String actual = "******** Owner Profile ***********\n"+
                             "User ID: " + onr.userID + "\n" +
                             "First Name: " + onr.firstName + "\n" +
                             "Last Name: " + onr.lastName + "\n" +
                             "Email: " + onr.email + "\n" +
                             "Phone: " + onr.phoneNo + "\n" ;
         Assert.assertEquals(expected, actual);
     } // end test owner toString
 
     @Test
     public void viewListings()
     {
         onr.addListing(listing);
         String expected = "******** Owner's Listing ***********\n"+
                             "Listing ID: " + "532987" + "\n" +
                             "Price: " + "900" + "\n" +
                             "Pricing Schedule: " + "monthly" + "\n" +
                             "Location: " + "123 Sesame St" + "\n" +
                             "Bedrooms: " + "2" + "\n" +
                             "Bathrooms: " + "1" + "\n" +
                             "SQF: " + "1000" + "\n" +
                             "Furnished: " + "Furnished" + "\n" ;
 
         String actual = "******** Owner's Listing ***********\n"+
                             "Listing ID: " + listing.listingID + "\n" +
                             "Price: " + listing.getPrice() + "\n" +
                             "Pricing Schedule: " + listing.getPricingSchedule() + "\n" +
                             "Location: " + listing.location + "\n" +
                             "Bedrooms: " + listing.bedrooms + "\n" +
                             "Bathrooms: " + listing.bathrooms + "\n" +
                             "SQF: " + listing.getSquareFootage() + "\n" +
                             "Furnished: " + listing.getFurnished() + "\n" ;
         Assert.assertEquals(expected, actual);
     } // end test owner viewListing
 } // end owner test class 