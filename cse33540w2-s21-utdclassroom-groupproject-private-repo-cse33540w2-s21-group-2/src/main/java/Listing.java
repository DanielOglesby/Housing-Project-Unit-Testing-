import java.util.ArrayList;

public class Listing{
    private String price;
    private String pricingSchedule;
    protected String location;
    private String buildingType;
    protected String bedrooms;
    protected String bathrooms;
    private String squareFootage;
    private String furnished; // false = unfurnished, true = furnished
    private String status; // false status = rejected, true status = approved
    protected String listingID;
    private ArrayList<Application> appList;

    
    
    
    public Listing (){
       
      }
    
    
    
    public Listing(String listingID,String pr, String schedule, String loc, String builType,String bed, String bath,String sqft, String furn, String stat,ArrayList<Application> studentApplications) {
        this.listingID = listingID;
        this.price = pr;
        this.pricingSchedule = schedule;
        this.location = loc;
        this.buildingType = builType;
        this.bedrooms = bed;
        this.bathrooms = bath;
        this.squareFootage = sqft;
        this.furnished = furn;
        this.status = stat;
        if(!(studentApplications == null))
            appList = studentApplications;
    }





    public String getPrice() {
        return price;
    }
    public String getPricingSchedule() {
        return pricingSchedule;
    }
    public String getLocation() {
        return location;
    }
    public String getBuildingType() {
        return buildingType;
    }
    public String getBedrooms() {
        return bedrooms;
    }
    public String getBathrooms() {
        return bathrooms;
    }
    public String getSquareFootage() {
        return squareFootage;
    }
    public String getFurnished() {
        return furnished;
    }
    public String getStatus() {
        return status;
    }
    
    public void setPrice(String x) {
        price = x;
    }
    public void setPricingSchedule(String x) {
        pricingSchedule = x;
    }
    public void setLocation(String x) {
        location = x;
    }
    public void setBuildingType(String x) {
        buildingType = x;
    }
    public void setBedrooms(String x) {
        bedrooms = x;
    }
    public void setBathrooms(String x) {
        bathrooms = x;
    }
    public void setSquareFootage(String x) {
        squareFootage = x;
    }
    public void setFurnished(String x) {
        furnished = x;
    }
    public void setStatus(String x) {
        status = x;
    }
    
         public Listing deepCopy()
    {
        Listing clone = new Listing( listingID,price, pricingSchedule,location, buildingType,
                                    bedrooms,bathrooms,squareFootage, furnished,status, appList);
                return clone;
    }


    /**
     * toString Method to Listing Class
     */
    public String toString() {
        String str;
        str = "**********************************\n" +
              "********* Owner Listings *********\n" +
              "**********************************\n" +
                "Listing ID: " +listingID+ "\n" +
                "Price: " +price + "\n" +
                "Pricing Schedule: " +pricingSchedule + "\n" +
                "Location: " +location + "\n" +
                "Bedrooms: " +bedrooms + "\n" +
                "Bathrooms: " +bathrooms + "\n" +
                "SQF: " +squareFootage + "\n" +
                "Furnished: " +furnished+ "\n" ;

        for (int i = 0; i < appList.size(); i++)
            str = str+appList.get(i).toString() + "\n";
        return str;
    }



    // Update this method
    public String getListingID() {
        return listingID;
    }
}

    
