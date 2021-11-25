import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author Abimbola Omoyola
 * @version 4/15/2021
 */
public class Application {
    private static Date dateApplied;
    private String applicationID;
    private String listingID;
    private String applicantInfo;

    /**
     * No Arg Constructor for objects of class Application
     */
    public Application()
    {
      Application.dateApplied = Calendar.getInstance().getTime();
       
    }
    
    /**
     * Arg Constructor for objects of class Application
     */
    public Application(String appID)
    {
       Application.dateApplied = Calendar.getInstance().getTime();
       this.applicationID = appID;
       
    }

    public Application(String appID, String listingId, String applicant)
    {
        Application.dateApplied = Calendar.getInstance().getTime();
        this.applicationID = appID;
        this.listingID = listingId;
        this.applicantInfo = applicant;
    }
    
    /**
     * Accessor Method for Application ID
     *
     */
    public String getAppId(){
        
       return applicationID;
       
    }

    public Application deepCopy()
    {
        Application clone = new Application( applicationID);
        return clone;
    }

    
    /**
     * Accessor Method for Date Applied
     *
     */
    public String getDateApplied(){
       
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String DateAsString = df.format(dateApplied);
        return DateAsString;
        
    }
    
    /**
     * toString Method to Application Class
     * To be Displayed after a sucessful Application
     *
     */
    public String toString() {
        return  ( "------------Application(s)------------: \n"+
                  "Application Date: " + dateApplied + "\n" +
                  "Application ID: " +applicationID );
    }

}
