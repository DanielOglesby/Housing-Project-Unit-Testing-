import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;


public class ListingTest {
	
	ArrayList<Application> a = new ArrayList<Application>();
	
	private Listing l = new Listing("532987", "900", "monthly", "123 Sesame St", "Apartment", "2", "1", "1000", "Furnished", "Available", a );
	private Listing n = new Listing();
	
	@Test
	public void testListingID() {
		String id = "532987";
		Assert.assertTrue("success", id == l.getListingID());
	}
	@Test
	public void testPrice() {
		String price = "900";
		Assert.assertTrue("success", price == l.getPrice());
	}
	@Test
	public void testSchedule() {
		String schedule = "monthly";
		Assert.assertTrue("success", schedule == l.getPricingSchedule());
	}
	@Test
	public void testLocation() {
		String location = "123 Sesame St";
		Assert.assertTrue("success", location == l.getLocation());
	}
	@Test
	public void testBuildingType() {
		String buildingType = "Apartment";
		Assert.assertTrue("success", buildingType == l.getBuildingType());
	}
	@Test
	public void testBedrooms() {
		String bedrooms = "2";
		Assert.assertTrue("success", bedrooms == l.getBedrooms());
	}
	@Test
	public void testBathrooms() {
		String bathrooms = "1";
		Assert.assertTrue("success", bathrooms == l.getBathrooms());
	}
	@Test
	public void testSqft() {
		String sqft = "1000";
		Assert.assertTrue("success", sqft == l.getSquareFootage());
	}
	public void testFurnish() {
		String furnish = "Furnished";
		Assert.assertTrue("success", furnish == l.getFurnished());
	}
	@Test
	public void testStat() {
		String stat = "Available";
		Assert.assertTrue("success", stat == l.getStatus());
	}
	@Test
	public void testApplicationList() {
		ArrayList<Application> a = new ArrayList<Application>();
		Assert.assertNotNull("success", a);
	}
	@Test
	public void testEmptyCreation() {
		Assert.assertNotNull("success", n);
	}
	@Test
	public void testCreation() {
		Assert.assertNotNull("success", l);
	}
    @Test
	public void testToString() {
		String expected = "******** Owner's Listing ***********\n"+
                "Listing ID: " +"532987"+ "\n" +
                "Price: " +"900" + "\n" +
                "Pricing Schedule: " +"monthly" + "\n" +
                "Location: " +"123 Sesame St" + "\n" +
                "Bedrooms: " +"2" + "\n" +
                "Bathrooms: " +"1" + "\n" +
                "SQF: " +"1000" + "\n" +
                "Furnished: " +"Furnished"+ "\n";
		Assert.assertNotNull(expected);
	}
	@Test
	public void testSetStatus() {
		l.setStatus("x");
		Assert.assertEquals("x", l.getStatus());
	}
	@Test
	public void testSetPrice() {
		l.setPrice("x");
		Assert.assertEquals("x", l.getPrice());
	}
	@Test
	public void testSetBedrooms() {
		l.setBedrooms("x");
		Assert.assertEquals("x", l.getBedrooms());
	}
	@Test
	public void testSetBathrooms() {
		l.setBathrooms("x");
		Assert.assertEquals("x", l.getBathrooms());
	}
	@Test
	public void testSetSquareFootage() {
		l.setSquareFootage("x");
		Assert.assertEquals("x", l.getSquareFootage());
	}
	@Test
	public void testSetPricingSchedule() {
		l.setPricingSchedule("x");
		Assert.assertEquals("x", l.getPricingSchedule());
	}
	@Test
	public void testSetLocation() {
		l.setLocation("x");
		Assert.assertEquals("x", l.getLocation());
	}
	@Test
	public void testSetFurnished() {
		l.setFurnished("x");
		Assert.assertEquals("x", l.getFurnished());
	}
	@Test
	public void testSetBuildingPrice() {
		l.setBuildingType("x");
		Assert.assertEquals("x", l.getBuildingType());
	}
	@Test
	public void testDeepCopy() {
		Listing i = l.deepCopy();
		Assert.assertTrue(i.toString().equals(l.toString()));
	}

}
