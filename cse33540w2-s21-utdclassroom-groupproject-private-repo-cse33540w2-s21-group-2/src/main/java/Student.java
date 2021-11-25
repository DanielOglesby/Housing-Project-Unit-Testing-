import java.util.ArrayList;

public class Student extends User
{
   
    private String major;
    private String graduationDate;
    private char gender;
    private String aboutMe;
    private ArrayList<Application> appList;


    public Student () {
        super();
        appList = new ArrayList<Application>();
    }


    // constructor for student object from file
    public Student(String userID, String firstName, String lastName, 
                    String email, String phoneNo,
                    String major, String graduationDate, char gender, 
                    String aboutMe, ArrayList<Application> studentApplications)
      {
        super (userID, firstName, lastName, email, phoneNo);
        this.major = major;
        this.graduationDate = graduationDate;
        this.gender = gender;
        this.aboutMe = aboutMe;
        if(!(studentApplications == null))
            appList = studentApplications;
        else
            appList = new ArrayList<Application>();
    } // end constructor




    /**
     *  Method to set Target Key
     */
    public String getKey()
    {
        return userID;
    }

    /**
     * Method to Compare Target Key
     */
    public int compareTo(String targetKey)
    {
        return(userID.compareTo(targetKey));
    }

    /**
     * Method for Data Encapsulation
     */
    public Student deepCopy(){

        Student clone = new Student (userID,firstName, lastName, email,  phoneNo, major, graduationDate,gender, 
        aboutMe, appList);
        return clone;
    }
    /**

/**
     * toString Method 
     *
     */
    @Override
    public String toString() {

        String str;
        str = "*********************************\n" +
              "******** Student Profile ********\n" +
              "*********************************\n" +
                "Student ID: " + userID + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phoneNo + "\n" +
                "Major: " + major + "\n" +
                "Graduation Date: " + graduationDate + "\n" +
                "About Me : " + aboutMe + "\n" +
                "Gender: " + gender + "\n\n" +
                "**********************************\n" +
                "****** Student Applications ******\n" +
                "**********************************\n";
        for (int i = 0; i < appList.size(); i++)
            str = str+appList.get(i).toString() + "\n";
        return str;
          
}

    // write student to file
/*    public String toFile()
    {
        return super.firstName + "," + super.lastName +
                "," + super.email + "," + super.phoneNo +
                "," + major + "," + graduationDate + "," + gender + "," + aboutMe +
                "," + appList.toString();
        }  // end student to file
*/

    public String applicantInfo() 
    {
        String str;
        str = "*********************************\n" +
              "******** Student Profile ********\n" +
              "*********************************\n" +
                "Student ID: " + userID + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phoneNo + "\n" +
                "Major: " + major + "\n" +
                "Graduation Date: " + graduationDate + "\n" +
                "About Me : " + aboutMe + "\n" +
                "Gender: " + gender + "\n\n";
        return str;
          
    }

    // setters -----------------------
    public void setMajor(String m)
    {
        major = m;
    } // end set major

    public void setGradDate(String d)
    {
        graduationDate = d;
    } // end set grad date

    public void setGender(char g)
    {
        gender = g;
    } // end set gender

    public void setAboutMe(String a)
    {
        aboutMe = a;
    } // end set about me
 
    public void setApp(Application app)
    {
        // add most recent to top of list
        appList.add(0, app);
    }


    // getters -----------------------
    public String getMajor()
    {
        return major;
    } // end get major

    public String getGradDate()
    {
        return graduationDate;
    } // end get grad date

    public char getGender()
    {
        return gender;
    } // end get gender

    public String getAboutMe()
    {
        return aboutMe;
    } // end get about me

    public ArrayList<Application> getApp()
    {
        return appList;
    } // end get appList


    // student apply to listing ---------------------------------
    public String applyToListing(String listingId)
    {
        Application app = new Application(Admin.newID('a'), listingId, applicantInfo());

        if (app.getAppId() != null)
        {
            appList.add(0, app);
            return "Application " + app.getAppId() + " has been submitted.";
        } // end successful application
        
        return "Submission failed.";
    } // end apply to listing

    // student save application ---------------------------------
    public String saveApplication(Application app)
    {
        // check if app already exists
        for (Application currApp : appList)
        {
            if (currApp.getAppId() == app.getAppId())
                appList.remove(currApp);
        } // end for app id

        // add app to list
        appList.add(0, app);
        return "Application " + app.getAppId() + " saved.\n";
    } // end save appliation

    /*
    // student update application -------------------------------
    public Application updateApplication(String appId)
    {
        for (Application app : appList)
        {
            if (app.getAppId() == appId)
                return app;
        } // end for app id

        return null;
    } // end update application
    */
    /*
    // student delete application -------------------------------
    public String deleteApplication(String appId)
    {
        for (Application app : appList)
        {
            if (app.getAppId() == appId)
                if (appList.remove(app))
                    return "Application " + appId + " deleted.\n";
        } // end for app id

        return "Application " + appId + " not found.\n";
    } // end delete application
    */



} // end Student class
